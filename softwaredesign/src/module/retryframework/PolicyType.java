package module.retryframework;

import java.util.function.Supplier;

public class PolicyType {

	
	
	public static final Supplier<ExponentialBackoffPolicyBuilder> ExponentialBackoffFactory = ExponentialBackoffPolicyBuilder::new;
	
	
	public static final class ExponentialBackoff {
		public static ExponentialBackoffPolicyBuilder builder() {
			return new ExponentialBackoffPolicyBuilder();
		}
	}
	
	public static final class FixedBackoff {
		public static FixedBackoffPolicyBuilder builder() {
			return new FixedBackoffPolicyBuilder();
		}
	}
	
	
	
	/*ExponentialBackoff {
		//@Override
		public ExponentialBackoffPolicyBuilder builder() {
			// TODO Auto-generated method stub
			return null;
		}
	};*/
	
	

}
