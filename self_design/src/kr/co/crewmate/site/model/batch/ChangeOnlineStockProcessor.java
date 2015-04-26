package kr.co.crewmate.site.model.batch;

import java.util.List;

import kr.co.crewmate.site.config.Config;
//import kr.co.crewmate.site.model._interface.StockParam;
//import kr.co.crewmate.site.service.InterfaceService;

/**
 * 클래스명: <code>ChangeOnlineStockProcessor</code>
 *
 * <pre>
 *  재고처리 프로세서
 * </pre>
 *
 * @author 이경연
 * @date 2013. 8. 14.
 *
 */
//public class ChangeOnlineStockProcessor extends Processor {
//
//    private InterfaceService interfaceService;
//
//    public ChangeOnlineStockProcessor(InterfaceService interfaceService) {
//        this.interfaceService = interfaceService;
//    }
//
//    @Override
//    public void execute() {
//        this.interfaceService.moveStockInterface();
//        List<StockParam> stocks = this.interfaceService.getMisStockFoNoProcess();
//        String systemAdminId = Config.getSystemAdminId();
//        for (StockParam stock: stocks) {
//            stock.setAdminId(systemAdminId);
//            this.interfaceService.updateOnlineStock(stock);
//        }
//        this.interfaceService.updateMisStockNoRef();
//    }
//
//    public InterfaceService getInterfaceService() {
//        return interfaceService;
//    }
//
//    public void setInterfaceService(InterfaceService interfaceService) {
//        this.interfaceService = interfaceService;
//    }
//
//}
