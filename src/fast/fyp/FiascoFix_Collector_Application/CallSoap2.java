package fast.fyp.FiascoFix_Collector_Application;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class CallSoap2 {

	public final String SOAP_ACTION = "http://tempuri.org/Add1";

	public final String OPERATION_NAME = "Add1";

	public final String WSDL_TARGET_NAMESPACE = "http://tempuri.org/";

	public final String SOAP_ADDRESS = "http://10.0.2.2/Android_net/Service.asmx";

	public CallSoap2() {
	}

	public String Call2(String a) {
		SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,
				OPERATION_NAME);
		PropertyInfo pi = new PropertyInfo();
		pi.setName("a");
		pi.setValue(a);
		pi.setType(Integer.class);
		request.addProperty(pi);
		

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;

		envelope.setOutputSoapObject(request);

		HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
		Object response = null;
		try {
			httpTransport.call(SOAP_ACTION, envelope);
			response = envelope.getResponse();
		} catch (Exception exception) {
			response = exception.toString();
		}
		return response.toString();
	}
}
