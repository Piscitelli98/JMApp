
package org.perego.com;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.perego.com package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SetNomeCircolare_QNAME = new QName("http://com.perego.org/", "set_nomeCircolare");
    private final static QName _SetNomeCircolareResponse_QNAME = new QName("http://com.perego.org/", "set_nomeCircolareResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.perego.com
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SetNomeCircolareResponse }
     * 
     */
    public SetNomeCircolareResponse createSetNomeCircolareResponse() {
        return new SetNomeCircolareResponse();
    }

    /**
     * Create an instance of {@link SetNomeCircolare }
     * 
     */
    public SetNomeCircolare createSetNomeCircolare() {
        return new SetNomeCircolare();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetNomeCircolare }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.perego.org/", name = "set_nomeCircolare")
    public JAXBElement<SetNomeCircolare> createSetNomeCircolare(SetNomeCircolare value) {
        return new JAXBElement<SetNomeCircolare>(_SetNomeCircolare_QNAME, SetNomeCircolare.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetNomeCircolareResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.perego.org/", name = "set_nomeCircolareResponse")
    public JAXBElement<SetNomeCircolareResponse> createSetNomeCircolareResponse(SetNomeCircolareResponse value) {
        return new JAXBElement<SetNomeCircolareResponse>(_SetNomeCircolareResponse_QNAME, SetNomeCircolareResponse.class, null, value);
    }

}
