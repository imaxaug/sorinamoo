package kr.co.crewmate.site.model.batch;

import java.util.Date;

import kr.co.crewmate.site.aop.BatchAspect;
import kr.co.crewmate.site.config.Config;
//import kr.co.crewmate.site.service.BatchHistoryService;
import kr.co.crewmate.site.utils.Utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 클래스명: <code>Processor</code>
 *
 * <pre>
 *  프로세서(배치는 한트랜잭션으로 이루어 져야하지만 상황에따라 배치에 기간이 길면
 *  트랜잭션 문제로 트랜잭션으로 짤라야할때 상속받아서 구현한다)
 *
 *  시스템 시작시에 배치히스토리에 저장하고
 *  시스템종료시에 결과를 저장한다.(BatchAOP와 같은 동작원리 단 클래스명을 키로한다)
 * </pre>
 *
 * @author 이경연
 * @date 2012. 5. 21.
 *
 */
public abstract class Processor {

    Log log = LogFactory.getLog(this.getClass());

//    public abstract void execute();

//    private void executeProcess(BatchHistoryService batchHistoryService, String methodName) {
//        BatchHistory history = new BatchHistory();
//        history.setId(methodName);
//
//        try {
//            insertBatchHistory(batchHistoryService, history);
//            execute();
//            history.setStatusGbn(BatchAspect.GUBUN_SUCCESS);
//        } catch (Throwable e) {
//            if (log.isErrorEnabled()) {
//                log.error(e.getMessage(), e);
//            }
//
//            history.setStatusGbn(BatchAspect.GUBUN_FAIL);
//            history.setExecuteFailureReason(Utils.getExceptionTraceToString(e.getCause()));
//        } finally {
//            history.setEndDatetime(new Date());
//            batchHistoryService.updateBatchHistory(history);
//        }
//
//    }
//
//    private void insertBatchHistory(BatchHistoryService systemService, BatchHistory history) {
//        history.setStartDatetime(new Date());
//        history.setStatusGbn(BatchAspect.GUBUN_PROCESSING);
//        systemService.insertBatchHistory(history);
//    }
//
//    public void execute(BatchHistoryService batchHistoryService, Class<?> clazz) {
//        Boolean developer = Config.getBoolean("is.developer");
//        if (developer) {
//            if (log.isDebugEnabled()) {
//                // log.debug("[개발자피씨배치] 개발자 피씨에서는 배치를 돌리지 않는다.");
//            }
//        } else {
//            String batchId = clazz.getName();
//            executeProcess(batchHistoryService, StringUtils.substring(batchId, batchId.lastIndexOf('.') + 1));
//        }
//    }
}
