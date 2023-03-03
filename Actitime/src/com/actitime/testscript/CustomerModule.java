package com.actitime.testscript;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;
import com.actitime.generic.FileLib;
import com.actitime.pom.HomePage;
import com.actitime.pom.TaskListPage;
@Listeners(com.actitime.generic.ListenerImplementation.class)
public class CustomerModule extends BaseClass{
	@Test

public void testCreateCustomer() throws InterruptedException, IOException {
		FileLib f=new FileLib();
		String customerName = f.getExcelData("createCustomer", 1, 2);
		String customerDesc = f.getExcelData("createCustomer", 1, 3);
		HomePage h=new HomePage(driver);
		h.setTasks();
		TaskListPage t=new TaskListPage(driver);
		t.getAddNewBtn().click();
		t.getNewCustomer().click();
		t.getEnterCustomerNameTbx().sendKeys(customerName);
		t.getEnterCustomerDescription().sendKeys(customerDesc);
		t.getSelectCustomerDD().click();
		t.getOurCompanyTx().click();
		t.getCreateCustomerBtn().click();
		String actualCreated = t.getActualCustomerCreated().getText();
		if(customerName.equals(actualCreated)) {
			System.out.println("Customer is created");
		}
		else
		System.out.println(actualCreated);
	}
}