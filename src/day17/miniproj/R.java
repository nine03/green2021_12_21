package miniproj;

import java.util.ArrayList;

import miniproj.model.AddressbookVo;
import miniproj.view.DeleteView;
import miniproj.view.ErrorView;
import miniproj.view.ImportView;
import miniproj.view.InputView;
import miniproj.view.MenuView;
import miniproj.view.AddressbookView;
import miniproj.view.PrintOneView;
import miniproj.view.PrintView;
import miniproj.view.SearchView;
import miniproj.view.UpdateView;

public class R {
	public static int num = 1;
	public static int no;
	public static int idx;
	public static AddressbookVo AddressbookVo;
	public static ArrayList<AddressbookVo> AddressbookList;
	
	
	public static final AddressbookView MENU = new MenuView();
	public static final AddressbookView INPUT = new InputView();
	public static final AddressbookView PRINT = new PrintView();
	public static final AddressbookView PRINTONE = new PrintOneView();
	public static final AddressbookView SEARCH = new SearchView();
	public static final AddressbookView DELETE = new DeleteView();
	public static final AddressbookView UPDATE = new UpdateView();
	public static final AddressbookView IMPORT = new ImportView();
	public static final AddressbookView ERROR = new ErrorView();
	
}
