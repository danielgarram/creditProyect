
/**
 * CreditServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package edu.itq.soa.credit;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import edu.itq.soa.amTable.AmortizationServiceStub;
import edu.itq.soa.buroCheck.BuroCheckServiceStub;

/**
 * CreditServiceSkeleton java skeleton for the axisService
 */
public class CreditServiceImpl extends CreditServiceSkeleton{

    /**
     * Auto generated method signature
     * 
     * @param request
     * @return response
     * @throws RemoteException 
     */
    AmortizationServiceStub amortizationServiceStub;
    BuroCheckServiceStub buroCheckServiceStub;
    
    public Response creditOperation(Request request) {
        // TODO : fill this with the necessary business logic
        Ack_type0 ack = new Ack_type0();
        Response response = new Response();
        try {
            ack.setId("200");
            ack.setDescription("Credito valido");
            response.setAck(ack);
            BuroCheckServiceStub.Request requestBuro = new BuroCheckServiceStub.Request();
            BuroCheckServiceStub.Tarjeta tarjeta = BuroCheckServiceStub.Tarjeta.Factory.fromString(request.getNoTarjeta().getTarjeta(),"");
            requestBuro.setNoTarjeta(tarjeta);
            BuroCheckServiceStub.Response responseBuro = buroCheckServiceStub.buroCheckOperation(requestBuro);
            if(responseBuro.getValid()) {
                //response.setMessage("valido");
                AmortizationServiceStub.Request requestAmor = new AmortizationServiceStub.Request();
                requestAmor.setInterest(request.getInteres());
                requestAmor.setQuantiti((float)request.getMonto());
                requestAmor.setTime(request.getPlazo());
                requestAmor.setRfc(request.getRfc());
                
                AmortizationServiceStub.Response responseAmor = amortizationServiceStub.amortizationOperation(requestAmor);
                responseAmor.getAmortizationTable().getAmortization();
                AmortizationServiceStub.Amortization_type0[] filas_amor = responseAmor.getAmortizationTable().getAmortization();
                AmortizationTable_type0 amTable = new AmortizationTable_type0();
                for (AmortizationServiceStub.Amortization_type0 fila : filas_amor) {
                    Amortization_type0 amortization = new Amortization_type0();
                    amortization.setCapital(fila.getCapital());
                    amortization.setMontoMensual(fila.getMontoMensual());
                    amortization.setPagoCapital(fila.getPagoCapital());
                    amortization.setPagoInteres(fila.getPagoInteres());
                    amortization.setPeriodo(fila.getPeriodo());
                    amTable.addAmortization(amortization);
                }
                response.setAmortizationTable(amTable);
            } else {
                ack.setId("403");
                ack.setDescription("Credito no valido");
                response.setAck(ack);
                throw new Exception ("Credito no valido");
            }
        } catch (AxisFault e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return response;
    }

    /**
     * @param amortizationServiceStub the amortizationServiceStub to set
     */
    public void setAmortizationServiceStub(AmortizationServiceStub amortizationServiceStub) {
        this.amortizationServiceStub = amortizationServiceStub;
    }

    /**
     * @param buroCheckServiceStub the buroCheckServiceStub to set
     */
    public void setBuroCheckServiceStub(BuroCheckServiceStub buroCheckServiceStub) {
        this.buroCheckServiceStub = buroCheckServiceStub;
    }
}
