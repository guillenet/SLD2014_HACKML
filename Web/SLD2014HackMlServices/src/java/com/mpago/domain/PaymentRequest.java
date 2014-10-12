package com.mpago.domain;

public class PaymentRequest {
	
	private String _clientId = "3658591962082015";
	private String _clientSecret = "932HWR9vN2mDyV9UpYzQjdX7p34uU0h7";
	private String _payerEmail;
	
	public String getClientId() {
		return _clientId;
	}
	
	public String getClientSecret() {
		return _clientSecret;
	}
	
	public String getPayerEmail() {
		return _payerEmail;
	}
	
	public void setPayerEmail(String payerEmail) {
		_payerEmail = payerEmail;
	}

        /**
         * @param clientId the _clientId to set
         */
        public void setClientId(String clientId) {
            this._clientId = clientId;
        }

        /**
         * @param clientSecret the _clientSecret to set
         */
        public void setClientSecret(String clientSecret) {
            this._clientSecret = clientSecret;
        }
	
	
	
}
