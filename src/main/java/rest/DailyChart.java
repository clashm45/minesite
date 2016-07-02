package rest;

import lombok.Data;

/**
 * 日足
 */
@Data
public class DailyChart {
	/**
	 * 日付
	 */
	private String date;
	/**
	 * 始値
	 */
	private double open;
	/**
	 * 高値
	 */
	private double high;
	/**
	 * 安値
	 */
	private double low;
	/**
	 * 終値
	 */
	private double close;
	/**
	 * 出来高
	 */
	private double volume;
	/**
	 * 売買代金
	 */
	private double turnover;
}
