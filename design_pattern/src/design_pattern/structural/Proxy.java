package design_pattern.structural;

/*
 * Proxy is a structural design pattern that lets you provide a substitute or placeholder for another object. 
 * A proxy controls access to the original object, allowing you to perform something 
 * either before or after the request gets through to the original object.
 * 
 * Type of proxies : 
 * Remote Proxy -
 * With Remote Proxy, the proxy acts as a local representative for an object that lives in a different JVM. 
 * A method call on the proxy results in the call being transferred over the wire, invoked remotely, 
 * and the result being returned back to the proxy and then to the Client.
 * In remote proxy you create stub classes at client side to interact over the network with the Skeleton of main service class.
 * java rmi is a type of remote proxy
 * 
 * Virtual Proxy -
 * acts as a representative for an object that may be expensive to create. 
 * The Virtual Proxy often defers the creation of the object until it is needed; the Virtual Proxy 
 * also acts as a surrogate for the object before and while it is being created. 
 * After that, the proxy delegates requests directly to the RealSubject.
 * 
 * Note : Proxies can be used in case real subject takes time to instantiate (Virtual Proxy), some protection is needed from unwanted access (Protection Proxy),
 * or hide the fact that the subject in running on remote machines (Remote Proxy).
 *
 * 
 * Note:
 * Adapter provides a different interface to the wrapped object, Proxy provides it with the same interface
 */
public class Proxy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
