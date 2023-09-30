package amazontest;

import java.io.IOException;

import org.testng.annotations.Test;


import testbase.Testbase;

public class Amazooon extends Testbase{
  

  @Test
  public void verifyamazonhom() throws InterruptedException, IOException {
	  
	  
	  homepageobj.verifylogo();
	
	  homepageobj.dropdown();
	  
	  homepageobj.searchbar();
	  
	  
	
	  homepageobj.searchbutton();
	  
	  
	  
	 
	  
	  homepageobj.verifymob();
	  homepageobj.flip();
	  
	  
  }
}
