import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import ch.qos.logback.core.joran.conditional.ElseAction
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import java.util.Arrays as Arrays

RunConfiguration.setWebDriverPreferencesProperty('args', Arrays.asList('--disable-notifications'))

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://www.facebook.com/login/')

WebUI.setText(findTestObject('Object Repository/Page_Log in to Facebook/input_Log in to Facebook_email'), 'zcamdalls11a@gmail.com')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Log in to Facebook/input_Log in to Facebook_pass'), 'zGj7y75Erc/gIHrL1x4ICQ==')

WebUI.click(findTestObject('Object Repository/Page_Log in to Facebook/button_Log in'))

//'to input captcha manually'
//WebUI.delay(15)

TestObject error_message = findTestObject('Object Repository/Page_Log in to Facebook/error_message')

if (WebUI.verifyElementPresent(error_message, 5, FailureHandling.OPTIONAL)) {
	WebUI.comment('Login gagal : ')
	String error_text = WebUI.getText(error_message)
	WebUI.comment('Pesan error: '+error_text)
} else {
	WebUI.comment('Login berhasil : ')
}

