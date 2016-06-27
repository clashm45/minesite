package rest;

import lombok.Data;

@Data
public class Kosu {

	/**
	 * 社員番号
	 */
	private String id;
	/**
	 * 氏名
	 */
	private String name;
	/**
	 * 日付
	 */
	private String date;
	/**
	 * ジョブNo
	 */
	private String jobNo;
	/**
	 * 作業コード
	 */
	private String workCode;
	/**
	 * 作業時間
	 */
	private String workingTime;
}
