
package org.perego.com;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "circolari", targetNamespace = "http://com.perego.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Circolari {


    /**
     * 
     * @param nomeDocumento
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "set_nomeCircolare")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "set_nomeCircolare", targetNamespace = "http://com.perego.org/", className = "org.perego.com.SetNomeCircolare")
    @ResponseWrapper(localName = "set_nomeCircolareResponse", targetNamespace = "http://com.perego.org/", className = "org.perego.com.SetNomeCircolareResponse")
    @Action(input = "http://com.perego.org/circolari/set_nomeCircolareRequest", output = "http://com.perego.org/circolari/set_nomeCircolareResponse")
    public String setNomeCircolare(
        @WebParam(name = "nomeDocumento", targetNamespace = "")
        String nomeDocumento);

}
