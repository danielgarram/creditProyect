
/**
 * AmortizationServiceMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
        package edu.itq.soa.amtable;

        /**
        *  AmortizationServiceMessageReceiverInOut message receiver
        */

        public class AmortizationServiceMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver{


        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(msgContext);

        AmortizationServiceSkeleton skel = (AmortizationServiceSkeleton)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)){


        

            if("amortizationOperation".equals(methodName)){
                
                edu.itq.soa.amtable.Response response5 = null;
	                        edu.itq.soa.amtable.Request wrappedParam =
                                                             (edu.itq.soa.amtable.Request)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.itq.soa.amtable.Request.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               response5 =
                                                   
                                                   
                                                         skel.amortizationOperation(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), response5, false, new javax.xml.namespace.QName("http://itq.edu/soa/amTable",
                                                    "amortizationOperation"));
                                    
            } else {
              throw new java.lang.RuntimeException("method not found");
            }
        

        newMsgContext.setEnvelope(envelope);
        }
        }
        catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
        }
        
        //
            private  org.apache.axiom.om.OMElement  toOM(edu.itq.soa.amtable.Request param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.itq.soa.amtable.Request.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.itq.soa.amtable.Response param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.itq.soa.amtable.Response.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.itq.soa.amtable.Response param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.itq.soa.amtable.Response.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.itq.soa.amtable.Response wrapamortizationOperation(){
                                edu.itq.soa.amtable.Response wrappedElement = new edu.itq.soa.amtable.Response();
                                return wrappedElement;
                         }
                    


        /**
        *  get the default envelope
        */
        private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory){
        return factory.getDefaultEnvelope();
        }


        private  java.lang.Object fromOM(
        org.apache.axiom.om.OMElement param,
        java.lang.Class type,
        java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{

        try {
        
                if (edu.itq.soa.amtable.Request.class.equals(type)){
                
                           return edu.itq.soa.amtable.Request.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.itq.soa.amtable.Response.class.equals(type)){
                
                           return edu.itq.soa.amtable.Response.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    

        /**
        *  A utility method that copies the namepaces from the SOAPEnvelope
        */
        private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
        org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
        returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
        }
        return returnMap;
        }

        private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();
        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }

        }//end of class
    