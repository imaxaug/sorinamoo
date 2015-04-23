package kr.co.crewmate.site.aop;

import java.util.Date;

import javax.inject.Inject;

import kr.co.crewmate.site.config.Config;
import kr.co.crewmate.site.model.batch.BatchHistory;
//import kr.co.crewmate.site.service.BatchHistoryService;
import kr.co.crewmate.site.utils.Utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 *
 * 클래스명: <code>BatchAspect</code>
 *
 * <pre>
 *  배치AOP
 *  BatchService를 캐치하게된다.
 *
 *  시스템의 메소드명을 키값으로(Processor가 존재할때는 Processor클래스명을 배치아이디로 사용한다)
 *      TB_BATCH_MASTER,
 *      TB_BATCH_HISTORY에 데이터를 입력한다.
 * </pre>
 *
 * @author 이경연
 * @date 2012. 5. 18.
 *
 */
public class BatchAspect {

    private final Log log = LogFactory.getLog(LoggingAspect.class);

    /**
     * 진행중
     */
    public static final String GUBUN_PROCESSING = "P";

    /**
     * 성공
     */
    public static final String GUBUN_SUCCESS = "S";

    /**
     * 실패
     */
    public static final String GUBUN_FAIL = "F";

//    @Inject
//    private BatchHistoryService batchHistoryService;

    /**
     * <pre>
     * AOP JoinPointCut
     *
     * 1. is.developer를 체크 Y값일때는 배치를 실행하지않는다.
     * 2. BatchMaster를 입력한다.
     * 3. 만약 오류가났다면 BatchMaster에는 이미값이 있는 경우이므로 무시한다.
     * 4. 배치히스토리에 진행중으로 데이터를 입력한다.
     * 5. 종료후 Throwable여부에 따라 성공과 실패로 업데이트 해준다.
     * </pre>
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    public Object serviceChecker(ProceedingJoinPoint joinPoint) throws Throwable {
        Boolean developer = Config.getBoolean("is.developer");
        if (developer) {
            /**


            if (log.isDebugEnabled()) {
                log.debug("[개발자피씨배치] 개발자 피씨에서는 배치를 돌리지 않는다.");
            }
            */

            return null;
        }

        String methodName = joinPoint.getSignature().getName();
        BatchHistory history = new BatchHistory();
        history.setId(methodName);

        try {
            insertBatchHistory(history);
            return executeBatch(history, joinPoint);
        } catch (Throwable e) {
            if (log.isErrorEnabled()) {
                log.error(e.getMessage(), e);
            }

            history.setStatusGbn(GUBUN_FAIL);
            history.setExecuteFailureReason(Utils.getExceptionTraceToString(e));

            throw e;
        } finally {
            history.setEndDatetime(new Date());
//            this.batchHistoryService.updateBatchHistory(history);
        }
    }

    private Object executeBatch(BatchHistory history, ProceedingJoinPoint joinPoint) throws Throwable {
        Object o = joinPoint.proceed();
        history.setStatusGbn(GUBUN_SUCCESS);
        return o;
    }

    private void insertBatchHistory(BatchHistory history) {
        history.setStartDatetime(new Date());
        history.setStatusGbn(GUBUN_PROCESSING);
//        this.batchHistoryService.insertBatchHistory(history);
    }
}
