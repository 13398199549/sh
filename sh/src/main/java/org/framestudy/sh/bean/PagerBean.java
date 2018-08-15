package org.framestudy.sh.bean;

import java.util.List;

public class PagerBean {

	private int page;//当前页码
	private int rows;//每页行数
	private int index;//起始位置
	private List<?> datas;
	private int totalRows;//满足条件的总条数
	private int totalPage;//满足条件的总页数
	public PagerBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PagerBean(int page, int rows) {
		super();
		this.page = page;
		this.rows = rows;
		index = (page - 1) * rows;
	}
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public List<?> getDatas() {
		return datas;
	}
	public void setDatas(List<?> datas) {
		this.datas = datas;
	}
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
		totalPage = (totalRows % rows) ==0 ? (totalRows / rows) : (totalRows / rows) + 1;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	@Override
	public String toString() {
		return "PagerBean [page=" + page + ", rows=" + rows + ", datas=" + datas + ", totalRows=" + totalRows
				+ ", totalPage=" + totalPage + "]";
	}
}
