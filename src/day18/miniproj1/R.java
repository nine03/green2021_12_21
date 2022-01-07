package miniproj1;

import java.util.ArrayList;

import miniproj1.controller.AddressbookController;
import miniproj1.model.AddressbookVo;
import miniproj1.view.DeleteView;
import miniproj1.view.DetailView;
import miniproj1.view.EditView;
import miniproj1.view.InsertView;
import miniproj1.view.ListView;
import miniproj1.view.LoadView;
import miniproj1.view.MenuView;
import miniproj1.view.SaveView;
import miniproj1.view.SearchView;
import miniproj1.view.View;


public class R {
	public static int choice;
	public static AddressbookVo AddressbookVo;
	public static ArrayList<AddressbookVo> AddressbookArr;
	public static String fileName;
	
	public static final View menu = new MenuView();
	public static final View insert = new InsertView();
	public static final View list = new ListView();
	public static final View search = new SearchView();
	public static final View detail = new DetailView();
	public static final View edit = new EditView();
	public static final View delete = new DeleteView();
	public static final View save = new SaveView();
	public static final View load = new LoadView();
	
	public static final AddressbookController controller = new AddressbookController();
}
