package cn.lynu.lyq.java_exam.common;

public enum ExamPhase {
	PAPER_INITIALIZED("试卷初始化"), FINAL_SCORED("最终得分");
	
	private String chineseName;
	private ExamPhase(String chineseName){
		this.chineseName = chineseName;
	}
	public String getChineseName(){
		return chineseName;
	}
}
