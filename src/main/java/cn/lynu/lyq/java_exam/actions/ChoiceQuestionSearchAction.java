package cn.lynu.lyq.java_exam.actions;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

import cn.lynu.lyq.java_exam.dao.BankQuestionDao;
import cn.lynu.lyq.java_exam.entity.BankChoiceQuestion;
@Component("choiceQuestionSearch")
@Scope("prototype")
public class ChoiceQuestionSearchAction extends ActionSupport{
	private static final long serialVersionUID = -1106576639902301220L;
	private String contentSearch;
	private String choiceSearch;
	private String answerSearch;
	private String answerSearch2;//对于checkbox不选时，不提交的问题，做判断修正
	private String knowledgeSearch;
	private List<BankChoiceQuestion> questionList;
	private int totalPage;
	private int pageIndex;
	private static final int PAGE_SIZE = 10;
	
	@Resource
	private BankQuestionDao bankQuestionDao;

	public String getContentSearch() {
		return contentSearch;
	}

	public void setContentSearch(String contentSearch) {
		System.out.println("setting contentSearch========================"+contentSearch);
		this.contentSearch = contentSearch;
	}

	public String getChoiceSearch() {
		return choiceSearch;
	}

	public void setChoiceSearch(String choiceSearch) {
		this.choiceSearch = choiceSearch;
	}

	public String getAnswerSearch() {
		return answerSearch;
	}

	public void setAnswerSearch(String answerSearch) {
		this.answerSearch = answerSearch;
	}

	public String getAnswerSearch2() {
		return answerSearch2;
	}
	
	public void setAnswerSearch2(String answerSearch2) {
		System.out.println("setting answerSearch2========================"+answerSearch2);
		this.answerSearch2 = answerSearch2;
	}
	
	public String getKnowledgeSearch() {
		return knowledgeSearch;
	}

	public void setKnowledgeSearch(String knowledgeSearch) {
		this.knowledgeSearch = knowledgeSearch;
	}

	public List<BankChoiceQuestion> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<BankChoiceQuestion> questionList) {
		this.questionList = questionList;
	}
	
	public int getTotalPage() {
		return totalPage;
	}
	
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	@Override
	public String execute() throws Exception {//初始结果
//		contentSearch="";
//		choiceSearch="";
//		answerSearch="";
//		answerSearch2="";
//		knowledgeSearch="";
		
//		questionList = bankQuestionDao.findAllChoice();
		
		int totalCnt = bankQuestionDao.countAllChoice();
		totalPage = (totalCnt%PAGE_SIZE > 0)?(totalCnt/PAGE_SIZE+1):(totalCnt/PAGE_SIZE);
		questionList = bankQuestionDao.findAllChoiceWithPage(pageIndex,PAGE_SIZE);
		return SUCCESS;
	}
	
	public String executeForSearch(){//搜索后结果
		if(answerSearch2!=null && answerSearch2.equals("")){//对于checkbox不选时，不提交的问题，做判断修正
			answerSearch = "";
		}
		System.out.println("contentSearch="+contentSearch);
		System.out.println("choiceSearch="+choiceSearch);
		System.out.println("answerSearch="+answerSearch);
		System.out.println("answerSearch2="+answerSearch2);
		System.out.println("knowledgeSearch="+knowledgeSearch);
		questionList = bankQuestionDao.findChoiceForSearch(contentSearch,choiceSearch,answerSearch,knowledgeSearch);
		return SUCCESS;
	}


}
