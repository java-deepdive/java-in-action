package kr.seok.payments;

public interface TransactionProcess {
	ResponseTransaction processTransaction(RequestTransaction requestTransaction);
}
