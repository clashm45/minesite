package common.model;

import org.mongodb.morphia.annotations.Entity;

import lombok.Data;

/**
 * 日足
 */
@Data
@Entity("dailyChart")
public class DailyChart {

	/**
	 * 会社名
	 */
	private String company;

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
