package cn.lfy.common.validator;

import cn.lfy.common.framework.exception.ServiceRuntimeException;
import cn.lfy.common.utils.Constants;

public class Assert {

	public static void notNull(Object ...objects){
		if(!(Validation.isNotNULL(objects))){
			//抛出异常
			throw new ServiceRuntimeException(Constants.BADREQ_PARAMETER_EXCEPTION);
		}
	}
}
