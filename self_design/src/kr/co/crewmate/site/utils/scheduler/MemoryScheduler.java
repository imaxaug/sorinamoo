package kr.co.crewmate.site.utils.scheduler;

import javax.inject.Inject;

import kr.co.crewmate.http.RequestImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MemoryScheduler {
    
    final Log log = LogFactory.getLog(RequestImpl.class);
    
    final static long sec = 1000;
    
    final static long min = sec * 60;
    
    final static long hour = min * 60;
    
    final static long day = hour * 24;

//    @Inject
//    SystemService systemService;
//    
//    @Inject
//    CategoryService categoryService;
//    
//    @Inject
//    MessageService messageService;
//    
//    @Inject
//    NaverService naverService;
//    
//    @Scheduled(fixedDelay = min * 30 + sec * 5)
//    public void reloadCode() {
//        this.systemService.reloadCodeHandler();
//    }
//    
//    @Scheduled(fixedDelay = min * 30 + sec * 10)
//    public void reloadCategory() {
//        this.categoryService.reloadCategoryHandler();
//    }
//    
//    @Scheduled(fixedDelay = min * 30 + sec * 15)
//    public void reloadMessage() {
//        this.messageService.reloadMessage();
//    }
//    
//    @Scheduled(fixedDelay = day * 30)
//    public void naverFileWrite() {
//        this.naverService.writeNaverVall();
//        this.naverService.writeNaverVsub();
//        this.naverService.writeNaverVsell();
//    }
//    
//    @Scheduled(cron = "0 35 7,9,11,13,15,17,19 * * *")
//    public void loadNaverSubEp() {
//        this.naverService.writeNaverVsub();
//    }
//    
//    /**
//     * <pre>
//     * 매일 35분
//     * 파일생성
//     * </pre>
//     */
//    @Scheduled(cron = "0 50 0 * * *")
//    public void writeNaverVall() {
//        this.naverService.writeNaverVall();
//    }

}
