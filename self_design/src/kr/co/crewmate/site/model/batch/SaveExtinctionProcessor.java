package kr.co.crewmate.site.model.batch;

import java.util.List;

import kr.co.crewmate.http.RequestSender;
import kr.co.crewmate.site.config.Config;
import kr.co.crewmate.site.model.system.MailQueue;
import kr.co.crewmate.site.model.user.User;
import kr.co.crewmate.site.service.MailService;
import kr.co.crewmate.site.service.MessageService;
import kr.co.crewmate.site.service.ScheduleService;
import kr.co.crewmate.site.service.UserService;


/**
 * 클래스명: <code>SaveExtinctionProcessor</code>
 *
 * <pre>
 *
 * </pre>
 *
 * @author 이경연
 * @date 2013. 8. 28.
 *
 */
public class SaveExtinctionProcessor extends Processor {

    MailService mailService;

//    ScheduleService scheduleService;

    UserService userService;

    MessageService messageService;

//    public SaveExtinctionProcessor(MailService mailService, ScheduleService scheduleService, UserService userService, MessageService messageService) {
//        this.mailService = mailService;
//        this.scheduleService = scheduleService;
//        this.userService = userService;
//        this.messageService = messageService;
//    }
//
//    @Override
//    public void execute() {
//        String url = String.format("%s/shop/template/savedExtinctionTemplate", Config.getServerHostForFront());
//        RequestSender sender = null;
//        List<String> userIds = this.scheduleService.getSaveExtinctionUserForNextMonth();
//        for (String userId: userIds) {
//            User user = this.userService.getUserByIdForce(userId);
//            MailQueue mailQueue = MailQueue.getInstance();
//            mailQueue.setReceiverName(user.getUserNameKor());
//            mailQueue.setReceiverMailAddress(user.getMailAddr());
//            mailQueue.setTitle(this.messageService.getMessageHandler().getMessage("mail.0007"));
//            sender = new RequestSender(url);
//            sender.addParameter("userId", userId);
//            sender.send();
//            mailQueue.setContent(sender.getResponseBody());
//
///*          if (log.isDebugEnabled()) {
//                log.debug(mailQueue);
//            }*/
//            this.mailService.saveMailQueue(mailQueue);
//        }
//    }
//
//    public MailService getMailService() {
//        return mailService;
//    }
//
//    public void setMailService(MailService mailService) {
//        this.mailService = mailService;
//    }
//
//    public ScheduleService getScheduleService() {
//        return scheduleService;
//    }
//
//    public void setScheduleService(ScheduleService scheduleService) {
//        this.scheduleService = scheduleService;
//    }
//
//    public UserService getUserService() {
//        return userService;
//    }
//
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
//
//    public MessageService getMessageService() {
//        return messageService;
//    }
//
//    public void setMessageService(MessageService messageService) {
//        this.messageService = messageService;
//    }

}
