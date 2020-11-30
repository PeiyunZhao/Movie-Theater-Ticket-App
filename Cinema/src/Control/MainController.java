package Control;

public class MainController {
	private LogisticsController logisticConrol;
	private PaymentController paymentControl;
	private DBController dbControl;
	private UserController userControl;

	public MainController() {
		dbControl = new DBController();
		userControl = new UserController();
		logisticConrol = new LogisticsController();
		paymentControl = new PaymentController();
	}
	
	public void DatabaseImport() {
		
	}

	public void DatabaseExport() {

	}

	public LogisticsController getLogisticConrol() {
		return logisticConrol;
	}

	public void setLogisticConrol(LogisticsController logisticConrol) {
		this.logisticConrol = logisticConrol;
	}

	public PaymentController getPaymentControl() {
		return paymentControl;
	}

	public void setPaymentControl(PaymentController paymentControl) {
		this.paymentControl = paymentControl;
	}

	public DBController getDbControl() {
		return dbControl;
	}

	public void setDbControl(DBController dbControl) {
		this.dbControl = dbControl;
	}

	public UserController getUserControl() {
		return userControl;
	}

	public void setUserControl(UserController userControl) {
		this.userControl = userControl;
	}
}
