package com.mpago.checkout;

import java.util.*;

import org.codehaus.jettison.json.*;

import com.mercadopago.MP;
import com.mpago.domain.*;

public class Payment
{
	private MP _mp;
	private String _payerInfo;
	private static int MAX_TRANSACTIONS = 20;
	
	public Payment(PaymentRequest paymentRequest)
	{
		_mp = new MP(paymentRequest.getClientId(), paymentRequest.getClientSecret());
		_payerInfo = paymentRequest.getPayerEmail();
	}

	private String performCheckOutAndPay(Item item)
	{
		String checkoutURL = "";
		try {

			JSONObject preference = _mp.createPreference("{'items':[{'title':'"
					+ item.getDescripcion()
					+ "','quantity':1,'currency_id':'ARS','unit_price':"
					+ item.getPrecio() + ", 'category_id':'others'}]," + "'payer': {"
					+ "'email':'"+ _payerInfo +"'}}");

			checkoutURL = preference.getJSONObject("response").getString(
					"sandbox_init_point");

		} catch (JSONException e) {
			return checkoutURL;
		} catch (Exception e) {
			return checkoutURL;
		}
		return checkoutURL;
	}
	
	public String performPayment(Item item)
	{
		return performCheckOutAndPay(item);
	}
	
	public ArrayList<Transaction> retrieveLastTransactions(String payerEmail) throws JSONException, Exception
	{
		Map<String, Object> filters = new HashMap<String, Object>();
		filters.put("payer_email", payerEmail);

		// Search payment data according to filters
		JSONObject searchResult = _mp.searchPayment(filters);
		JSONArray results = searchResult.getJSONObject("response")
				.getJSONArray("results");

		ArrayList<Transaction> transactions = new ArrayList<Transaction>(
				results.length());

		for (int i = 0; i < results.length() && i < MAX_TRANSACTIONS; i++) {
			Transaction trans = new Transaction();
			trans.setId(results.getJSONObject(i).getJSONObject("collection")
					.getString("id"));
			trans.setDateCreated(results.getJSONObject(i)
					.getJSONObject("collection").getString("date_created"));
			trans.setDateApproved(results.getJSONObject(i)
					.getJSONObject("collection").getString("date_approved"));
			trans.setExternalReference(results.getJSONObject(i)
					.getJSONObject("collection")
					.getString("external_reference"));
			trans.setDescription(results.getJSONObject(i)
					.getJSONObject("collection").getString("reason"));
			trans.setTotalPaid(results.getJSONObject(i)
					.getJSONObject("collection").getString("total_paid_amount"));
			trans.setShipCost(results.getJSONObject(i)
					.getJSONObject("collection").getString("shipping_cost"));
			trans.setStatus(results.getJSONObject(i)
					.getJSONObject("collection").getString("status"));
			trans.setPaymentType(results.getJSONObject(i)
					.getJSONObject("collection").getString("payment_type"));
			trans.setOperationType(results.getJSONObject(i)
					.getJSONObject("collection").getString("operation_type"));
			transactions.add(trans);
		}
		return transactions;
	}
	
/*	public static void main(String [ ] args)
	{
		PaymentRequest req = new PaymentRequest();
		req.setPayerEmail("tongacf@gmail.com");
		Item item = new Item("Masajista", "244.00");
		Payment payment = new Payment(req);
		System.out.println(payment.performCheckOutAndPay(item));
		
	}*/

}
