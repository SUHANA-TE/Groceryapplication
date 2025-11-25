package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void selectDragDropWithValue(WebElement element, String value) {
			Select object=new Select(element);
			object.selectByValue(value);
		}
	public void selectDragDropWithContainsVisibleText(WebElement element, String value) {
		Select object=new Select(element);
		object.selectByContainsVisibleText(value);
	}
	public void selectDragDropWithIndex(WebElement element, String value) {
		Select object=new Select(element);
		object.selectByIndex(0);
	}
	public void selectDragDropWithVisibleText(WebElement element, String value) {
		Select object=new Select(element);
		object.selectByVisibleText(value);
	}
	public void deselectDragDropWithDeselect(WebElement element, String value) {
		Select object=new Select(element);
		object.deselectAll();
	}
	public void deselectDragDropWithIndex(WebElement element, String value) {
		Select object=new Select(element);
		object.deselectByIndex(0);;
	}

}
