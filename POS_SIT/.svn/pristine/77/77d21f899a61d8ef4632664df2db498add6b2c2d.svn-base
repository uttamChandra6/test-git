    /* 
     * To change this template, choose Tools | Templates
     * and open the template in the editor.
     * 10/02/2016   Shaveta Rani     Bugzilla – Bug 59011 When set field as a mandatory its value not save during process execution.
     * 23/02/2016   Mohit Sharma     Bug 58977 - Form Entries are not saved
     * 02/03/2016   Mohit Sharma     Bug 59177 - Datepicker >> If checked mandatory checkbox, irrelevant information is showing in textbox   
     * 08/08/2016   Mohit Sharma     Bug 63558 - IBPS3.0(BPM+CM):-Special character not saved in table field . 
     * 13/12/2016   Mohit Sharma     Bug 66247 - Validation on submit button in ibps mobile form required 
     * 29/05/2017                                           Bug 69603 
     * 29/05/2017                                           Bug 69599
     * 21/08/2018   Karishma Rastogi Bug 75901 - JbossEAP7+SQL+IBPS4.0+Arabic:click on section's expend/collapse button section not shown only scroller shifted UP.
     * 01/03/2018   Karishma Rastogi Bug 75625 - JbossEAP+SQL+IBPS4.0+Arabic:Preview Form table checkbox and fields are not shown properly UI not shown properly.  
     *                               Bug 75897 - JbossEAP7+SQL+IBPS4.0+Arabic:Table control hide the sheet and frame header
     * 27/02/2018   Aman Khan        Bug 75588 - Suggestion: Listbox should be available in iForm 
     * 28/02/2018   Minakshi Sharma  Bug 75125 - Table > No validation message when user tries to input incorrect data in any cell
     * 06/03/2018   Mohit Sharma     Bug 75296 - Performance Issue: User picklist loading is slow & loading icon should be shown in case of slowness instead of blank page                                           
     * 08/03/2018   Aman Khan        Bug 74485 - Form Style > Input tab > For a theme, setting textarea/combobox/date picker to some other style(apear from style1) is not working
     * 11/03/2018             Gaurav Sharma          Bug 75527 - DBLinking should be available on events in iForm
     * 11/03/2018             Gaurav Sharma          Bug 75529 - Some commands/events for e.g: WFSave, WFClear etc. are not present in iForm
     * 11/03/2018           Aman Khan                Bug 75909 - Allow null, Formats, Column Total & Tool tip features are not available in column of Table
     * 11/03/2018           Aman Khan                Bug 75523 - No provision to configure duplicate value of column in table like ngf Form
     * 11/03/2018           Aman Khan                Bug 75592 - Suggestion: Digit Grouping & Encrypt features of TextBox should be available in iForm
     * 16/03/2018           Aman Khan                Bug 75592 - Suggestion: Digit Grouping & Encrypt features of TextBox should be available in iForm
     * 19/03/2018           Aman Khan               Bug 74459 - Form Style > Defects related to "Input" properties
     * 21/03/2018           Gaurav Sharma           WFRefreshInterface event is not working 
     * 21/03/2018           Gaurav Sharma           Bug 76652 - EAP6.4+SQL: Checkboxes get distorted and calendar is trimmed if opened from first three-four rows of table
     * 22/03/2018           Gaurav Sharma           Event configuration has not been provided in Listbox, Blank value updated in combo box and able to select it
     * 27/03/2018           gaurav Sharma           Bug 76751 - Auto complete command not working in event. 
     * 28/03/2018           Minakshi Sharma         Bug 76778 - AutoComplete not available with Combo
     * 28/03/2018           Gaurav Sharma           Bug 76737 - WFDone command not working getting error "The Requested filter is invalid"
     * 29/03/2018           Gaurav Sharma           Bug 76754 - JbossEAP+SQL:-Getfocus and Change events are not working 
     * 04/04/2018           Minakshi Sharma         Bug 76765 - DBlinking Feature Security Issue
     * 05/04/2018           Aman Khan               Bug 76881 - Getting some database error in list view if enter integer,float,Long value more then 32767
     * 16/04/2018           Gaurav Sharma           Bug 76775 - Event tab of Button 's settings should be merged with event configuration
     * 17/04/2018           Gaurav Sharma           Bug 77001 - Jboss+SQL:-Fix Header functionality not working during scroll header scrolled up
     * 07/05/2018           Gaurav Sharma           Bug 77543 - Events and webservice functionality not working in iform not getting output.
     * 07/05/2018           Aman Khan               Bug 77282 - On Textarea control if set property as a Rich text than during runtime validation message should not be shown 
     * 12/05/2018           Aman Khan               Bug 77221 - On Textbox Control Masking not working .
     * 18/05/2018           Minakshi Sharma         Bug 76692 - Performance issue in loading the iform if huge data in table & listview
     * 19/05/2018           Gaurav Sharma           Bug 75468 - Websphere+Oracle:Android:On Task Picklist functionality not working
     * 20/05/2018           Aman Khan               Bug 77540 - under listview control for float data type wrong calculation shown for "show total"
     * 22/05/2018           Gaurav Sharma           Bug 78046 - JbossEAP7+Oracle :under list view control ,date and time calendar not shown hidden by scroller
     * 22/05/2018           Aman Khan               Bug 78047 - JbossEAP7+Oracle :click on list view forward arrow it show alert 
     * 23/05/2018           Aman Khan               Bug 77827 - iOS Device:-Entries are not saved in iform .
     * 24/05/2018           Aman Khan               Bug 77540 - under listview control for float data type wrong calculation shown for "show total".
     * 31/05/2018           Gaurav                  Bug 78172 - JbossEAP7+postgres+iphone5s:-Under Listview control for "Date and Time" column calendar not shown properly due to this unable to select date and time. 
     * 06/07/2018           Aman Khan               Bug 78853 - IForm:Under listview control lablel link url not working
     * 11/07/2018           Aman Khan               Bug 79007 - API to set mapping for Grid, in iForms
     * 11/07/2018           Aman Khan               Bug 78996 - Remove validation check for email field, on iforms, when the field is marked as non-mandatory
     * 16/07/2018           Aman Khan               Bug 79061 - Expand section on iformviewer screen ,UI distorted unbale to perform any operation on WI.
     * 16/07/2018           Gaurav                  Bug 79052 - Masking Pattern Symbols are removed after saving workitem
     * 19/07/2018           Aman Khan               Bug 79243 - Not able to hide tables
     * 19/07/2018           Aman Khan               Bug 79251 - Need to add values in type ahead dropdown
     * 07/09/2018           Aman Khan               Bug 80062 - We are having a custom jsp on which data comes from web service. we need to populate this data from jsp to grid on the IForm. Thus requires the function to add data from jsp to grid
     * 07/09/2018           Aman Khan               Bug 80075 - Calendar Field once disabled is accepting input by clicking the calendar icon and if I scroll over the calendar field than dates filled in the input calendar box get changed .
     * 11/09/2018           Aman Khan               Bug 80094 - API for multiple values selected in Picklist
     * 14/09/2018           Aman Khan               Bug 80131 - Disabled control style in iforms 
     * 09/10/2018           Mohit Sharma            Bug 80608 - require id in addItemInCombo api
     * 16/10/2018           Aman Khan               Bug 80797 - DateTime picker scrolling issue in IE
     * 22/10/2018           Gaurav                  Bug 80908 - need different methods on loading of listview on add and modify operations
     * 31/10/2018           Minakshi Sharma         Bug 81099 - If a field is mapped , the mapped field is coming twice in a dropdown
     * 02/11/2018           Minakshi Sharma         Bug 81160 - Error in getControlValue() API in IForms 
     * 02/11/2018           Gaurav  Sharma          Bug 81189 - getvalue giving wrong data when masking is applied.
     * 02/11/2018           Rohit Kumar             Bug 81164 - Sub form in pop up does not get closed when workitem is closed.
     * 06/11/2018           Gaurav                  Bug 81230 - Min Date and Max Date not working in datepicker 2
     * 06/11/2018           Gaurav                  Bug 81231 - setTableCellData not working after deletion of row in table
     * 06/11/2018           Gaurav                  Bug 81232 - Digit Grouping not working in setValues() API
     * 09/11/2018           Aman Khan               Bug 80327 - User is able to add duplicate values in the field for which the allow duplicate checkbox is not selected in case of List view
     * 12/11/2018           Aman Khan               Bug 81176 - Section expand /Collapsed functionality not working .
     * 12/11/2018           Aman Khan               Bug 80771 - setFocus inside Listviw tab for radio Not working.
     * 15/11/2018           Minakshi Sharma         Bug 81193 - Android device :On iform save invalid session message not shown 
     * 26/11/2018           Minakshi SHarma         Bug 81548 - Issue while using methods "setTableCellColor" and "getValueFromTableCell" 
     * 26/11/2018           Aman Khan               Bug 81572 - getSheetIndex() not working for tab of style 3
     * 03/12/2018           Minakshi Sharma         Bug 81682 - Picklist functionality not working on nested complex variable 
     * 03/12/2018           Aman Khan               Bug 81586 - iOS|| Android :- On Picklist window batching not working
     * 03/12/2018           Aman Khan               Bug 81584 - Android || iOS :-Select value from picklist bydefault value overridden by the selected value
     * 04/12/2018           Aman Khan               Bug 80799 - Android device:-subform functionality not working on form . 
     * 10/12/2018           Minakshi Sharma         Bug 81747 - JbossEAP7.0+Postgres+OD9.1SP2+iBPS3.0 SP2: Workitem is neither getting saved now giving any validation message if save workitem
     * 12/12/2018           Minakshi Sharma         Bug 81918 - setStyle() API not working on multiselect 
     * 12/12/2018           Aman Khan               Bug 81923 - setDisableColumn() API not working properly in IForms
     * 15/12/2018           Aman Khan               Bug 81946 - Under Listview and Table controls wrong show total shown for float variable
     * 16/12/2018           Aman Khan               Bug 81934 - Arabic:- Wrong data shown on added row under Advance Listview
     * 17/12/2018           Aman Khan               Bug 81951 - Shorting not working on Listview control
     * 20/12/2018           Minakshi Sharma         Bug 82077 - CSS of Multiselect should be same as Combo Box in iForms
     * 24/12/2018           Gaurav                  Bug 82142 - The currentdate is getting selected on clicking of date field if date field is empty.                  
     * 28/12/2018           Minakshi Sharma         Bug 82173 - Trying to disable the frame containing Multiselect field, multi select field is not getting disabled
     * 28/12/2018           Abhishek                Bug 82297 - button and link of table cell can now get disable.
     * 07/01/2019           Abhishek                Bug 82355 - show total don't get updated when we hide/show row of table
     * 08/01/2019           Abhishek                Bug 31119 - hamburger UI is not displayed properly
     * 11/01/2019           Abhishek                Bug 82443 - future time getting set after checking today's date as maximum
     * 18/01/2019           Abhishek                Bug 82515 - getValue() not working for Label
     * 25/01/2019           Aman Khan               Bug 82661 - For setting dynamic maxlength of text boxes based on a condition at client side we need an API.
     * 25/01/2019           Mohit Sharma            Bug 82663 - custom window to be closed when main workitem window is closed.
     *12/09/2018            Abhishek Chaudhary      Bug 82657 - french currency support.
     *05/02/2019            Gaurav                  Bug 82878 - Extra scroll coming on page while opening autocomplete
     *06/02/2019            Gaurav                  Bug 82907 - not able to set value in controls using custom service
     *11/02/2019            Gaurav                  Bug 83010 - customValidation function should not be called in case of processSpecific war
     *12/02/2019            Aman Khan               Bug 83037 - Requirement is to have PreHook on Duplicate Row functionality, so that we can perform some custom operation before user clicks on some row to make it duplicate
     *14/02/2019            Gaurav                  Bug 83107 - Issue in select row in picklist with double click
     *15/02/2019            Gaurav                  Bug 83138 - duplicate row button is enabled in case of read only mode
     *15/02/2019            Aman Khan               Bug 83106 - The data of grid is not saving.we have checked the data rights on queue.
     *15/02/2019            Aman Khan               Bug 83114 - Wi getting submit though precision error on screen
     *20/02/2019            Aman Khan               Bug 83214 - Cannot enter a float value in a textbox if its masking is set as 'percentage'.
     *21/02/2019            Gaurav                  Bug 83221 - Not able to set value in editable combo using setValues
     *21/02/2019            Gaurav                  Bug 83222 - clearcombooptions and additemincombo API not working correctly for editable combo
     *26/02/2019            Gaurav                  Bug 83311 - Instead of alphabet,number and space validation, they should be restricted while typing
     * 26/02/2019           Abhishek Chaudhary      Bug 83309 - clear option in picklist window
     * 26/02/2019           Abhishek Chaudhary      Bug 83310 - Removal of RTE Features
     *28/02/2019            Aman Khan               Bug 83346 - Control of the section after expanding it
     *01/03/2019            Aman Khan               Bug 83359 - Unable to get values of selected items of a Listbox in javascript
     *06/03/2019            Abhishek                Bug 83415 - Another french currency support.
     *06/03/2019            Gaurav                  Bug 83424 - Provide API to add,remove and clear Combo in table Cell
     *06/03/2019            Abhishek                Bug 83354 - Scrollbar of a disabled grid not appearing in IE.
     *06/03/2019            Abhishek                Bug 83432 - API to highlight grid rows.
     *12/03/2019            Aman Khan               Bug 83529 - Clear button of picklist doesnot get disabled on calling setStyle API
     *12/03/2019            Aman Khan               Bug 83576 - We are in need of provision for digit grouping in list view controls with precision of 2 decimal points
     *12/03/2019            Abhishek                Bug 83572 - Restriction of multiSelect in grid 
     *22/03/2019            Abhishek                Bug 83722 - zoning not visible 
     *25/03/2019            Abhishek                Bug 83733 - masking option for datetime and date picker
     *25/03/2019            Abhishek                Bug 83732 - filling date without opening date picker
     *25/03/2019            Aman Khan               Bug 83725 - In Execute Server Event function Set Value API not working 
     *28/03/2019            Aman Khan               Bug 83812 - We need API in JS to handle the case when user clicks cancel button in pick list window
     *29/03/2019            Aman Khan               Bug 83883 - setCellDisabled disables a button in a table when we send the flag as true but doesn't enable it when the flag is sent false
     *01/04/2019            Gaurav                  Bug 83904 - when we change the same field as non mandatory still the mandatory error message is displayed
     *01/04/2019            Gaurav                  Bug 83906 - Need read only column in table control
     *03/04/2019            Abhishek                Bug 83976 - ui getting distorted due to listbox
     *03/04/2019            Gaurav                  Bug 83970 - done click not working in mandatory checkbox case.
     *03/04/2019            Aman Khan               Bug 83971 - We require to set a field as Read Only from custom code.
     *04/04/2019            Gaurav                  Bug 84017 - DB linking is not getting called in subform
     *09/04/2019            Aman Khan               Bug 84087 - Add and Close and Save Changes button become non functional when there is a mandatory checkbox in the overlay and we re-open an overlay after closing it.
     *09/04/2019            Aman Khan               Bug 84090 - Value not saving when using autocomplete for a field in IE
     *16/04/2019            Aman Khan               Bug 84187 - Need a common function for change events of all form fields.
     *19/04/2019            Gaurav                  Bug 84280 - Buttons in grid don't function right when disabled
     *22/04/2019            Gaurav                  Bug 84292 - Provide server side API to add, remove and clear combo
     *19/04/2019            Gaurav                  Bug 84280 - Buttons in grid don't function right when disabled
     *24/04/2019            Abhishek                Bug 84341 - API for custom pattern
     *29/04/2019            Aman Khan               Bug 84378 - mandatory validations of a listview do not work when we click on Save and Close button. 
     *30/04/2019            Aman Khan               Bug 84407 - If the type of field in a comboBox is a DropDown then it is not getting populated through code whereas a DropDownList is workking fine. Kindly check this.
     *01/05/2019            Abhishek                Bug 84425 - setStyle for radio style3
     *01/05/2019            Aman Khan               Bug 84409 - dropdown 3 dots icon not getting disabled
     *02/05/2019            Gaurav                  Bug 84437 - getTableCellValue API returning last instance of data when used with onTableCellChange Hook
     *03/05/2019            Gaurav                  Bug 84470 - Listview data deleted from table on Save event when using setTableCellData APi for advanced listview
     *06/05/2019            Rohit                   Bug 84487 - Read only subforms not opening on hamburger click
     *07/05/2019            Aman Khan               Bug 84498 - Editable combo not working in listview
     *07/05/2019            Aman Khan               Bug 84504 - setColumnVisible api not working properly
     *09/05/2019            Abhishek                Bug 84527 - Warning Message requires on copy paste on exceeding max length in iForms 
     *09/05/2019            Aman Khan               Bug 84526 - Incorrect rowIndex fetched on custom method of label link in table
     *09/05/2019            Gaurav                  Bug 84541 - NGExporttoPDF not working properly, Line item label name is missing and also grid is not aligned properly
     *10/05/2019            Gaurav                  Bug 84587 - Masking of field is not working in mobile
     *16/05/2019            Aman Khan               Bug 84692 - Masking should accept single digit as well
     *17/05/2019            Rohit Kumar             Bug 84710 - Value in listbox is not visible if desc is lengthy
     *22/05/2019            Abhishek                Bug 84829 - Need API to clear Listview row selection
     *22/05/2019            Abhishek                Bug 84830 - IForm-Provide Flag to Check Section is open or not
     *24/05/2019            Aman Khan               Bug 84870 - Listview is disabled still save changes button is active in the modal when double clicking the row data. 
     *24/05/2019            Aman Khan               Bug 84871 - getValueFromTable API returns undefined , but the listview contains 1 record
     *27/05/2019            Gaurav                  Bug 84916 - initially collapsed section inside advanced listview is coming as expanded for new row/modify once section is expanded
     *28/05/2019            Gaurav                  Bug 84948 - Mandatory alert is coming one time only if we again clear the value in mandatory field
     *28/05/2019            Aman Khan               Bug 84951 - Document index shonw on clicking save changes and reopening the row
     *28/05/2019            Rohit Kumar             Bug 84965 - Preventing backspace key when form is open , is working in Chrome but form is allowing backspace key in Internet Explorer 11 and form turns blank.
     *03/06/2019            Abhishek                Bug 85054 - Save & Next option in tabs traverse hidden sheets
     *08/06/2019            Gaurav                  Bug 85154 - fixed tab header not working for style4 and in ie not working for any of the tab style
     *13/06/2019            Gaurav                  Bug 85226 - Give API to attach zone on any field
     *12/06/2019            Aman Khan               Bug 85199 - setValue not working inside executeServerEvent
     *13/06/2019            Aman Khan               Bug 85219 - Disable right click on iforms except on controls
     *13/06/2019            Gaurav                  Bug 85227 - Need API for silentSave in iForm Mobile
     *13/06/2019            Abhishek                Bug 85225 - Unable to setStyle visible for ListBox
     *19/06/2019            Aman Khan               Bug 85340 - Percentage not taking decimal in listview
     *19/06/2019            Abhishek                Bug 85342 - getValueFromTableCell returns masked value
     *20/06/2019            Aman Khan               Bug 85374 - Listview textarea data added not being reflected on listview
     *21/06/2019            Aman Khan               Bug 85395 - Editable combo not populating on DBLinking
     *24/06/2019            Aman Khan               Bug 85406 - GetValue not working in dropdown due to clearCombo API
     *26/06/2019            Abhishek                 Bug 85447 - Tool Tip on form load
     *27/06/2019            Gaurav                  Bug 85461 - Duplicate rows getting added in grid
     *03/07/2019            Gaurav                  Bug 85502 - getvaluefromtablecell() returns undefined for listview
     *01/08/2019            Aman Khan               Bug 85808 - Not saving cell data in Pagination(Batching)
     *02/08/2019            Aman Khan               Bug 85829 - Label as a method is not getting disabled in table after setStyle API
     *06/08/2019            Aman Khan               Bug 85842 - Performance issue due to editable combo loading on form load
     *09/07/2019            Aman Khan               Bug 85551 - setStyle mandatory not working for RTE
     *10/07/2019            Abhishek                Bug 85559 - mandatory fields not saving after done.
     *15/07/2019            Rohit Kumar             Bug 85630 - Not able to set value in textbox inside frame usingsetValues() on expand of frame
     *16/07/2019            Aman Khan               Bug 85646 - Cut , copy and paste shortcuts are not working in textbox.
     *17/07/2019            Aman Khan               Bug 85656 - requirement for password field control
     *17/07/2019            Aman Khan               Bug 85657 - onChangeSectionState is not called all time
     *18/07/2019            Aman Khan               Bug 85663 - setTableCellData not working for table columns having masking pattern applied
     *23/07/2019            Abhishek                Bug 85714 - zoning applied even after out of focus
     *24/07/2019            Aman Khan               Bug 85728 - Textbox not taking arabic data when the special characters are not allowed
     *25/07/2019            Aman Khan               Bug 85746 - setTableCellData API its not working.
     *25/07/2019            Aman Khan               Bug 85748 - Empty value in textarea is not saving in listview
     *30/07/2019            Gaurav                  Bug 85784 - Need server API to delete rows in grid
     *31/07/2019            Aman Khan               Bug 85799 - addDatoGrid is not reflecting Data on Grid
     *31/07/2019            Aman Khan               Bug 85806 - onChangeSection state API is not called when the section is kept initially collapsed
     *08/08/2019            Abhishek                Bug 85865 - saveWorkitem api doesn't work on subform onload of workitem. 
     *09/08/2019            Aman Khan               Bug 85911 - Need to show iframe in full screen
     *14/08/2019            Abhishek                Bug 85972 - hide datepicker icon on disable with ini
     *14/08/2019            Abhishek                Bug 85973 - checkbox in grid is disabled when enabled by setStyle
     *27/08/2019            Rohit Kumar             Bug 86217 - Encrypted value is getting saved in db for password field
     *29/08/2019            Aman Khan               Bug 86251 - Prehook and posthook for custom web service
     *29/08/2019            Aman Khan               Bug 86252 - Need to execute setstyle in execute custom service
     *30/08/2019            Aman Khan               Bug 86266 - setStyle disabled true removed the add and delete button of grid
     *30/08/2019            Abhishek                Bug 86267 - post hook on clear button of picklist 
     *30/08/2019            Aman Khan               Bug 86277 - The validation is not working when the input is mandatory and has a minimum value
     *04/09/2019            Abhishek                Bug 86346 - character set to uppercase, getValue() api fetching lowercase letters.
     *06/09/2019            Aman Khan               Bug 86478 - setStyle API not enableing table which is disabled from iforms designer
     *10/09/2019            Aman Khan               Bug 86443 - Auto Increment functionality not working on Batching (Table and Listview Control)
     *10/09/2019            Abhishek                Bug 86406 - Under AdvanceListview for NestedTable ,pincode and mobile masking not working .
     *12/09/2019            Aman Khan               Bug 86568 - Searching not working on full table but in batches
     *13/09/2019            Abhishek                Bug 86585 - Greek currency masking pattern
     *13/09/2019            Aman Khan               Bug 86591 - Clicking on table header removes the dollar or percentage sign .
     *13/09/2019            Aman Khan               Bug 86593 - The empty value of editable combo returns 1 in IE browser
     *16/09/2019            Rohit Kumar             Bug 86671 - Old picklist is visible on another picklist load 
     *19/09/2019            Abhishek                Bug 86755 - prehook on autocomplete feature to clear values 
     *19/09/2019            Abhishek                Bug 86763 - decimal should not come when mapped to integer and long in masking pattern.
     *23/09/2019            Abhishek                Bug 86823 - Require return flag for saveSection API
     *23/09/2019            Abhishek                Bug 86825 - ClearTable API not working for total field.
     *01/10/2019            Abhishek                Bug 87088 - custom masking getting saved in database.
     *07/10/2019            Abhishek                Bug 87165 - post hook on search in grid 
     *15/01/2020            Swarnika                Bug 90052 - Read-only drop down when changed to read/write mode then its color didn't changed to white
     *14/10/2019            Abhishek                Bug 87304 - hook on next previous batching button 
     *18/10/2019            Abhishek                Bug 87469 - japanese yen currency without decimal 
     *23/10/2019            Abhishek                Bug 87555 - in listbox select and select all options both are coming
     *31/10/2019            Abhishek                Bug 87664 - overlay won't get close on save changes based on ini
     *08/11/2019            Rohit Kumar             Bug 87960 - Message save successful even when session invalid
     *17/11/2019            Rohit Kumar             Bug 88287 - Backspace not working in iForm using Mozilla Firefox 56.0b3 .
     *17/11/2019            Abhishek                Bug 88288 - setStyle do not work for label as a link
     *17/11/2019            Rohit Kumar             Bug 88289 - Control moving to top in IE if wrong value is entered in textbox
     *21/11/2019            Abhishek                Bug 88522 - Disabling listview should turn its color to grey
     *22/11/2019            Abhishek                Bug 88539 - restricting numbers according to max length when using masking pattern
     *26/11/2019            Abhishek                Bug 88783 - delete,tab keycodes added for firefox browser
     *12/05/2019            Abhishek                Bug 88872 - settablecelldata not working for listview when masking is applied 
     *09/12/2019            Aman Khan               Bug 88954 - SaveSection API and setStyle API not working for RTE
     *13/12/2019            Aman Khan               Bug 89069 - Require Advance Search Drop down in Table.
     *16/12/2019            Aman Khan               Bug 89102 - setStyle JAVA API does not make the checkboxes visible on enabling the table
     *16/12/2019            Aman Khan               Bug 89105 - The autocomplete values are not populated when the value if typed in textbox
     *16/12/2019            Abhishek                Bug 89106 - getSelectedRowsDataFromTable API issue after saving.
     *17/12/2019            Swarnika                Bug 89116 - getvalue() function for editable dropdown gives the first value of suggestion rather than the typed value.
     *17/12/2019            Swarnika                Bug 89121 - When using setstyle (disable false) for listbox, it was not removing "disabled" class from its button.
     *18/12/2019            Aman Khan               Bug 89167 - Need consistent icons in grid batching
	 *19/12/2019            Swarnika                Bug 89195 - Date Picker is not opening on single click when used inside a grid
     *26/12/2019            Aman Khan               Bug 89371 - Digit Grouping not working in readonly style textbox control
     *27/12/2019            Abhishek                Bug 89431 - setCustomMasking API.
     *27/12/2019            Aman Khan               Bug 89434 - Need to get save changes working after modify call
     *31/12/2019            Aman Khan               Bug 89546 - Wrong error message thrown on numeric field
     *01/01/2020            Abhishek                Bug 89565 - when combo values has special character '&' duplicate don't work.
     *01/01/2020            Abhishek                Bug 89567 - in editable combo values don't get added in listview.
     *01/01/2020            Aman Khan               Bug 89586 - Restrict negative sign if the minimum value is 0 in textbox
     *02/01/2020            Abhishek                Bug 89620 - duplicate not working in case of editable combo.
     *06/01/2020            Abhishek                Bug 89677 - Unable to call function at section load when masking and showTotal is used 
     *06/01/2020            Swarnika                Bug 89678 - Email id is not valid but on ''Save and Close" option of Overlay it adds the incorrect Email Id to grid.
     *07/01/2020            Aman Khan               Bug 89767 - Tab out not working on a numeric field with maxlength provided in properties.
     *07/01/2020            Swarnika                Bug 89769 - After restricting the user to add duplicate row, arrows not working for listview
     *08/01/2020            Abhishek                Bug 89799 - webservice post hook
     *08/01/2020            Abhishek                Bug 89800 - Provision to get tablecell value using column name
     *08/01/2020            Abhishek                Bug 89801 - Highlight the Listview Rows on disabled mode.
     *09/01/2020            Abhishek                Bug 89906 - On showMessage control going in OnTabClick method
     *08/01/2020            Aman Khan               Bug 89827 - Need confirmation to save added rows before seaarching when the batching is not enabled
     *09/01/2020            Aman Khan               Bug 89898 - No scrollbar shown in grid control when the frame is disabled using setStyle JS API
     *15/01/2020            Swarnika                Bug 90052 - Read-only drop down when changed to read/write mode then its color didn't changed to white
     *21/01/2020            Swarnika                Bug 90080 - selected row ListView Delete button is getting disabled when tableOperation API is returning true
     *23/01/2020            Karishma Rastogi        Bug 89941 - On Published Application if session expired than proper message should be display
     *29/01/2020            Abhishek                Bug 88732 - on SubForm window, If any field is mandatory click on Done button validation message should be displayed.
     *04/02/2020            Abhishek                Bug 89201 - In Arabic Locale:- If Drop down is selected as Combo type, values are not displayed.
     *24/01/2020            Aman Khan               Bug 90271 - Listbox grey colour not removed after enabling the frame
     *24/01/2020            Aman Khan               Bug 90272 - Need searching on ALL columns in grid control
     *27/01/2020            Aman Khan               Bug 90298 - setStyle background color not working on picklist control
     *03/03/2020            Abhishek                Bug 91176 - message while pasting special characters is not working in IE
     *
     *31/01/2020            Aman Khan               Bug 90466 - SetCellDisable API does not change the table cell's button color
     *31/01/2020            Aman Khan               Bug 90467 - float data type fields not showing the decimals correctly in the table level view while loading the form
     *31/01/2020            Aman Khan               Bug 90468 - Need to show label on listview combobox instead of value
     *03/02/2020            Abhishek                Bug 90477 - The query is not working on LOAD event of a section
     *04/02/2020            Aman Khan               Bug 90617 - addDatoGrid API distorts the grid UI if the data is fetched from RTE.
     *10/02/2020            Aman Khan               Bug 90618 - "Allow Special Characters" value "No" in property of any text input, then system will not allow to type anything
     *10/02/2020            Aman Khan               Bug 90656 - Error in Saving Data shows whenever search clicked on empty grid
     *21/02/2020            Abhishek                Bug 90857 - RTE not working properly whie using setStyle Api.
     *06/03/2020            Aman Khan               Bug 91216 - SaveSection API executes silently and does not throw any error message.
	 *05/03/2020            Rohit Kumar             Bug 91206 - Restrict to enter value more than defined range for float field
     *13/03/2020            Aman Khan               Bug 91237 - Need to use up/key/tab keys in the picklist window
     *11/03/2020            Aman Khan               Bug 91239 - The editable combo is parsing only integer value in options
     *16/03/2020            Deepak Singh Rawat      Bug 90690 - Need of AssignedTo user property in IForm.
     *16/03/2020            Aman Khan               Bug 91251 - Need row index in modify row post hook
     *17/03/2020            Abhishek                Bug 91306 - prehook for overriding restrictOverlay INI
     *20/02/2020            Abhishek                Bug 91407 - incorrect output of web service
     *01/04/2020            Rohit Kumar             Bug 91541 - List view row is not updating after modifying data in over lay with multiline text
     *02/04/2020            Abhishek                Bug 91545 - main save not working in addrowposthook 
     *02/04/2020            Rohit Kumar             Bug 91554 - All selected contents are not visible in listbox tooltip
     *04/04/2020            Sri Prakash             Bug 91571  - If form field is of type float, then on pasting float of larger size does not give alert notification, neither trims nor clears field on some IE browser
     *06/04/2020            Aman Khan               Bug 91578 - User should not be able to switch to the hidden rows in listview
     *15/04/2020            Aman Khan               Bug 91924 - 'Undefined' getting saved for editable combo in advanced listview
     *15/04/2020            Aman Khan               Bug 91729 - Button label is changes to undefined when an added row is modified in adv listview. (edit)
     *16/04/2020            Aman Khan               Bug 91919 - Allow special characters property is not working
     *20/04/2020            Deepak Singh Rawat      Bug 91847 - SetCustomMasking is not working properly for Integer, Float and Long data type.
     *20/04/2020            Aman khan               Bug 91892 - Combo label value not working for editable combo
     *22/04/2020            Deepak Singh Rawat      Bug 91943 - addRowPostHook not called on adding row in the table if advance list view is opened before it.
     *22/05/2020            Aman Khan               Bug 92457 - Workitem takes too long for its submission.
     *27/05/2020            Aman Khan               Bug 92510 - WebservicePostHook input parameter is undefined
     *03/06/2020            Aman Khan               Bug 92605 - Need webservice prehook in iForms
     *05/06/2020            Aman Khan               Bug 92652 - Total value is not shown with masking
     *22/06/2020            Aman Khan               Bug 92941 - Need subform functionality in a bootstrap modal in iBPS mobile
     **/
    var rowId = 0;
    var valueChanged=false;
    var ComponentValidatedMap ={};
    var datepickerinitialised = false;
    var currentJQueryDatePickerValue="";//Bug 76754
    var tableDataChangeArray=[];
    var isListviewOpened=false;
    var totalSubWindows = 0;    //Bug 81164 
    var allWindows = new Array();
    var isAutoCompleteSelected=false;
    var documentIndex="";
    var isBootboxCloseClicked=false;
    var tileDataModified = false;
    var isAdvanceListView=false
    
    function encode_ParamValue(param)
    {
            return param;
    }

function applyFormattingGrid()
{
    $('.tabletextbox').each(function()
        {
            if(this.getAttribute("maskingpattern")!=null && this.getAttribute("maskingpattern")!=undefined && this.getAttribute("maskingpattern")!="nomasking" && this.getAttribute("maskingpattern")!="" )
            {
            if(this.getAttribute("maskingPattern").toString()!='currency_rupees' && this.getAttribute("maskingPattern").toString()!=='currency_dollar' && this.getAttribute("maskingPattern").toString()!=='currency_yen' && this.getAttribute("maskingPattern").toString()!=='currency_euro'  && this.getAttribute("maskingPattern").toString()!=='currency_french' && this.getAttribute("maskingPattern").toString()!=='currency_greek' && this.getAttribute("maskingPattern").toString()!=='percentage' && this.getAttribute("maskingPattern").toString()!=='dgroup2' && this.getAttribute("maskingPattern").toString()!=='dgroup3' && this.getAttribute("maskingPattern").toString()!=='email' && this.getAttribute("maskingPattern").toString()!=='NZP')
                {
                    var placeholder;
                    placeholder = this.getAttribute("maskingpattern").replace(/[A-Za-z0-9*#]/mg, "_");
                    jQuery(this).mask(this.getAttribute("maskingpattern"), {
                        placeholder: placeholder
                    }, {
                        clearIfNotMatch: true
                    });
                }
                else{
                            maskfield(this,'input');
            }
            }
             var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
            if(typeofvalue=='Float' && this.getAttribute("maskingpattern")=="nomasking")
            {
                maskfield(this,'input');
            }
        });
}
function ctrOnchangeHandler(thisRef, op){
        if( ! datepickerinitialised )
            return;
        var key = thisRef.getAttribute("dataClass");
        if(key=="")
            key = thisRef.name;
        if(key=="")
            key = thisRef.id;
		var validateMapKey=thisRef.id;//Bug 83970 Start
        if(thisRef.name!=null&&thisRef.name!=undefined&&thisRef.name!="")
            validateMapKey=thisRef.name;//Bug 83970 End
        var value;
        //masking creditcard in textbox//
        //    if(jQuery(thisRef).attr("masklength")!=undefined)
        //        value = jQuery("#"+thisRef.id + "-original").val();
        //    else
        value = getControlValue(thisRef);    

        var type=jQuery(thisRef).attr("datatype");
        if(jQuery(thisRef).attr("type")=="password"){
            type="password";
        }
        if(thisRef.getAttribute("typeofvalue") && (thisRef.getAttribute("typeofvalue")==='Date' || thisRef.getAttribute("typeofvalue")==='Boolean' || thisRef.getAttribute("typeofvalue")==='Integer' || thisRef.getAttribute("typeofvalue")==='Float' || thisRef.getAttribute("typeofvalue")==='Long')){
            if(!validateTypeOfValue(thisRef))
            {
                ComponentValidatedMap[validateMapKey]=false;//Bug 83970
                valueChanged=false; 
                return false;
            }
        }
        else{
            if(!(thisRef.type=="range"))
            {
                if(!jQuery(thisRef).hasClass("richtexteditor") && !validateValue(thisRef,type))
                {
                    ComponentValidatedMap[validateMapKey]=false;//Bug 83970
                    valueChanged=false; 
                    return false;
                }
            }


        }
        //Bug 83576 starts
//        if(thisRef.getAttribute("typeofvalue")=="Float" && value!=''){
//            appendZeroesToFloat(thisRef);
//        }
        //Bug 83576 ends
        if(thisRef.type=='text' && !validateMinMaxValue(thisRef.id)){
            valueChanged=false;
            return false;
        }

        if(value!="" && jQuery(thisRef).attr("required")!=undefined)
        {
            var msgRef = document.getElementById(thisRef.id+"_msg");
            var patternRef = document.getElementById(thisRef.id+"_patternMsg");
            jQuery(msgRef).css("display","none");
            jQuery(patternRef).css("display","none");
            toggleErrorTooltip(thisRef,msgRef,patternRef,true,0);
           // jQuery("#"+thisRef.id+"_msg").css("display","none");
          //  jQuery("#"+thisRef.id+"_patternMsg").css("display","none");
            if(jQuery(jQuery(thisRef)[0]).parent().parent().parent().hasClass("floating-label-form-group"))
                jQuery(jQuery(thisRef)[0]).parent().parent().parent().removeClass("mandatory");
            else
                jQuery(jQuery(thisRef)[0]).removeClass("mandatory");
        }

        valueChanged=true; 
        if (validateMapKey in ComponentValidatedMap)//Bug 83970
            delete ComponentValidatedMap[validateMapKey];//Bug 83970
        var combotype =  jQuery(thisRef).attr("combotype");
        var saveencrypt = "N";
        if(jQuery(thisRef).attr("saveencrypt")!="")
            saveencrypt = jQuery(thisRef).attr("saveencrypt");
        var listboxOptions={};

        if(combotype!=undefined){
            //value = thisRef.options[thisRef.selectedIndex].value;
            for (i=0;i<thisRef.length;i++) { 
                if(thisRef[i].selected){
                    listboxOptions[i] = thisRef[i].value; 
                }
            }
            var jsonString = JSON.stringify(listboxOptions);
            value = jsonString;
        }

        var url = "ifhandler.jsp";
        //    var requestString = "pid="+encode_utf8(pid)+"&wid="+encode_utf8(wid)+"&tid="+encode_utf8(tid)+"&fid="+encode_utf8(fid)+"&attrName="+encode_utf8(key)+"&attrValue="+encode_utf8(value)+"&op="+op+"&attrType="+type;
        if(type == "date"){
            var dateFormat = jQuery(thisRef).attr("dateformat").split("_")[0];
            var dateSeparator = jQuery(thisRef).attr("dateformat").split("_")[1];
            if(dateSeparator == "1") dateSeparator = "/";
            else if(dateSeparator == "2") dateSeparator = "-";
            else if(dateSeparator == "3") dateSeparator = ".";
            var timeFlag = jQuery(thisRef).attr("dateformat").split("_")[2];
            if($(thisRef).hasClass('openPickerClass'))
            {
                validateDateValue(thisRef);
                value = thisRef.value;
            }
        }
        if(window.formChangeHook)
            formChangeHook(thisRef);
        var requestString = "pid="+encode_utf8(pid)+"&wid="+encode_utf8(wid)+"&tid="+encode_utf8(tid)+"&fid="+encode_utf8(fid)+"&attrName="+encode_utf8(key)+"&attrValue="+encode_utf8(value)+"&op="+op+"&attrType="+type+"&dateformat="+dateFormat+"&dateseparator="+dateSeparator+"&timeflag="+timeFlag+"&combotype="+combotype+"&saveencrypt="+saveencrypt;          
        var contentLoaderRef = new net.ContentLoader(url, formHandler, formErrorHandler, "POST", requestString, false);
    }


    function formHandler(){
    }

    function formErrorHandler(){

    }

    function validateColumnValue(thisRef,tableId,showMsg){
        if(thisRef.value!==""){
        var value = thisRef.value;
         if(thisRef.getAttribute("maskingPattern")!=null && thisRef.getAttribute("maskingPattern")!=undefined && thisRef.getAttribute("maskingPattern")!='' && thisRef.getAttribute("maskingPattern")!='nomasking' && thisRef.getAttribute("maskingPattern")!='email'){
    	if(thisRef.getAttribute("maskingPattern").toString()==='currency_rupees' || thisRef.getAttribute("maskingPattern").toString()==='currency_dollar' || thisRef.getAttribute("maskingPattern").toString()==='currency_yen' || thisRef.getAttribute("maskingPattern").toString()==='currency_euro' || thisRef.getAttribute("maskingPattern").toString()==='currency_french' || thisRef.getAttribute("maskingPattern").toString()==='currency_greek' || thisRef.getAttribute("maskingPattern").toString()==='percentage'|| thisRef.getAttribute("maskingPattern").toString()==='dgroup2'|| thisRef.getAttribute("maskingPattern").toString()==='dgroup3'|| thisRef.getAttribute("maskingPattern").toString()==='NZP')
                    value = jQuery(thisRef).autoNumeric('get');
            else{
                    if(thisRef.getAttribute("datatype") == "date")
                    {
                        value = thisRef.value;
                    }
                    else
                        value = jQuery(thisRef).cleanVal();
                }
        }
        var correctValue =ENTER_CORRECT_VALUE_FOR+thisRef.getAttribute("typeofvalue");
        if(thisRef.getAttribute("typeofvalue")==='Float'){
            var orgvalue = value.replace(".","");
            if(isNaN(parseFloat(value)) || !isFinite(value) || (value.indexOf('.')>0 && (value.length-value.indexOf('.')-1)>(parseInt(thisRef.getAttribute("Precision"))))  ||(orgvalue.length>thisRef.getAttribute("floatlength"))){
                if(!(isNaN(parseFloat(value)) || !isFinite(value)) && (orgvalue.length>thisRef.getAttribute("floatlength"))){
                    correctValue=FLOAT_LENGTH;
                    if(document.getElementById(tableId+"_"+thisRef.getAttribute("labelName")+"_msg")!=undefined)
                        document.getElementById(tableId+"_"+thisRef.getAttribute("labelName")+"_msg").innerHTML = correctValue;
                    thisRef.value="";
                    return false;
                } 
                else if(!(isNaN(parseFloat(value)) || !isFinite(value)) && (value.length-value.indexOf('.')-1)>(parseInt(thisRef.getAttribute("Precision"))))
                    correctValue=PRECISION_VALUE+thisRef.getAttribute("Precision");
                if(document.getElementById(tableId+"_"+thisRef.getAttribute("labelName")+"_msg")!=undefined)
                        document.getElementById(tableId+"_"+thisRef.getAttribute("labelName")+"_msg").innerHTML = correctValue;
                    thisRef.value="";
                    return false;
            }
        } else if(thisRef.getAttribute("typeofvalue")==='Integer'){
                if(isNaN(parseInt(value)) || !isFinite(value) || parseInt("-32768")>parseInt(value) || parseInt("32767")<parseInt(value)){
                    if(!(isNaN(parseInt(value)) || !isFinite(value)) && (parseInt("-32768")>parseInt(value) || parseInt("32767")<parseInt(value))){
                        correctValue=ENTER_VALUE_BETWEEN+INTEGER_RANGE;
                    }
                    if(document.getElementById(tableId+"_"+thisRef.getAttribute("labelName")+"_msg")!=undefined)
                        document.getElementById(tableId+"_"+thisRef.getAttribute("labelName")+"_msg").innerHTML = correctValue;
                    thisRef.value="";
    //                if(showMsg==true)
    //                    showMessage("",correctValue,"error");
                    return false;  
                }
            }
        else if(thisRef.getAttribute("typeofvalue")==='Long'){
        if(isNaN(parseInt(value)) || !isFinite(value) || parseInt("-2147483648")>parseInt(value) || parseInt("2147483647")<parseInt(value)){
                if(!(isNaN(parseInt(value)) || !isFinite(value)) && (parseInt("-2147483648")>parseInt(value) || parseInt("2147483647")<parseInt(value)))
                    correctValue=ENTER_VALUE_BETWEEN+FLOAT_RANGE;
                if(document.getElementById(tableId+"_"+thisRef.getAttribute("labelName")+"_msg")!=undefined)
                    document.getElementById(tableId+"_"+thisRef.getAttribute("labelName")+"_msg").innerHTML = correctValue;
                thisRef.value="";
    //            if(showMsg==true)
    //                showMessage("",correctValue,"error");
                return false;  
            }
        }
        else if(thisRef.getAttribute("typeofvalue")==='Boolean'){
            if(!(value.toLowerCase()==="true" || value.toLowerCase()==="false")){
                return false;  
            }
        }

        }
         return true;
    }

    function customServerValidation(op)
    {
        var url = "ifhandler.jsp";
        var requestString = "pid="+encode_utf8(pid)+"&wid="+encode_utf8(wid)+"&tid="+encode_utf8(tid)+"&fid="+encode_utf8(fid)+"&CalledFor=Validation";

        switch (op) {
            case 'S':
                requestString += "&op=2";
                break;
            case 'I':
                requestString += "&op=3";
                break;
            case 'D':
                requestString += "&op=4";
                break;
            default:
                break;
        }

        var responseText = iforms.ajax.processRequest(requestString, url);
        if(responseText.trim()!="")
        {
            var jsonObj=JSON.parse(responseText);
            for (var i = 0; i < jsonObj.length; i++) 
            {
                var ctrlId=jsonObj[i].controlId;
                jQuery("#"+ctrlId+"_patternMsg").text(jsonObj[i].errorMessage);
                toggleErrorTooltip(document.getElementById(ctrlId),null,document.getElementById("#"+ctrlId+"_patternMsg"),false,1);
                //jQuery("#"+ctrlId+"_patternMsg").css("display","block");        
            }
            return false;
        }else
            return true;
        return true;
    }

    function saveForm(op,silentSave)//Bug 85227
    {
        silentSave=typeof silentSave =="undefined"?false:silentSave;//Bug 85227
        var activeElement = document.activeElement;
        var key = activeElement.name;
        var value = getControlValue(activeElement);
        var type=jQuery(activeElement).attr("datatype");
        var dateFormat="";
        var dateSeparator="";
         var timeFlag="";
        var mandatorycheck=true; 
        if(op=="SB"){
            mandatorycheck=false;
            op="SF";
        }    
        if(type == "date"){
             dateFormat = jQuery(activeElement).attr("dateformat").split("_")[0];
             dateSeparator = jQuery(activeElement).attr("dateformat").split("_")[1];
            if(dateSeparator == "1") dateSeparator = "/";
            else if(dateSeparator == "2") dateSeparator = "-";
            else if(dateSeparator == "3") dateSeparator = ".";
             timeFlag = jQuery(activeElement).attr("dateformat").split("_")[2];
        }

        if( op != "S" && mandatorycheck){ 
            if(!validateMandatoryFields())
                return false;
        }
        if( window.customValidation && mandatorycheck){
            if( ! customValidation( op ) ){
                return false;
            }
        }           


        var url = "ifhandler.jsp";
        var requestString = "pid="+encode_utf8(pid)+"&wid="+encode_utf8(wid)+"&tid="+encode_utf8(tid)+"&fid="+encode_utf8(fid)+"&attrName="+encode_utf8(key)+"&attrValue="+encode_utf8(value)+"&attrType="+type+"&dateformat="+dateFormat+"&dateseparator="+dateSeparator+"&timeflag="+timeFlag;

        switch (op) {
            case 'S':
                requestString += "&op=2";
                break;
            case 'I':
                requestString += "&op=3";
                break;
            case 'D':
                requestString += "&op=4";
            case 'SF':
                requestString += "&op=8";
                break;
            default:
                break;
        }
        if(silentSave){//Bug 85227 Start
            var contentLoaderRef=new net.ContentLoader(url, errorMsgHandler, wiOpErrorHandler, "POST", requestString, false);
            contentLoaderRef.Op = op;
        }//Bug 85227 End
        else{
            var contentLoaderRef = new net.ContentLoader(url, wiOpHandler, wiOpErrorHandler, "POST", requestString, false);
            contentLoaderRef.Op = op;
        }
    }


    function errorMsgHandler(){
	if(this.req.getResponseHeader("InvalidSession")==="Y" || this.req.getResponseHeader("Error")=="7006"){
           window.location=window.location.toString().split('/')[0]+"//"+window.location.toString().split('/')[2]+"/"+window.location.toString().split('/')[3]+'/error/sessionInvalid.jsp';
        } else if( "Y" === this.req.getResponseHeader("Error") ){
             showAlertDialog("<b>There is some error in Saving Data.</br>Please check logs for error!</b>",true);    
         } 
    }

    function customIFormHandler(op,dummySave)
    {
        if(op=='S' && dummySave=='Y')
            return;
        var isValid = true;
        if( op != 'S' ){//Bug 84948 Start
            var skipValid=false;
            if( window.skipValidation ){
                //return window.skipValidation();
                if(window.skipValidation())
                    skipValid=true;
            }
            if(!skipValid){
                if(!validateMandatoryFields())
                    return false;
            isValid = Object.keys(ComponentValidatedMap).length==0;     //Bug 83114
        }
        }//Bug 84948 End
        if(isValid ){
        var activeElement = document.activeElement;
        var key = activeElement.name;
        var value = getControlValue(activeElement);
        var type=jQuery(activeElement).attr("datatype");
        var dateFormat="";
        var dateSeparator="";
         var timeFlag="";
        if(type == "date" || type == "shortdate"){
             dateFormat = jQuery(activeElement).attr("dateformat").split("_")[0];
             dateSeparator = jQuery(activeElement).attr("dateformat").split("_")[1];
            if(dateSeparator == "1") dateSeparator = "/";
            else if(dateSeparator == "2") dateSeparator = "-";
            else if(dateSeparator == "3") dateSeparator = ".";        
            if(type == "date")
                timeFlag = jQuery(thisRef).attr("dateformat").split("_")[2];
        }


        var url = "ifhandler.jsp";
        var requestString = "pid="+encode_utf8(pid)+"&wid="+encode_utf8(wid)+"&tid="+encode_utf8(tid)+"&fid="+encode_utf8(fid)+"&attrName="+encode_utf8(key)+"&attrValue="+encode_utf8(value)+"&attrType="+type+"&dateformat="+dateFormat+"&dateseparator="+dateSeparator+"&timeflag="+timeFlag+"&mobileMode=N&webdateFormat="+webdateFormat;

        switch (op) {
            case 'S':
                requestString += "&op=2";
                break;
            case 'I':
                requestString += "&op=3";
                break;
            case 'D':
                requestString += "&op=4";
                break;
            default:
                break;
        }        
        var responseText = iforms.ajax.processRequest(requestString, url);
        if(responseText.trim()!=""){
            var jsonObj=JSON.parse(responseText);
            var ngParam=encode_utf8(jsonObj.ngParam);
            var taskParam=encode_utf8(jsonObj.taskParam);
            dummySave = (typeof dummySave=='undefined')?"N":dummySave; 
            tid = (typeof tid=='undefined')?"":tid;    
            var reqTok;
			if(window.parent.opener!=null){
				if(typeof window.parent.opener.parent.getRequestTokenSyn!='undefined')		
					reqTok = window.parent.opener.parent.getRequestTokenSyn('/webdesktop/servlet/saveformservlet');
				else
					reqTok = window.parent.getRequestToken('/webdesktop/servlet/saveformservlet'); 
			} else
				reqTok = window.parent.getRequestToken('/webdesktop/servlet/saveformservlet');
            
            var sid = jQuery("#wd_sid").val();           
            url="/webdesktop/servlet/saveformservlet?WD_RID="+reqTok+"&WD_SID="+sid;           
            
            requestString="pid="+pid+"&wid="+wid+"&fid="+fid+"&ngParam="+ngParam+"&taskParam="+taskParam+"&taskid="+tid+"&isDummySave="+dummySave+"&processDefId="+processDefId;
            responseText = iforms.ajax.processRequest(requestString, url);
            var pageFidType=fid.substring(0, fid.indexOf("_", 0));//Bug 85461   
            var responseJSON = JSON.parse(responseText);
            if(responseJSON.ResponseCode=='304' || responseJSON.ResponseCode=='599' || responseJSON.ResponseCode=='701'){   
                return responseText;
            } else {
                responseText = decodeURIComponent(responseJSON.ResponseMessage);
            }
            if(responseText.trim()!="" && responseText.trim()!='701' && (pageFidType=="Form" || pageFidType=="TaskForm" || pageFidType=="TemplateTaskForm")){//Bug 85461
                url = "ifhandler.jsp";
                requestString = "pid="+encode_utf8(pid)+"&wid="+encode_utf8(wid)+"&tid="+encode_utf8(tid)+"&fid="+encode_utf8(fid)+"&op=5&AttribXML="+encode_utf8(responseText.trim());
                responseText = iforms.ajax.processRequest(requestString, url);
                tableDataChangeArray=[];

            }
        }
        return responseText;

      
    }
    else{
        setFocus(Object.keys(ComponentValidatedMap)[0], false);    //Bug 83114
    }
    }

    function getSaveFormXML(op)
    {
        var activeElement = document.activeElement;
        var key = activeElement.name;
        var value = getControlValue(activeElement);
        var type=jQuery(activeElement).attr("datatype");
        var dateFormat="";
        var dateSeparator="";
         var timeFlag="";
        if(type == "date" || type == "shortdate"){
             dateFormat = jQuery(activeElement).attr("dateformat").split("_")[0];
             dateSeparator = jQuery(activeElement).attr("dateformat").split("_")[1];
            if(dateSeparator == "1") dateSeparator = "/";
            else if(dateSeparator == "2") dateSeparator = "-";
            else if(dateSeparator == "3") dateSeparator = ".";        
            if(type == "date")
                timeFlag = jQuery(thisRef).attr("dateformat").split("_")[2];
        }

        if( op != "S"){ 
            if(!validateMandatoryFields())
                return false;
        }
        if( window.customValidation ){
            if( ! customValidation( op ) ){
                return false;
            }
        }           


        var url = "ifhandler.jsp";
        var requestString = "pid="+encode_utf8(pid)+"&wid="+encode_utf8(wid)+"&tid="+encode_utf8(tid)+"&fid="+encode_utf8(fid)+"&attrName="+encode_utf8(key)+"&attrValue="+encode_utf8(value)+"&attrType="+type+"&dateformat="+dateFormat+"&dateseparator="+dateSeparator+"&timeflag="+timeFlag+"&mobileMode=N&webdateFormat=";

        switch (op) {
            case 'S':
                requestString += "&op=2";
                break;
            case 'I':
                requestString += "&op=3";
                break;
            case 'D':
                requestString += "&op=4";
                break;
            default:
                break;
        }        
        var responseText = iforms.ajax.processRequest(requestString, url);
        if(responseText.trim()!=""){
            var jsonObj=JSON.parse(responseText);
            var ngParam=jsonObj.ngParam;
            return ngParam;        
        }
        return ""; 
    }


    function wiOpHandler(){
        var workdeskWin = window.parent;
        // Form type 'I' indicates Responsive form in iBPS
        var formType = 'I';                
        var errorMessage = this.req.getResponseHeader("errorMessage"); 
        var oper = getQueryVariable(this.params, "op");
        if(oper=="2")
            oper="S";
        else if(oper=="3")
            oper="I";
        else if(oper=="4")
            oper="D";
        if( errorMessage == "" || errorMessage == null ){
            switch (oper) {
                case 'S':
                    if(Object.keys(ComponentValidatedMap).length==0)
                        workdeskWin.postMessage('S', "*");
                    else
                        workdeskWin.postMessage('F', "*");
                    break;
                case 'I':
                    if(Object.keys(ComponentValidatedMap).length==0)
                        workdeskWin.postMessage('I', "*");
                    else
                        workdeskWin.postMessage('F', "*");
                    break;
                case 'D':
                    if(Object.keys(ComponentValidatedMap).length==0)
                        workdeskWin.postMessage('D', "*");
                    else
                        workdeskWin.postMessage('F', "*");
                    break;
                default:
                    break;
            }
        }
        else
        {
            //Bug 81193 
            workdeskWin.postMessage('F:'+errorMessage, "*");
        }
    }

    function wiOpErrorHandler(){
        var workdeskWin = window.parent;
        // Form type 'I' indicates Responsive form in iBPS
        var formType = 'I';

        switch (this.Op) {
            case 'S':
                //workdeskWin.postMessage('S', "*");
                break;
            case 'I':
                //workdeskWin.postMessage('I', "*");
                break;
            case 'D':
                //workdeskWin.postMessage('D', "*");
                break;
            default:
                break;
        }
    }

    function getContentWindow(modalId){
        var returnedObject = null;
        try{
            returnedObject =  window.frames[modalId].contentWindow.document;
        }catch(ex){
            returnedObject =  window.frames[modalId].document;
        }
        return returnedObject;
    }

    //function setSelectedRow()
    //{
    //    var myTrArray =  getContentWindow('iFrameSearchModal').getElementsByClassName("info");
    //    var textBoxValue = "";
    //    if(typeof myTrArray[0] != "undefined"){
    //        textBoxValue = $(myTrArray[0]).find("td:first").html();
    //    }
    //    var ref= getContentWindow('iFrameSearchModal').getElementById("controlId").value;
    //    document.getElementById(ref).value=textBoxValue;
    //    jQuery(document.getElementById(ref)).trigger("change");
    //    document.getElementById("picklistNext").disabled= false;
    //    document.getElementById("picklistPrevious").disabled = true;
    //            
    //}
    function makeAjaxCall(controlId,eventType)
    {
        var url = "action.jsp";
        var requestString=  "controlId="+controlId +"&EventType="+eventType+"&from=serverEvent&pid="+encode_utf8(pid)+"&wid="+encode_utf8(wid)+"&tid="+encode_utf8(tid)+"&fid="+encode_utf8(fid);  
        var contentLoaderRef = new net.ContentLoader(url, ajaxFormHandler, ajaxFormErrorHandler, "POST", requestString, true);
    }

    function ajaxFormHandler(){
        try{
            var jsonObj = JSON.parse(this.req.responseText);
            for (var i = 0; i < jsonObj.length; i++) 
            {
                if(jsonObj[i].Action=="setValue")
                    setValue(jsonObj[i].ControlName,jsonObj[i].ControlValue);
                else if(jsonObj[i].Action=="setStyle")
                    setStyle(jsonObj[i].ControlName,jsonObj[i].Attribute,jsonObj[i].AttributeValue);
            }
        }
        catch(ex){}
    }
    function ajaxFormErrorHandler(){

    }

    function executeListView(controlId,eventType,dataValue,isCopyRow){
        if(window.tableOperation){
            if((isCopyRow==undefined || isCopyRow==false ) && tableOperation(controlId,"AddRow") == false)
                return;
            if(isCopyRow!=undefined && isCopyRow==true && tableOperation(controlId,"CopyRow") == false)
                return;
        }
        var isDisabled=document.getElementById(controlId).classList.contains("disabledTable");

        var url = "action.jsp";
        var requestString=  "controlId="+controlId +"&EventType="+eventType+"&tabledata=yes&pid="+encode_utf8(pid)+"&wid="+encode_utf8(wid)+"&tid="+encode_utf8(tid)+"&fid="+encode_utf8(fid)+"&RowId="+rowId+"&isDisabled="+isDisabled;
        if(dataValue && dataValue!=null && dataValue!='undefined'){
            requestString=requestString+"&dataValue="+encode_utf8(dataValue);
            if(documentIndex!="")
                requestString=requestString+"&docIndex="+documentIndex;
            if(isCopyRow)//issue with copy row in advanced listview
                requestString=requestString+"&copyRowOp=1";
        }

        var contentLoaderRef = new net.ContentLoader(url, addRowlistviewResponseHandler, ajaxFormErrorHandler, "POST", requestString, false);
        setTableModifiedFlag(controlId);

        attachDatePicker();
        rowId ++;
    //     document.getElementById("add_"+controlId).blur();
    }
    function openListViewModel(controlId,eventType,reqString){
        if(window.openOverLay)
        {   
            if( window.openOverLay(controlId)){
                cancelBubble(); 
                return;
            }
        }

        document.getElementById('table_id').value=controlId;
        var url = "listViewModal.jsp";
        var requestString = "&controlId="+controlId +"&EventType="+eventType+"&tabledata=yes&pid="+encode_utf8(pid)+"&wid="+encode_utf8(wid)+"&tid="+encode_utf8(tid)+"&fid="+encode_utf8(fid)+"&RowId="+rowId+"&Operation=add";
        if(reqString && reqString!=='' && reqString!==null)
            requestString=reqString;
        var contentLoaderRef = new net.ContentLoader(url, null, ajaxFormErrorHandler, "POST", requestString, false);
        var tableModalDiv =document.getElementById("iFrameListViewModal");
        //tableModalDiv.innerHTML=contentLoaderRef.req.responseText;
        jQuery(tableModalDiv).html(contentLoaderRef.req.responseText);
        if(!reqString){
            document.getElementById("tablelistPrevious").disabled = true;
            document.getElementById("tablelistNext").disabled= true;
        }
        isListviewOpened = true;
        //doInit();
        if(typeof reqString=="undefined")//Bug 80908 Start
            listViewInit(controlId,'A');
        else
            listViewInit(controlId,'M');//Bug 80908 End
    //    $('.textbox').each(function() {
    //        if(this.getAttribute("maskingpattern")!="nomasking" && this.getAttribute("maskingpattern")!="" )
    //         maskfield(this,'savedinput');
    //         
    //     })
         isListviewOpened = false;

        //attachDatePicker();

    //    $('.maskedText').each(function(){
    //        var digitGroup  = parseInt(this.getAttribute("dgroup"));
    //        var precision=typeof this.getAttribute("Precision")=='undefined'?'2':this.getAttribute("Precision");
    //        var typeofvalue = this.getAttribute("typeofvalue");
    //        var decimal="";
    //        if(typeofvalue =="Float")
    //                decimal=precision;
    //         jQuery(this).autoNumeric('destroy');
    //        jQuery(this).autoNumeric('init',{
    //            dGroup: digitGroup,
    //            mDec: '2'
    //        });
    //    });

    }

    function maskfield(controlRef,type){
                var max=controlRef.getAttribute("rangemax");
                var min=controlRef.getAttribute("rangemin");
                var typeofvalue=typeof controlRef.getAttribute("typeofvalue")=='controlRef'?'':controlRef.getAttribute("typeofvalue");
                var precision=typeof controlRef.getAttribute("Precision")=='undefined'?'2':controlRef.getAttribute("Precision");
                var decimal='2';
                if(typeofvalue =="Float")
                    decimal=precision;
                if(typeofvalue =="Integer")
                    decimal='0';
                if(typeofvalue =="Long")
                    decimal='0';
                
                if(controlRef.getAttribute("maskingPattern") && controlRef.getAttribute("maskingPattern").toString()!='nomasking'&& controlRef.getAttribute("maskingPattern").toString()!='email'){
                if(controlRef.getAttribute("maskingPattern").toString()!='currency_rupees' && controlRef.getAttribute("maskingPattern").toString()!=='currency_dollar' && controlRef.getAttribute("maskingPattern").toString()!=='currency_yen' && controlRef.getAttribute("maskingPattern").toString()!=='currency_euro' && controlRef.getAttribute("maskingPattern").toString()!=='currency_french' && controlRef.getAttribute("maskingPattern").toString()!=='currency_greek' && controlRef.getAttribute("maskingPattern").toString()!=='' && controlRef.getAttribute("maskingPattern").toString()!=='percentage'){
                        var placeholder;
                        if(controlRef.getAttribute("maskingPattern").toString().charAt(controlRef.getAttribute("maskingPattern").toString().length-1)!='$'){
                            if(controlRef.getAttribute("maskingPattern").toString()=='dgroup3' || controlRef.getAttribute("maskingPattern").toString()=='dgroup2'){
                                var digitGroup = parseInt(controlRef.getAttribute("maskingPattern").charAt(controlRef.getAttribute("maskingPattern").length-1));
                                jQuery(controlRef).autoNumeric('init',{
                                    dGroup: digitGroup,
                                    mDec: decimal                                

                                });
                                if(type=='input' && controlRef.value!='')
                                    jQuery(controlRef).autoNumeric('set', controlRef.value);
                                else if(type=='label' && controlRef.innerHTML)
                                    jQuery(controlRef).autoNumeric('set', controlRef.innerHTML);
                            }
                            else{
                                if(typeofvalue=='Float' && controlRef.getAttribute("maskingPattern").toString()=='NZP'){
                                    jQuery(controlRef).autoNumeric('init',{
                                        aSep : '',  
                                        aDec: '.', 
                                        mDec: decimal,
                                        aPad: false
                                    });
                                }
                                else{
                                placeholder=controlRef.getAttribute("maskingPattern").replace(/[A-Za-z0-9*#]/mg , "_");
                                jQuery(controlRef).mask(controlRef.getAttribute("maskingPattern"), {
                                    placeholder: placeholder
                                }, {
                                    clearIfNotMatch: true
                                });
                                }
                            }
                        }
                    }

                    else{
                        var asign='';
                        var dgroup='';
                        var psign='p';
                    var adec='.';
                    var asep=',';
                        if(controlRef.getAttribute("maskingPattern").toString()==='currency_rupees'){
                            asign='Rs ';
                            dgroup=2;
                        }
                        else if(controlRef.getAttribute("maskingPattern").toString()==='currency_dollar'){
                            asign='$ ';
                            dgroup=3;
                        }
                        else if(controlRef.getAttribute("maskingPattern").toString()==='currency_yen'){
                            asign='¥ ';
                            dgroup=3;
                        }
                        else if(controlRef.getAttribute("maskingPattern").toString()==='currency_euro'){
                            asign='€ ';
                            dgroup=3;
                        }
                    else if(controlRef.getAttribute("maskingPattern").toString()==='currency_french'){
  //                      asign=' CHF';
                        dgroup=3;
                        adec = ',';
                        asep = ' ';
                        psign= 's';
                    }
                    else if(controlRef.getAttribute("maskingPattern").toString()==='currency_greek'){
                        dgroup=3;
                        adec = ',';
                        asep = '.';
                        psign= 's';
                    }
                        if(controlRef.getAttribute("maskingPattern").toString()!=='percentage' && controlRef.getAttribute("maskingPattern").toString() !=='currency_yen'){
                            if(max===null)
                                jQuery(controlRef).autoNumeric('init',{
                                    aSign: asign, 
                                    dGroup: dgroup,
                                    pSign:psign,
                                    mDec: decimal,
                                aNeg:true,
                                aDec: adec,
                                aSep: asep
                                });
                            else{
                                jQuery(controlRef).autoNumeric('init',{
                                    aSign: asign, 
                                    dGroup: dgroup,
                                    pSign:psign, 
                                mDec: decimal,
                                aDec: adec,
                                aSep: asep
                                });
                            }
                        }
                        else if(controlRef.getAttribute("maskingPattern").toString() =='currency_yen'){
                            if(max===null)
                                jQuery(controlRef).autoNumeric('init',{
                                    aSign: asign, 
                                    dGroup: dgroup,
                                    pSign:psign,
                                    mDec: "0",
                                aNeg:true,
                                aDec: adec,
                                aSep: asep
                                });
                            else{
                                jQuery(controlRef).autoNumeric('init',{
                                    aSign: asign, 
                                    dGroup: dgroup,
                                    pSign:psign, 
                                mDec: "0",
                                aDec: adec,
                                aSep: asep
                                });
                            }
                        }
                        else
                            jQuery(controlRef).autoNumeric('init',{
                                aSign: " %",
                                pSign:'s',
                                mDec: decimal
                            });
                        if(type=='input' && controlRef.value!='')
                            jQuery(controlRef).autoNumeric('set', controlRef.value);
                        else if(type=='label' && controlRef.innerHTML)
                            jQuery(controlRef).autoNumeric('set', controlRef.innerHTML);
                    }

                }
                if(typeofvalue=='Float' && controlRef.getAttribute("maskingPattern") && controlRef.getAttribute("maskingPattern").toString()=='nomasking'){
                    jQuery(controlRef).autoNumeric('init',{
                                aSep : '',  
                                aDec: '.', 
                                mDec: decimal
                            });
                }
                
    }
    //Bug 81747
    function validateListviewDataType(){
     var listViewControls = document.getElementsByClassName('tableControl');
        var advancedListviewControls=document.getElementsByClassName('advancedListviewControl');
        var componentmap=Object.keys(ComponentValidatedMap);
        if(componentmap.length!=0){
             if(document.getElementById('listViewModal').style.display!='none' && listViewControls.length!=0){
                for(var j=0;j<listViewControls.length;j++){
                    for(var k=0;k<componentmap.length;k++){
                     if(componentmap[k]==listViewControls[j].id){                  
                         return false;
                     }
                     }                   
                }
             }
            else if(document.getElementById('advancedListViewModal').style.display!='none' && advancedListviewControls.length!=0){
                for(var j=0;j<advancedListviewControls.length;j++){
                    for(var k=0;k<componentmap.length;k++){
                     if(componentmap[k]==advancedListviewControls[j].id){                    
                         return false;
                     }
                     }                     
                }        
            }        
        }
        return true;
    }
    function addRowToTable(controlId,isNext,isCopyRow){
        //Bug 81747
        var dataTypeValid=validateListviewDataType();
        if(!dataTypeValid){
            if(typeof isNext!="undefined"&&isNext){
                if(document.getElementById("addrowandnext_"+controlId)!=null)//Bug 84293
                    document.getElementById("addrowandnext_"+controlId).removeAttribute("data-dismiss");
            }
            else{
                if(document.getElementById("addrow_"+controlId)!=null)//Bug 84293
                    document.getElementById("addrow_"+controlId).removeAttribute("data-dismiss");
                if(document.getElementById("copyrow_"+controlId)!=null)//Bug 84293
                    document.getElementById("copyrow_"+controlId).removeAttribute("data-dismiss");
            }
            return false;
        }
        var valid = validateMandatoryFields();
        if(!valid){
            if(typeof isNext!="undefined"&&isNext){
                if(document.getElementById("addrowandnext_"+controlId)!=null)//Bug 84293
                    document.getElementById("addrowandnext_"+controlId).removeAttribute("data-dismiss");
                }
            else{
                if(document.getElementById("addrow_"+controlId)!=null)//Bug 84293
                    document.getElementById("addrow_"+controlId).removeAttribute("data-dismiss");
                if(document.getElementById("copyrow_"+controlId)!=null)//Bug 84293
                    document.getElementById("copyrow_"+controlId).removeAttribute("data-dismiss");
            }
            return false;
        }
        var customListViewValid ;
        if(window.customListViewValidation){
            customListViewValid = customListViewValidation(controlId,"A");
            if(!customListViewValid){
                if(typeof isNext!="undefined"&&isNext){
                    if(document.getElementById("addrowandnext_"+controlId)!=null)//Bug 84293
                        document.getElementById("addrowandnext_"+controlId).removeAttribute("data-dismiss");
                }
                else{
                    if(document.getElementById("addrow_"+controlId)!=null)//Bug 84293
                        document.getElementById("addrow_"+controlId).removeAttribute("data-dismiss");
                    if(document.getElementById("copyrow_"+controlId)!=null)//Bug 84293
                        document.getElementById("copyrow_"+controlId).removeAttribute("data-dismiss");
                }
                return false;
            }
            else{
                if(typeof isNext!="undefined"&&isNext){
                    if(document.getElementById("addrowandnext_"+controlId)!=null)//Bug 84293
                        document.getElementById("addrowandnext_"+controlId).setAttribute("data-dismiss","modal");
                }
                else{
                    if(document.getElementById("addrow_"+controlId)!=null)//Bug 84293
                        document.getElementById("addrow_"+controlId).setAttribute("data-dismiss","modal");
                    if(document.getElementById("copyrow_"+controlId)!=null)//Bug 84293
                        document.getElementById("copyrow_"+controlId).setAttribute("data-dismiss","modal");
                }
            }
        }

        var dataValue={};
        var elementsArray=document.getElementsByClassName('tableControl');
        var invalidControls=[];
        var nullElements=[];
        var isDuplicate = false;
        var table = document.getElementById(controlId);

        for(var i=0;i<elementsArray.length;i++){
            if(elementsArray[i].className.indexOf("noDuplicate")!=-1){    
                var refclass = elementsArray[i].className.substring(elementsArray[i].className.indexOf("noDuplicate")).split(" ")[0];
                var tableCells = table.getElementsByClassName(refclass);
                for(var j=0;j<tableCells.length;j++){
                    var tdContent = tableCells[j].textContent;
                    if (tdContent!="") {
                        if(elementsArray[i].getAttribute("datatype")=="combobox" && elementsArray[i].getAttribute("type")=="text"){
                            var listItems = jQuery(".es-list").find("li");
                                for (var p = 0; p < listItems.length; p++) {
                                    var option = listItems[p].textContent;
                                    if (listItems[p].getAttribute("value") != null && elementsArray[i].value == option){
                                        if( tdContent == listItems[p].getAttribute("value"))
                                        {
                                            isDuplicate = true;
                                            invalidControls.push(elementsArray[i]);
                                            break;
                                        }                                        
                                    }
                                }
                        }
                        else{
                            if(tdContent==elementsArray[i].value){
                                isDuplicate = true;
                                invalidControls.push(elementsArray[i]);
                                break;
                            }   
                        }
                    }
                }
            }
        }

        $(elementsArray).each(function(i) {
            if((this.className.indexOf("denyNull")!=-1)&&(this.value==""||this.value==null)){
                nullElements.push(this.className.split("_")[1]);
            }

            if(this.getAttribute("typeofvalue") && (this.getAttribute("typeofvalue")==='Boolean' || this.getAttribute("typeofvalue")==='Integer' || this.getAttribute("typeofvalue")==='Float' || this.getAttribute("typeofvalue")==='Long')){
                if(!validateTypeOfValue(this))
                {
                    invalidControls.push(this);
                }
            }
            else{
                var type=jQuery(this).attr("datatype");
                if(!validateValue(this,type))
                {
                    invalidControls.push(this);
                }
            }

              var value=this.value?getControlValue(this):this.innerHTML;
        if(this.getAttribute("maskingPattern") && (this.getAttribute("maskingPattern").toString()==='currency_rupees' || this.getAttribute("maskingPattern").toString()==='currency_dollar' || this.getAttribute("maskingPattern").toString()==='currency_yen' || this.getAttribute("maskingPattern").toString()==='currency_euro' || this.getAttribute("maskingPattern").toString()==='currency_french' || this.getAttribute("maskingPattern").toString()==='currency_greek' || this.getAttribute("maskingPattern").toString()==='percentage'|| this.getAttribute("maskingPattern").toString()==='dgroup2'|| this.getAttribute("maskingPattern").toString()==='dgroup3'|| this.getAttribute("maskingPattern").toString()==='NZP'))
            {
                value =  getControlValue(this);
            }
            if(this.type==='select-one'){
                value=this.value===''?'':this.value;
//                if(isShowGridComboLabel=="true"){
//                    value = getSelectedItemLabel(this.id);
//                }
            }
            if(this.type && (this.type==="checkbox" || this.type==="radio"))
                value=this.checked;
            if(this.classList.contains("editableCombo")){
                value=getControlValue(this);
                //Bug 91892
//                 if(isShowGridComboLabel){
//                     value=getSelectedItemLabel(this.id);
//                     if(value=="Select") value="";
//                 }
                 //Bug 91892
            }
            dataValue[formatJSONValue(this.getAttribute("labelName"))]=formatJSONValue(value);

        });
        var invalidControl;
        for(var j=0;j<elementsArray.length;j++){
            if(!validateColumnValue(elementsArray[j],controlId,false)){
                invalidControl=elementsArray[j];
                break;

            }
        }
        if(invalidControls.length>0){
            if(typeof isNext!="undefined"&&isNext){
                if(document.getElementById("addrowandnext_"+controlId)!=null)//Bug 84293
                    document.getElementById("addrowandnext_"+controlId).removeAttribute("data-dismiss");
            }
            else{
                 if(document.getElementById("addrow_"+controlId)!=null)//Bug 84293
                    document.getElementById("addrow_"+controlId).removeAttribute("data-dismiss");
                 if(document.getElementById("copyrow_"+controlId)!=null)//Bug 84293
                    document.getElementById("copyrow_"+controlId).removeAttribute("data-dismiss");
            }
            if(isDuplicate)
                showMessage(invalidControls[0],"Duplicate values not allowed in "+invalidControls[0].getAttribute("labelname"),"error");
            return false;
        }

            dataValue = saveRichTextEditorData('iFrameListViewModal',dataValue,isCopyRow);

    //    if(nullElements.length>0){
    //        document.getElementById("addrow_"+controlId).removeAttribute("data-dismiss");
    //        showMessage("","Null values not allowed in "+nullElements,"error");
    //        return false;
    //    }

    //    if(invalidControl!=undefined || invalidControl!=null){
    //        document.getElementById("addrow_"+controlId).removeAttribute("data-dismiss");
    //        var validationmsg = document.getElementById(controlId+"_"+invalidControl.getAttribute("labelName")+"_msg").innerHTML;
    //        showMessage(invalidControl,validationmsg +":"+'<strong>'+invalidControl.getAttribute("labelName")+'</strong>',"error");
    //      
    //        return false;
    //    }

            executeListView(document.getElementById('table_id').value,'click',JSON.stringify(dataValue),isCopyRow);
            if(typeof isNext!="undefined"&&isNext){
                if(document.getElementById("addrowandnext_"+controlId)!=null)//Bug 84293
                    document.getElementById("addrowandnext_"+controlId).setAttribute("data-dismiss","modal");
                openListViewModel(controlId,'click'); 
            }
            else{
                if(document.getElementById("addrow_"+controlId)!=null)//Bug 84293
                    document.getElementById("addrow_"+controlId).setAttribute("data-dismiss","modal");
                if(document.getElementById("copyrow_"+controlId)!=null)//Bug 84293
                    document.getElementById("copyrow_"+controlId).setAttribute("data-dismiss","modal");
            }
            
            setTableModifiedFlag(controlId);

    }

    function copyRowData(tableId){
     var valid = addRowToTable(tableId,"",true);
     //document.getElementsByClassName('selectedRow')[0].classList.remove("selectedRow");
     if(valid==undefined || valid==true){
        removerowToModify();
      }
     if(window.copyRowPosthook){
         copyRowPosthook(tableId);
     }
    }

    function copyAdvancedListViewRowData(tableId){
     addRowToAdvancedListview(tableId,true);//issue with copy row in advanced listview
     if(window.copyAdvancedListviewRowPosthook){
         copyAdvancedListviewRowPosthook(tableId);
     }
     removeAdvancedListviewrowToModify();
    }

    function modifyTableRows(ref,controlId){
        var rowIndex = $(ref).closest('tr').index();
        if( onRowClick(controlId,rowIndex) ){
            ref.classList.add("rowToModify");

            var colIndex = parseInt($(ref).closest('td').index())-1;
            $(ref).closest('tr')[0].classList.add("selectedRow");
            document.getElementById("rowCount").value=rowIndex;
            var reqString="&controlId="+controlId +"&EventType="+"click"+"&tabledata=yes&pid="+encode_utf8(pid)+"&wid="+encode_utf8(wid)+"&tid="+encode_utf8(tid)+"&fid="+encode_utf8(fid)+"&RowId="+rowId+"&modifyFlag=yes"+"&rowIndex="+rowIndex+"&colIndex="+colIndex;
            openListViewModel(controlId,'click',reqString); 
            enableDisableNextPreviiousButton(controlId,rowIndex);            
            $("#listViewModal").modal();
        }
        else{
            $(ref).closest('tr')[0].classList.remove("selectedRow");
        }
    }
    function modifyAdvancedTableRows(ref,controlId){
        var rowIndex = $(ref).closest('tr').index();
        if( onRowClick(controlId,rowIndex) ){
            ref.classList.add("advancedListviewrowToModify");

            var colIndex = parseInt($(ref).closest('td').index())-1;
            $(ref).closest('tr')[0].classList.add("selectedAdvancedListviewRow");
            document.getElementById("advancedListviewRowCount").value=rowIndex;
            var reqString="&controlId="+controlId +"&EventType="+"click"+"&tabledata=yes&pid="+encode_utf8(pid)+"&wid="+encode_utf8(wid)+"&tid="+encode_utf8(tid)+"&fid="+encode_utf8(fid)+"&RowId="+rowId+"&modifyFlag=yes"+"&rowIndex="+rowIndex+"&colIndex="+colIndex;
            openAdvancedListViewModel(controlId,'click',reqString); 
            enableDisableNextPreviousButtonAdvancedListview(controlId,rowIndex);
            $("#advancedListViewModal").modal();
        }
        else{
             $(ref).closest('tr')[0].classList.remove("selectedAdvancedListviewRow");
        }
    }

    function disableListViewControls(controlId){
        var tableRef = document.getElementById(controlId);
        var addRef = document.getElementById("addrow_"+controlId);
        var saveRef = document.getElementById("savechanges_"+controlId);
        var duplicateRef = document.getElementById("copyrow_"+controlId);//Bug 83138
        if(tableRef!=undefined && tableRef.classList.contains("disabledTable")){
            if(addRef!=null && addRef!=undefined){
                addRef.disabled = true;
                addRef.classList.add("disabledBGColor");
                addRef.classList.add("disabledBtnColor");
            }
            if(saveRef!=null && saveRef!=undefined){
                saveRef.disabled = true;
                saveRef.classList.add("disabledBGColor");
                saveRef.classList.add("disabledBtnColor");
            }
            if(duplicateRef!=null && duplicateRef!=undefined){//Bug 83138
                duplicateRef.disabled = true;//Bug 83138
                duplicateRef.classList.add("disabledBGColor");
                duplicateRef.classList.add("disabledBtnColor");
            }
            $(".tableControl").each(function(){
            setStyle($(this).attr("id"),"disable","true");
        });
        $(".tableButtonControl").each(function(){
            setStyle($(this).attr("id"),"disable","true");
        });
        }


    }

    function disableAdvancedListViewControls(controlId){
        var tableRef = document.getElementById(controlId);
        var addRef = document.getElementById("addAdvancedListviewrow_"+controlId);
        var saveRef = document.getElementById("saveAdvancedListviewchanges_"+controlId);
        var duplicateRef = document.getElementById("duplicateAdvancedListviewchanges_"+controlId);//Bug 83138
        if(tableRef!=undefined && tableRef.classList.contains("disabledTable")){
            if(addRef!=null && addRef!=undefined){
                addRef.disabled = true;
                addRef.classList.add("disabledBGColor");
                addRef.classList.add("disabledBtnColor");
            }
            if(saveRef!=null && saveRef!=undefined){
                saveRef.disabled = true;
                saveRef.classList.add("disabledBGColor");
                saveRef.classList.add("disabledBtnColor");
            }
            if(duplicateRef!=null && duplicateRef!=undefined){//Bug 83138
                duplicateRef.disabled = true;//Bug 83138
                duplicateRef.classList.add("disabledBGColor");
                duplicateRef.classList.add("disabledBtnColor");
            }
            $(".advancedListviewControl").each(function(){
                setStyle($(this).attr("id"),"disable","true");
            });
        }


    }

    function disableListView(controlId){
        var control = document.getElementById(controlId);
        var addRef = document.getElementById("add_"+controlId);
                    if(addRef!=null && addRef!=undefined)
                        addRef.disabled = true;
                    var selectAllCheck = document.getElementById("select_"+controlId);
                    if(selectAllCheck!=null && selectAllCheck!=undefined){
                        selectAllCheck.disabled = true;
                    }
                    var selectRowChecks = control.getElementsByClassName("selectRow");
                    var i;
                    for(i=0;i<selectRowChecks.length;i++){
                        selectRowChecks[i].disabled = true;
                        selectRowChecks[i].parentNode.parentNode.classList.add("disabledTableBGColor");
                    }
                    control.classList.add("disabledTable");
                     if(control.getAttribute("type")=="Table"){
                            $("#"+controlId+' .control-class').parent().parent().addClass("disabledTableBGColor");
                             $("#"+controlId+' .control-class').removeClass("disabledBGColor");
                        }
                        else{
                             $("#"+controlId+' .control-class').each(function(){
                                 disablePicklistButtons(this.id, true);
                                 this.parentNode.classList.add("disabledTableBGColor");
                                 this.classList.remove("disabledBGColor");
                             });
                        }
    }

    function enableListView(controlId,showHideAddDelete){
        showGridAddDeleteButtons(controlId,showHideAddDelete);
        var addRef = document.getElementById("add_"+controlId);
          var control = document.getElementById(controlId);
                    if(addRef!=null && addRef!=undefined)
                        addRef.disabled = false;
                    var selectAllCheck = document.getElementById("select_"+controlId);
                    if(selectAllCheck!=null && selectAllCheck!=undefined){
                        selectAllCheck.disabled = false;
                    }
                    var selectRowChecks = control.getElementsByClassName("selectRow");
                    var i;
                    for(i=0;i<selectRowChecks.length;i++){
                        selectRowChecks[i].disabled = false;
                         selectRowChecks[i].parentNode.parentNode.classList.remove("disabledTableBGColor");
                    }
                    control.classList.remove("disabledTable");
                     if(control.getAttribute("type")=="Table"){
                            $("#"+controlId+' .control-class').parent().parent().removeClass("disabledTableBGColor");
                        }
                        else{
                             $("#"+controlId+' .control-class').each(function(){
                                 disablePicklistButtons(this.id, false);
                                 this.parentNode.classList.remove("disabledTableBGColor");
                             });
                        }
    }


    function modifyRowTableData(controlId){
        var dataTypeValid=validateListviewDataType();
        if(!dataTypeValid){
            document.getElementById("savechanges_"+controlId).removeAttribute("data-dismiss");
            return false;
        }
        else{
            document.getElementById("savechanges_"+controlId).setAttribute("data-dismiss","modal");
        }

        var valid = validateMandatoryFields();
        if(!valid){
            document.getElementById("savechanges_"+controlId).removeAttribute("data-dismiss");
            return false;
        }
        
        var customListViewValid ;
        if(window.customListViewValidation){
            customListViewValid = customListViewValidation(controlId,"M");
            if(!customListViewValid){
                document.getElementById("savechanges_"+controlId).removeAttribute("data-dismiss");
                return false;
            }
            else{
                document.getElementById("savechanges_"+controlId).setAttribute("data-dismiss","modal");
            }
        }
        var elementToModify=document.getElementsByClassName('rowToModify');
        var rowIndex = $(elementToModify[0]).closest('tr').index();
        var invalidControls=[];
        var dataValue={};
        var elementsArray=document.getElementsByClassName('tableControl');
        var nullElements=[];
        var isDuplicate = false;
        var table = document.getElementById(controlId);

        for(var i=0;i<elementsArray.length;i++){
            if(elementsArray[i].className.indexOf("noDuplicate")!=-1){
                var refclass = elementsArray[i].className.substring(elementsArray[i].className.indexOf("noDuplicate")).split(" ")[0];
                var tableCells = table.getElementsByClassName(refclass);
                for(var j=0;j<tableCells.length;j++){
                    var tdContent = tableCells[j].innerText;
                    if (tdContent!="") {
                        if(elementsArray[i].getAttribute("datatype")=="combobox" && elementsArray[i].getAttribute("type")=="text"){
                            var listItems = jQuery(".es-list").find("li");
                                for (var p = 0; p < listItems.length; p++) {
                                    var option = listItems[p].innerText;
                                    if (listItems[p].getAttribute("value") != null && elementsArray[i].value == option){
                                        if( tdContent == listItems[p].getAttribute("value"))
                                        {
                                            isDuplicate = true;
                                            invalidControls.push(elementsArray[i]);
                                            break;
                                        }                                        
                                    }
                                }
                        }
                        else{
                            if(tdContent==elementsArray[i].value &&  j!=document.getElementById("rowCount").value){
                            isDuplicate = true;
                            invalidControls.push(elementsArray[i]);
                            break;
                            }
                        }
                    }
                }
            }

        }
        $(elementsArray).each(function(i) {
            if((this.className.indexOf("denyNull")!=-1)&&(this.value==""||this.value==null)){
                nullElements.push(this.className.split("_")[1]);
            }
            if(this.getAttribute("typeofvalue") && (this.getAttribute("typeofvalue")==='Date' || this.getAttribute("typeofvalue")==='Boolean' || this.getAttribute("typeofvalue")==='Integer' || this.getAttribute("typeofvalue")==='Float' || this.getAttribute("typeofvalue")==='Long')){
                if(!validateTypeOfValue(this))
                {
                    invalidControls.push(this);
                }
            }
            else{
                var type=jQuery(this).attr("datatype");
                if(!validateValue(this,type))
                {
                    invalidControls.push(this);
                }
            }
            for(var i=0;i<elementsArray.length;i++){
                if(elementsArray[i].getAttribute("datatype")=="combobox")
                {
                        var listItems = jQuery(".es-list").find("li");
                        for( var p=0; p < listItems.length; p++ ) {
                            var option = listItems[p].innerText;
                            if (elementsArray[i].value == option)
                                value =  listItems[p].getAttribute("value");
                        }
                }
                else
                    var value=this.value?this.value:this.innerHTML;
             }
           
        if(this.getAttribute("maskingPattern") && (this.getAttribute("maskingPattern").toString()==='currency_rupees' || this.getAttribute("maskingPattern").toString()==='currency_dollar' || this.getAttribute("maskingPattern").toString()==='currency_yen' || this.getAttribute("maskingPattern").toString()==='currency_euro' || this.getAttribute("maskingPattern").toString()==='currency_french' || this.getAttribute("maskingPattern").toString()==='currency_greek' || this.getAttribute("maskingPattern").toString()==='percentage'|| this.getAttribute("maskingPattern").toString()==='dgroup2'|| this.getAttribute("maskingPattern").toString()==='dgroup3'|| this.getAttribute("maskingPattern").toString()==='NZP'))
            {
                value =  getControlValue(this);
            }
            if(this.type==='textarea'){
                value=this.value;
                if((value=='' || value==undefined) && (this.classList.contains("richtexteditor"))) //85748
                    value=this.innerHTML; // Bug 84951
            }
            if(this.type==='select-one'){
                value=this.value===''?'':this.value;
                if(isShowGridComboLabel=="true"){
                    value = getSelectedItemLabel(this.id);
                }
            }
            if(this.type && (this.type==="checkbox" || this.type==="radio"))
                value=this.checked;
            
            if(this.classList.contains("editableCombo")){
                 value=getControlValue(this);
                 //Bug 91892
//                 if(isShowGridComboLabel){
//                     value=getSelectedItemLabel(this.id);
//                     if(value=="Select") value="";
//                 }
                 //Bug 91892
            }
            dataValue[formatJSONValue(this.getAttribute("labelName"))]=formatJSONValue(value);
        });

        var invalidControl;
         for(var j=0;j<elementsArray.length;j++){
            if(!validateColumnValue(elementsArray[j],controlId,false)){
                invalidControl=elementsArray[j];
                break;

            }
        }

        if(invalidControls.length>0){
            document.getElementById("savechanges_"+controlId).removeAttribute("data-dismiss");
            if(isDuplicate)
                    showMessage(invalidControls[0],"Duplicate values not allowed in "+invalidControls[0].getAttribute("labelname"),"error");
            return false;
        }
    //    if(nullElements.length>0){
    //        document.getElementById("savechanges_"+controlId).removeAttribute("data-dismiss");
    //        showMessage("","Null values not allowed in "+nullElements,"error");
    //        return false;
    //    }
    //     if(invalidControl!=undefined || invalidControl!=null){
    //         document.getElementById("savechanges_"+controlId).removeAttribute("data-dismiss");
    //        var validationmsg = document.getElementById(controlId+"_"+invalidControl.getAttribute("labelName")+"_msg").innerHTML;
    //        showMessage(invalidControl,validationmsg +":"+'<strong>'+invalidControl.getAttribute("labelName")+'</strong>',"error");
    //        return false;
    //    }

            if(isOverlayOpen=="Y"){
                if(window.overrideRestrictOverlay)
                {
                    if(overrideRestrictOverlay(controlId)){
                        document.getElementById("savechanges_"+controlId).setAttribute("data-dismiss","modal");
                    }
                }
                else
                document.getElementById("savechanges_"+controlId).removeAttribute("data-dismiss");
            }
            else{
                document.getElementById("savechanges_"+controlId).setAttribute("data-dismiss","modal");
            }
            
            dataValue = saveRichTextEditorData('iFrameListViewModal',dataValue);
            var url = "action.jsp";
            var requestString=  "controlId="+controlId +"&rowIndex="+rowIndex +"&dataValue=" + encode_utf8(JSON.stringify(dataValue)) + "&modifyFlag=yes";
            if(documentIndex!='')
                requestString = requestString+"&docIndex="+documentIndex;
            var contentLoaderRef = new net.ContentLoader(url, modifyRowlistviewResponseHandler, ajaxFormErrorHandler, "POST", requestString, false);
            try{
                var json=JSON.parse(JSON.stringify(dataValue));
                var month_array=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
                $(elementToModify[0].parentNode).children().each(function(i) {
                    if(i>0){
                        if((mobileMode==="ios"||mobileMode==="android")&&this.children[0].getAttribute("columnMappedField")!=null){
                            if(this.children[0].getAttribute("columnMappedField")==="7"||this.children[0].getAttribute("columnMappedField")==="9"){
                                if(json[this.children[0].getAttribute("labelName")]!=""){
                                    var newdate=new Date(json[this.children[0].getAttribute("labelName")]);
                                    var ds="/",df="";
                                    if(globalDateSeparator=="1")
                                        ds="/";
                                    else if(globalDateSeparator=="2")
                                        ds="-";
                                    else if(globalDateSeparator=="3")
                                        ds=".";
                                    if(globalDateFormat=="1")
                                        df=newdate.getDate()+ds+(newdate.getMonth()+1)+ds+newdate.getFullYear();
                                    else if(globalDateFormat=="2")
                                        df=(newdate.getMonth()+1)+ds+newdate.getDate()+ds+newdate.getFullYear();
                                    else if(globalDateFormat=="3")
                                        df=newdate.getFullYear()+ds+(newdate.getMonth()+1)+ds+newdate.getDate();
                                    else if(globalDateFormat=="4")
                                        df=newdate.getDate()+ds+month_array[newdate.getMonth()]+ds+newdate.getFullYear();
                                    if(this.children[0].getAttribute("columnMappedField")==="9")
                                        df+=" "+newdate.getHours()+":"+newdate.getMinutes();
                                    this.children[0].innerHTML=encode_ParamValue(df);
                                }
                                else
                                    this.children[0].innerHTML="";
                            }
                            else
                                this.children[0].innerHTML=encode_ParamValue(escapeStringForHTML(json[this.children[0].getAttribute("labelName")]));
                        }
                        else
                            this.children[0].innerHTML=encode_ParamValue(escapeStringForHTML(json[this.children[0].getAttribute("labelName")]));
                    }
                });
                //elementToModify[0].children[0].innerHTML=json[elementToModify[0].children[0].getAttribute("labelName")];
                if(isOverlayOpen != "Y"){
                    elementToModify[0].classList.remove("rowToModify");
                    document.getElementsByClassName('selectedRow')[0].classList.remove("selectedRow");
                }
                $('.listviewlabel').each(function() {
                
            var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
            if((this.getAttribute("maskingpattern")!="nomasking" && this.getAttribute("maskingpattern")!="")
                || (typeofvalue=='Float' && this.getAttribute("maskingpattern")=="nomasking"))
                {
                    maskfield(this,'label');
                }

            });
                var totalValueElements=document.getElementById('totallabel_'+controlId).innerHTML.split(",!,");
                for(var i=0;i<totalValueElements.length;i++){
                    if(totalValueElements[i]!=''){
                     $(document.getElementsByClassName(totalValueElements[i].replace(/&lt;/g, '<').replace(/&gt;/g, '>').replace(/&quot;/g, '"').replace(/&amp;/g, '&'))).each(function() {
                     var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
                    if((this.getAttribute("maskingpattern")!="nomasking" && this.getAttribute("maskingpattern")!="")
                        || (typeofvalue=='Float' && this.getAttribute("maskingpattern")=="nomasking"))
                        {
                        maskfield(this,'label');
                    }
                    });
                    }
                    showTotal('',totalValueElements[i]);
                }
                setTableModifiedFlag(controlId);
                reshuffleIndices(controlId);
                if(window.modifyRowPostHook)
                {
                    modifyRowPostHook(controlId,rowIndex);
                }
            }
            catch(ex){}

    }

    function modifyAdvancedRowTableData(controlId){
        var elementToModify=document.getElementsByClassName('advancedListviewrowToModify');
        var rowIndex = $(elementToModify[0]).closest('tr').index();
        var valid = validateMandatoryFields();
        if(valid)
            valid = fetchCollapsedFrameHTML(controlId);
        if(!valid){
            document.getElementById("saveAdvancedListviewchanges_"+controlId).removeAttribute("data-dismiss");
            return false;
        }
        var customListViewValid ;
        if(window.customListViewValidation){
            customListViewValid = customListViewValidation(controlId,"M");
            if(!customListViewValid){
                document.getElementById("saveAdvancedListviewchanges_"+controlId).removeAttribute("data-dismiss");
                return false;
            }
            else{
                document.getElementById("saveAdvancedListviewchanges_"+controlId).setAttribute("data-dismiss","modal");
            }
        }
        var invalidControls=[];
        var dataValue={};
        var elementsArray=document.getElementsByClassName('advancedListviewControl');
        var nullElements=[];
        $(elementsArray).each(function(i) {
            if(this.tagName=='TABLE')
                return true;
            if((this.className.indexOf("denyNull")!=-1)&&(this.value==""||this.value==null)){
                nullElements.push(this.className.split("_")[1]);
            }

            if(this.getAttribute("typeofvalue") && (this.getAttribute("typeofvalue")==='Date' || this.getAttribute("typeofvalue")==='Boolean' || this.getAttribute("typeofvalue")==='Integer' || this.getAttribute("typeofvalue")==='Float' || this.getAttribute("typeofvalue")==='Long')){
                if(!validateTypeOfValue(this))
                {
                    invalidControls.push(this);
                }
            }
            else{
                var type=jQuery(this).attr("datatype");
                if(!validateValue(this,type))
                {
                    invalidControls.push(this);
                }
            }
            var value=this.value?this.value:this.innerHTML;
        if(this.getAttribute("maskingPattern") && (this.getAttribute("maskingPattern").toString()==='currency_rupees' || this.getAttribute("maskingPattern").toString()==='currency_dollar' || this.getAttribute("maskingPattern").toString()==='currency_yen' || this.getAttribute("maskingPattern").toString()==='currency_euro' || this.getAttribute("maskingPattern").toString()==='currency_french' || this.getAttribute("maskingPattern").toString()==='currency_greek' || this.getAttribute("maskingPattern").toString()==='percentage'|| this.getAttribute("maskingPattern").toString()==='dgroup2'|| this.getAttribute("maskingPattern").toString()==='dgroup3'|| this.getAttribute("maskingPattern").toString()==='NZP'))
            {
                value =  getControlValue(this);
            }
            if(this.type==='textarea'){
                value=this.value;
                if((value=='' || value==undefined) && (this.classList.contains("richtexteditor"))) //85748
                    value=this.innerHTML;
            }
            if(this.type==='select-one')
                value=this.value===''?'':this.value;
            if(this.type && (this.type==="checkbox" || this.type==="radio"))
                value=this.checked;

            //dataValue[formatJSONValue(this.getAttribute("labelName"))]=formatJSONValue(value);
        });
        var invalidControl;
         for(var j=0;j<elementsArray.length;j++){
             if(elementsArray[j].tagName=='TABLE')
                continue;
            if(!validateColumnValue(elementsArray[j],controlId,false)){
                invalidControl=elementsArray[j];
                break;

            }
        }

        if(invalidControls.length>0){
            document.getElementById("saveAdvancedListviewchanges_"+controlId).removeAttribute("data-dismiss");
            return false;
        }
    //    if(nullElements.length>0){
    //        document.getElementById("savechanges_"+controlId).removeAttribute("data-dismiss");
    //        showMessage("","Null values not allowed in "+nullElements,"error");
    //        return false;
    //    }
    //     if(invalidControl!=undefined || invalidControl!=null){
    //         document.getElementById("savechanges_"+controlId).removeAttribute("data-dismiss");
    //        var validationmsg = document.getElementById(controlId+"_"+invalidControl.getAttribute("labelName")+"_msg").innerHTML;
    //        showMessage(invalidControl,validationmsg +":"+'<strong>'+invalidControl.getAttribute("labelName")+'</strong>',"error");
    //        return false;
    //    } 

            dataValue = saveRichTextEditorData('iFrameAdvancedListViewModal',dataValue);
            document.getElementById("saveAdvancedListviewchanges_"+controlId).setAttribute("data-dismiss","modal");
            var url = "action.jsp";
            var requestString=  "controlId="+controlId +"&rowIndex="+rowIndex +"&dataValue=" + encode_utf8(JSON.stringify(dataValue)) + "&modifyFlag=yes";  
            var contentLoaderRef = new net.ContentLoader(url, modifyRowAdvancedlistviewResponseHandler, ajaxFormErrorHandler, "POST", requestString, false);
    }
    function modifyRowAdvancedlistviewResponseHandler(){
        documentIndex="";
        //$("#"+this.req.getResponseHeader("TableId")+ " tbody").append(this.req.responseText);
        var controlId = getQueryVariable(this.params, "controlId");
        $("#"+controlId).floatThead('reflow');
        var dgroupColumns = this.req.getResponseHeader("dgroupColumns");
        if(dgroupColumns != null && dgroupColumns != undefined){
        for(var i=0;i<dgroupColumns.split(",").length;i++){
            var className = "dgroup_"+controlId+"_"+dgroupColumns.split(",")[i];
            //var dgroupCells = document.getElementsByClassName("dgroup_"+controlId+"_"+dgroupColumns.split(",")[i]);

            $('.'+className).each(function() {
                var digitGroup = parseInt(dgroupColumns.split(",")[i].split("_")[1]);
                var dec = '2';
                if(jQuery(this).attr('typeofvalue')=='Float')
                    dec = jQuery(this).attr('Precision');
                jQuery(this).autoNumeric('init',{
                    dGroup: digitGroup,
                    mDec: dec
                }); 
            });
        }
        }
        $('.listviewlabel').each(function() {
            var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
            if((this.getAttribute("maskingpattern")!="nomasking" && this.getAttribute("maskingpattern")!="")
            || (typeofvalue=='Float' && this.getAttribute("maskingpattern")=="nomasking"))
            {
                maskfield(this,'savedlabel');
            }

        });
        var dataValue=decode_utf8(this.req.getResponseHeader("modifiedRowData")); //Bug 91541
        var elementToModify=document.getElementsByClassName('advancedListviewrowToModify');
        var rowIndex = $(elementToModify[0]).closest('tr').index();
        try{
            var json=JSON.parse(dataValue);
            var month_array=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
            $(elementToModify[0].parentNode).children().each(function(i) {
                if(i>0){
                    var labelValue = decode_utf8(json[this.children[0].getAttribute("labelName")]);
                    if(labelValue!=null&&labelValue!=undefined&&labelValue!="undefined")  //Bug 91729
                        this.children[0].innerHTML=labelValue;
                }
            });
            //elementToModify[0].children[0].innerHTML=json[elementToModify[0].children[0].getAttribute("labelName")];
            if(window.isSaveRowAfterModifyCall){
                if(!isSaveRowAfterModifyCall(controlId)){
                    elementToModify[0].classList.remove("advancedListviewrowToModify");
                }
            }
            else{
                elementToModify[0].classList.remove("advancedListviewrowToModify");
            }
            document.getElementsByClassName('selectedAdvancedListviewRow')[0].classList.remove("selectedAdvancedListviewRow");
            $('.listviewlabel').each(function() {
            var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
            if((this.getAttribute("maskingpattern")!="nomasking" && this.getAttribute("maskingpattern")!="")
            || (typeofvalue=='Float' && this.getAttribute("maskingpattern")=="nomasking"))
            {
                maskfield(this,'label');
            }

        });
            var totalValueElements=document.getElementById('totallabel_'+controlId).innerHTML.split(",!,");
            for(var i=0;i<totalValueElements.length;i++){
                if(totalValueElements[i]!=''){
                    $(document.getElementsByClassName(totalValueElements[i].replace(/&lt;/g, '<').replace(/&gt;/g, '>').replace(/&quot;/g, '"').replace(/&amp;/g, '&'))).each(function() {
                    var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
                    if((this.getAttribute("maskingpattern")!="nomasking" && this.getAttribute("maskingpattern")!="")
                        || (typeofvalue=='Float' && this.getAttribute("maskingpattern")=="nomasking"))
                        {
                    maskfield(this,'label');
                    }
                });
                }
                showTotal('',totalValueElements[i]);
            }
            setTableModifiedFlag(controlId);
            reshuffleIndices(controlId);
            if(window.modifyRowPostHook)
            {
                modifyRowPostHook(controlId);
            }
        }
        catch(ex){}
    }
    
    function  removerowToModify(){
        var elementToModify=document.getElementsByClassName('rowToModify');
        if(elementToModify){
            for(var i=0;i<elementToModify.length;i++){
                elementToModify[i].classList.remove("rowToModify");
            }
        }
        elementToModify=document.getElementsByClassName('selectedRow');
        if(elementToModify){
            for(var i=0;i<elementToModify.length;i++){
                elementToModify[i].classList.remove("selectedRow");
            }
        }
    }

    function  removeAdvancedListviewrowToModify(){
        var elementToModify=document.getElementsByClassName('advancedListviewrowToModify');
        if(elementToModify){
            for(var i=0;i<elementToModify.length;i++){
                elementToModify[i].classList.remove("advancedListviewrowToModify");
            }
        }
        elementToModify=document.getElementsByClassName('selectedAdvancedListviewRow');
        if(elementToModify){
            for(var i=0;i<elementToModify.length;i++){
                elementToModify[i].classList.remove("selectedAdvancedListviewRow");
            }
        }
    }
    function showNextPreviousResultAdvancedListview(controlId,operation){
        var rowIndex = parseInt(document.getElementById("advancedListviewRowCount").value);
        var elementToModify=document.getElementsByClassName('advancedListviewrowToModify');
        var nextPrevVisibleRowIndex = getNextPreviousVisibleRowIndex(controlId,rowIndex,operation);
        rowIndex = nextPrevVisibleRowIndex;
        var tableRef = document.getElementById(controlId);
        var row = tableRef.tBodies[0].getElementsByTagName("tr")[rowIndex];
        if(row!=undefined && row.getElementsByTagName("td")!=undefined)
            row.getElementsByTagName("td")[1].classList.add('advancedListviewrowToModify');
        if(operation==="next"){
//            $(elementToModify[0]).closest('tr').next().find('td')[1].classList.add('advancedListviewrowToModify');
//            rowIndex=rowIndex+1;
            elementToModify[0].classList.remove('advancedListviewrowToModify');
        }
        else{
//            rowIndex=rowIndex-1;
//            $(elementToModify[0]).closest('tr').prev().find('td')[1].classList.add('advancedListviewrowToModify');
            elementToModify[1].classList.remove('advancedListviewrowToModify');
        }
        document.getElementsByClassName('selectedAdvancedListviewRow')[0].classList.remove("selectedAdvancedListviewRow");
//        $(document.getElementsByClassName('advancedListviewrowToModify')[0]).closest('tr')[0].classList.add("selectedAdvancedListviewRow");
        row.classList.add("selectedAdvancedListviewRow");
        var reqString="&controlId="+controlId +"&EventType="+"click"+"&tabledata=yes&pid="+encode_utf8(pid)+"&wid="+encode_utf8(wid)+"&tid="+encode_utf8(tid)+"&fid="+encode_utf8(fid)+"&RowId="+rowId+"&modifyFlag=yes"+"&rowIndex="+rowIndex+"&Operation="+operation;
        openAdvancedListViewModel(controlId,'click',reqString);
        document.getElementById("advancedListviewRowCount").value=rowIndex;
        enableDisableNextPreviousButtonAdvancedListview(controlId,rowIndex);
        disableAdvancedListViewControls(controlId);
    }
    function enableDisableNextPreviousButtonAdvancedListview(controlId,rowIndex){
        var isNextRowVisible=isNextPrevRowVisible(controlId,rowIndex,"next");
        var isPrevRowVisible=isNextPrevRowVisible(controlId,rowIndex,"prev");
        var ref=document.getElementsByClassName('advancedListviewrowToModify')[0];
        if(isNextRowVisible)
            document.getElementById("AdvancedListviewlistNext").disabled= false;
        else
            document.getElementById("AdvancedListviewlistNext").disabled= true;
        if(isPrevRowVisible)
            document.getElementById("AdvancedListviewlistPrevious").disabled= false;
        else
            document.getElementById("AdvancedListviewlistPrevious").disabled= true;
    }

    function showNextPreviousResultTable(controlId,operation){
        var rowIndex = parseInt(document.getElementById("rowCount").value);
        var elementToModify=document.getElementsByClassName('rowToModify');
        if(window.nextPreviousListviewPrehook){
            nextPreviousListviewPrehook(controlId,rowIndex,operation);
        }
        var nextPrevVisibleRowIndex = getNextPreviousVisibleRowIndex(controlId,rowIndex,operation);
        rowIndex = nextPrevVisibleRowIndex;
        var tableRef = document.getElementById(controlId);
        var row = tableRef.tBodies[0].getElementsByTagName("tr")[rowIndex];
        if(row!=undefined && row.getElementsByTagName("td")!=undefined)
            row.getElementsByTagName("td")[1].classList.add('rowToModify');
        if(operation==="next"){
//            $(elementToModify[0]).closest('tr').next().find('td')[1].classList.add('rowToModify');
//            rowIndex=rowIndex+1;
            elementToModify[0].classList.remove('rowToModify');
        }
        else{
//            rowIndex=rowIndex-1;
//            $(elementToModify[0]).closest('tr').prev().find('td')[1].classList.add('rowToModify');
            elementToModify[1].classList.remove('rowToModify');
        }
        document.getElementsByClassName('selectedRow')[0].classList.remove("selectedRow");
//        $(document.getElementsByClassName('rowToModify')[0]).closest('tr')[0].classList.add("selectedRow");
        row.classList.add("selectedRow");
        var reqString="&controlId="+controlId +"&EventType="+"click"+"&tabledata=yes&pid="+encode_utf8(pid)+"&wid="+encode_utf8(wid)+"&tid="+encode_utf8(tid)+"&fid="+encode_utf8(fid)+"&RowId="+rowId+"&modifyFlag=yes"+"&rowIndex="+rowIndex+"&Operation="+operation;
        openListViewModel(controlId,'click',reqString);
        document.getElementById("rowCount").value=rowIndex;
        enableDisableNextPreviiousButton(controlId,rowIndex);
        disableListViewControls(controlId);
    }
    function getNextPreviousVisibleRowIndex(tableId,currentRowIndex,operation){
        var rowIndex=-1;
        var table = document.getElementById(tableId);
        var rows = table.tBodies[0].getElementsByTagName("tr");
        if(operation=="next"){
            for(var i=currentRowIndex+1;i<=rows.length-1;i++){
            if(rows[i]!=undefined && rows[i].style.display!="none"){
                rowIndex=i;
                break;
                }
            }
        }
        else{
            for(var i=currentRowIndex-1;i>=0;i--){
            if(rows[i]!=undefined && rows[i].style.display!="none"){
                rowIndex=i;
                break;
                }
            }
        }
        return rowIndex;
    }
    
    function isNextPrevRowVisible(controlId,rowIndex,operation){
        var isVisible=false;
        var table = document.getElementById(controlId);
        var rows = table.tBodies[0].getElementsByTagName("tr");
        if(operation=="next"){
            for(var i=rowIndex+1;i<=rows.length-1;i++){
            if(rows[i]!=undefined && rows[i].style.display!="none"){
               isVisible=true;
               break;
                }
            }
        }
        else{
            for(var i=rowIndex-1;i>=0;i--){
            if(rows[i]!=undefined && rows[i].style.display!="none"){
               isVisible=true;
                break;
                }
            }
        }
        return isVisible;
    }
    
    function enableDisableNextPreviiousButton(controlId,rowIndex){
        var ref=document.getElementsByClassName('rowToModify')[0];
        var isNextRowVisible=isNextPrevRowVisible(controlId,rowIndex,"next");
        var isPrevRowVisible=isNextPrevRowVisible(controlId,rowIndex,"prev");
        if(isNextRowVisible)
            document.getElementById("tablelistNext").disabled= false;
        else
            document.getElementById("tablelistNext").disabled= true;
        if(isPrevRowVisible)
            document.getElementById("tablelistPrevious").disabled= false;
        else
            document.getElementById("tablelistPrevious").disabled= true;
    }
    function listviewResponseHandler(){
         var controlId = getQueryVariable(this.params, "controlId");
        $("#"+controlId+ " tbody").append(this.req.responseText);
        $("#"+controlId).floatThead('reflow');
        var dgroupColumns = this.req.getResponseHeader("dgroupColumns");
        for(var i=0;i<dgroupColumns.split(",").length;i++){
            var className = "dgroup_"+controlId+"_"+dgroupColumns.split(",")[i];
            //var dgroupCells = document.getElementsByClassName("dgroup_"+controlId+"_"+dgroupColumns.split(",")[i]);

            $('.'+className).each(function() {
                var digitGroup = parseInt(dgroupColumns.split(",")[i].split("_")[1]);
                var dec = '2';
                if(jQuery(this).attr('typeofvalue')=='Float')
                    dec = jQuery(this).attr('Precision');
                jQuery(this).autoNumeric('init',{
                    dGroup: digitGroup,
                    mDec: dec
                }); 
            });
        }
        $('.listviewlabel').each(function() {
            var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
            if((this.getAttribute("maskingpattern")!="nomasking" && this.getAttribute("maskingpattern")!="")
            || (typeofvalue=='Float' && this.getAttribute("maskingpattern")=="nomasking"))
            {
                maskfield(this,'savedlabel');
            }

        });



    //    for(var i=0;i<maskedColumns.split(",").length;i++){
    //        var maskedClass = controlId+"_"+maskedColumns.split(",")[i];
    //        //var dgroupCells = document.getElementsByClassName("dgroup_"+controlId+"_"+dgroupColumns.split(",")[i]);
    //        
    //        $('.'+maskedClass).each(function() {
    //            var digitGroup = parseInt(dgroupColumns.split(",")[i].split("_")[1]);
    //            jQuery(this).autoNumeric('init',{
    //                dGroup: digitGroup,
    //                mDec: '0'
    //            }); 
    //        });
    //    }

    }

    function modifyRowlistviewResponseHandler(){
        documentIndex="";
        var controlId = getQueryVariable(this.params, "controlId");
        $("#"+controlId+ " tbody").append(this.req.responseText);
        $("#"+controlId).floatThead('reflow');
        
        var dgroupColumns = this.req.getResponseHeader("dgroupColumns");
        for(var i=0;i<dgroupColumns.split(",").length;i++){
            var className = "dgroup_"+controlId+"_"+dgroupColumns.split(",")[i];
            //var dgroupCells = document.getElementsByClassName("dgroup_"+controlId+"_"+dgroupColumns.split(",")[i]);

            $('.'+className).each(function() {
                var digitGroup = parseInt(dgroupColumns.split(",")[i].split("_")[1]);
                var dec = '2';
                if(jQuery(this).attr('typeofvalue')=='Float')
                    dec = jQuery(this).attr('Precision');
                jQuery(this).autoNumeric('init',{
                    dGroup: digitGroup,
                    mDec: dec
                }); 
            });
        }
        $('.listviewlabel').each(function() {
            var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
            if((this.getAttribute("maskingpattern")!="nomasking" && this.getAttribute("maskingpattern")!="")
            || (typeofvalue=='Float' && this.getAttribute("maskingpattern")=="nomasking"))
            {
                maskfield(this,'savedlabel');
            }

        });




    //    for(var i=0;i<maskedColumns.split(",").length;i++){
    //        var maskedClass = controlId+"_"+maskedColumns.split(",")[i];
    //        //var dgroupCells = document.getElementsByClassName("dgroup_"+controlId+"_"+dgroupColumns.split(",")[i]);
    //        
    //        $('.'+maskedClass).each(function() {
    //            var digitGroup = parseInt(dgroupColumns.split(",")[i].split("_")[1]);
    //            jQuery(this).autoNumeric('init',{
    //                dGroup: digitGroup,
    //                mDec: '0'
    //            }); 
    //        });
    //    }

    }

    function addRowlistviewResponseHandler(){
        documentIndex="";
        if(document.getElementById("advancedListViewModal")!=null && document.getElementById("advancedListViewModal").className==="modal in")
        {
            isAdvanceListView=true;
        } else {
            isAdvanceListView=false;
        }
        var modalControl = document.getElementById("listViewModal");
        var controlId = getQueryVariable(this.params, "controlId");
        var tableControl = document.getElementById(controlId);
        var batchCounter=this.req.getResponseHeader("batchCounter");
        $("#"+controlId+ " tbody").append(this.req.responseText);
        $("#"+controlId).floatThead('reflow');
        var totalValueElements=document.getElementById('totallabel_'+controlId).innerHTML.split(",!,");
            for(var i=0;i<totalValueElements.length;i++){
             //var controlRef = document.getElementById('label'+'_'+controlId+'_'+maskedLabels.split(",")[i]);
             if(totalValueElements[i]!=''){
             $(document.getElementsByClassName(totalValueElements[i].replace(/&lt;/g, '<').replace(/&gt;/g, '>').replace(/&quot;/g, '"').replace(/&amp;/g, '&'))).each(function() {
                 
                var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
                if((this.getAttribute("maskingpattern")!="nomasking" && this.getAttribute("maskingpattern")!="")
                    || (typeofvalue=='Float' && this.getAttribute("maskingpattern")=="nomasking"))
                    {
                    maskfield(this,'label');
                }
         });
             }
                showTotal('',totalValueElements[i]);
            }
        var dgroupColumns = this.req.getResponseHeader("dgroupColumns");
        if(dgroupColumns!=null && dgroupColumns!=undefined){
        for(var i=0;i<dgroupColumns.split(",").length;i++){
            var className = "dgroup_"+controlId+"_"+dgroupColumns.split(",")[i];
            //var dgroupCells = document.getElementsByClassName("dgroup_"+controlId+"_"+dgroupColumns.split(",")[i]);

            $('.'+className).each(function() {
                var digitGroup = parseInt(dgroupColumns.split(",")[i].split("_")[1]);
                var dec = '2';
                if(jQuery(this).attr('typeofvalue')=='Float')
                    dec = jQuery(this).attr('Precision');
                jQuery(this).autoNumeric('init',{
                    dGroup: digitGroup,
                    mDec: dec
                }); 
            });
        }
        }
        $('.listviewlabel').each(function() {
            var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
            if((this.getAttribute("maskingpattern")!="nomasking" && this.getAttribute("maskingpattern")!="")
            || (typeofvalue=='Float' && this.getAttribute("maskingpattern")=="nomasking"))
            {
                maskfield(this,'savedlabel');
            }

        });
         $('.tabletextbox').each(function() {
            var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
            if((this.getAttribute("maskingpattern")!="nomasking" && this.getAttribute("maskingpattern")!="")
            || (typeofvalue=='Float' && this.getAttribute("maskingpattern")=="nomasking"))
            {
                maskfield(this,'input');
            }

        });
        
        $('.openPickerClass').each(function()
        {
            if(this.getAttribute("maskingPattern")!=null && this.getAttribute("maskingPattern")!=undefined && this.getAttribute("maskingPattern")!="" )
            {
                maskfield(this,'input');
            }
        });
        initFloatingMessagesForTableCells();
        checkTableHeight(controlId);
        reshuffleIndices(controlId,"",batchCounter);
        if(CleanMapOnCloseModal=="Y"){
            if(window.addRowPostHook)
            {
                addRowPostHook(controlId);
            }
        }
        else{
            if(!isAdvanceListView || modalControl.style.display == 'block' || tableControl.getAttribute("type")=='Table'){
            if(window.addRowPostHook)
                {
                addRowPostHook(controlId);
            }
            }
        }
     

    //    for(var i=0;i<maskedColumns.split(",").length;i++){
    //        var maskedClass = controlId+"_"+maskedColumns.split(",")[i];
    //        //var dgroupCells = document.getElementsByClassName("dgroup_"+controlId+"_"+dgroupColumns.split(",")[i]);
    //        
    //        $('.'+maskedClass).each(function() {
    //            var digitGroup = parseInt(dgroupColumns.split(",")[i].split("_")[1]);
    //            jQuery(this).autoNumeric('init',{
    //                dGroup: digitGroup,
    //                mDec: '0'
    //            }); 
    //        });
    //    }

    }

    function attachDatePicker(){
        //    var actualDateFormat = dateFormat;
        //    var newDateFormat = '';
        //                
        //    if(actualDateFormat == 'dd/MMM/yyyy'){
        //        newDateFormat = 'dd/M/yyyy';
        //    }else if(actualDateFormat == 'dd/MM/yyyy'){
        //        newDateFormat = 'dd/mm/yyyy';
        //    }                
        //    else{
        //        newDateFormat = 'dd/M/yyyy';
        //    }



        //    $('.richtexteditor').each(function() {
        //        $( this ).Editor();
        //    });
        var dfvalue,dsvalue;
        $(document).ready(function(){
            if(jQuery("input[datatype='date']").length>0){

                dfvalue = jQuery("input[datatype='date']").attr("dateformat").split("_")[0];
                dsvalue =  jQuery("input[datatype='date']").attr("dateformat").split("_")[1];
                timeFlag =  jQuery("input[datatype='date']").attr("dateformat").split("_")[2]
            }
            else{
                dfvalue = jQuery("input[controltype='date']").attr('dateformat');
                dsvalue = jQuery("input[controltype='date']").attr('dateseparator');
            }

        })
        var df="",ds="";
        if(dsvalue=="1")
            ds="/"
        else if(dsvalue=="2")
            ds="-"
        else if(dsvalue=="3")
            ds="."

        if(dfvalue=="1")
            df="dd"+ds+"mm"+ds+"yyyy"
        else if(dfvalue=="2")
            df="mm"+ds+"dd"+ds+"yyyy"
        else if(dfvalue=="3")
            df="yyyy"+ds+"mm"+ds+"dd"
        else if(dfvalue=="4")
            df="dd"+ds+"mmm"+ds+"yyyy"
        dateFormat = dfvalue;
        dateSeparator = ds;
        var format1 = df;
        var format11=df.toUpperCase(),format12=df.toUpperCase() +  " HH:mm:ss";
        var format21="",format22="";
        var format21="",format22="";
        if(df=="dd"+ds+"mm"+ds+"yyyy")
            format21 = "d"+ds+"m"+ds+"Y";
        else if(df=="mm"+ds+"dd"+ds+"yyyy")
            format21 = "m"+ds+"d"+ds+"Y";
        else if(df=="yyyy"+ds+"mm"+ds+"dd")
            format21 = "Y"+ds+"m"+ds+"d";
        else if(df=="dd"+ds+"mmm"+ds+"yyyy"){
            format21 = "d"+ds+"M"+ds+"Y";
            format1 = "dd"+ds+"M"+ds+"yyyy";
        }

        format22 = format21 + " H:i:s";

        $(".mydatepicker1").datepicker(
        {
            autoclose: true, 
            format: format1, 
            todayHighlight: true,
            useCurrent:false,//Bug 82142
            disableTouchKeyboard: true,
            clearBtn: true,
            beforeShow: function(input, inst) { 
                inst.dpDiv.css({
                    "z-index":1002
                });
            }
        });

        //    $(".mydatepicker1").datepicker(
        //    {
        //        autoclose: true, 
        ////        format: newDateFormat,
        //        format: df,
        //        todayHighlight: true, 
        //        disableTouchKeyboard: true,
        //        clearBtn: true,
        //        beforeShow: function(input, inst) { 
        //        inst.dpDiv.css({"z-index":1001});
        //    }
        //    });

        $(".mydatepicker").datetimepicker1({
            //                format: 'DD/MM/YYYY'
            format: format11,
            useCurrent:false//Bug 82142
        });
        $(".mydatetimepicker").datetimepicker1({
            format: format12,
            useCurrent:false//Bug 82142
        });



        try{    
            jQuery('.myjquerydatepicker').each(
                function () {
                    if( this.getAttribute("xd") !== "true"){
                    jQuery(this).datetimepicker({
                        i18n: {
                            de: {
                                months: [
                                    'Januar', 'Februar', 'März', 'April',
                                    'Mai', 'Juni', 'Juli', 'August',
                                    'September', 'Oktober', 'November', 'Dezember',
                                ],
                                dayOfWeek: [
                                    "So.", "Mo", "Di", "Mi",
                                    "Do", "Fr", "Sa.",
                                ]
                            }
                        },
                        timepicker: false,
                        format: format21,
                        scrollMonth: false
                                //         format:'d.m.Y'
                    }

                    )
                    this.setAttribute("xd","true");
                    }
                });
            
            
            
	jQuery('.myjquerydatetimepicker').each(
            function () {
                if( this.getAttribute("xd") !== "true"){
                    jQuery(this).datetimepicker({
                        format: format22,
                        scrollMonth: false
                    }

                    )
                    this.setAttribute("xd","true");
                }
            });
        }
        catch(ex){}

        //Bug 59177 - Datepicker >> If checked mandatory checkbox, irrelevant information is showing in textbox
        datepickerinitialised = true;
		document.getElementById("fade").style.display="none";	
    }


    function attachDateRange(ref){
        var currentTime=new Date().getHours()+":"+new Date().getMinutes()+":"+new Date().getSeconds();
        var maxDateTime=$(ref).attr('maxdate')+" "+currentTime;
        var currentDay = new Date().getDate();
        if(currentDay.toString().length==1)
            currentDay = "0"+currentDay;
        if(((new Date().getMonth()+1).toString()).length > 1)
        var currentDate=currentDay+ "/" +(new Date().getMonth()+1)+ "/"+new Date().getFullYear();
        else
            var currentDate=currentDay+ "/" +("0" + (new Date().getMonth()+1).toString())+ "/"+new Date().getFullYear();
        if(!$(ref).hasClass('myjquerydatepicker') && !$(ref).hasClass('myjquerydatetimepicker')){
            if($(ref).attr('mindate')!=""&&$(ref).attr('mindate')!==undefined)
                $(ref).data("DateTimePicker").minDate(moment($(ref).attr('mindate'),'DD/MM/YYYY'));
            if($(ref).attr('maxdate')!=""&&$(ref).attr('maxdate')!==undefined){
                if($(ref).attr('maxdate')==currentDate){
                    $(ref).data("DateTimePicker").maxDate(moment(maxDateTime,'DD/MM/YYYY HH:mm:ss')); 
                }else
                    $(ref).data("DateTimePicker").maxDate(moment($(ref).attr('maxdate')+" 23:59:59",'DD/MM/YYYY HH:mm:ss')); 
            }
        }
        else{//Bug 76754 Start        
            if(!$(ref).attr('mindate')==''&&!$(ref).attr('maxdate')==''){
                var maxTime=false;
                var selectedDate=$(ref).val().split(" ")[0];           
                if($(ref).attr('maxdate')==currentDate){
                    if(currentDate==selectedDate || selectedDate=="")
                        maxTime=new Date().getTime();              
                }              
                $(ref).datetimepicker({
                    formatDate:'d/m/y',
                    minDate:$(ref).attr('mindate'),
                    maxDate:$(ref).attr('maxdate'),
                    useCurrent:false,//Bug 82142
                    maxTime:maxTime,
                    onSelectDate:function(a,b){
                          if($(ref).attr('maxdate')==currentDate)
                          {
                            var aDay =  a.getDate();
                            if(aDay.toString().length==1)
                                aDay = "0"+aDay;
                            if(((a.getMonth()+1).toString()).length > 1)  
                            var selectedDate = aDay + "/" + (a.getMonth()+1) +"/" + a.getFullYear();
                            else
                                var selectedDate = aDay + "/" + ("0"+(a.getMonth()+1).toString()) +"/" + a.getFullYear();
                            if(selectedDate=="" || selectedDate==currentDate){                        
                                this.setOptions({                       
                                maxTime:new Date().getTime()                                      
                             });    
                              if(currentDate==selectedDate){
                                    var selectedTime=$(ref).val().split(" ")[1];    
                                    if(selectedTime>currentTime)
                                       $(ref).val(currentDate +" "+new Date().getHours()+":00:00");
                              }
                            } else{
                                this.setOptions({
                                maxTime:false
                             });
                            }    
                          }
                     },
                     onChangeDateTime:function(a,b){
                        if($(b).val()!=currentJQueryDatePickerValue)
                            $(b).trigger("change");
                        currentJQueryDatePickerValue=$(b).val();

                    },
                    onShow:function(a,b){
                        currentJQueryDatePickerValue=$(b).val();
                    }                     
                });
            }
            else if($(ref).attr('mindate')==''&&!$(ref).attr('maxdate')==''){
                var maxTime=false;
                var selectedDate=$(ref).val().split(" ")[0];           
                if($(ref).attr('maxdate')==currentDate){
                    if(currentDate==selectedDate || selectedDate=="")
                        maxTime=new Date().getTime();
                }
                $(ref).datetimepicker({
                    formatDate:'d/m/y',
                    minDate:false,//Bug 81230
                    maxDate:$(ref).attr('maxdate'),   
                    maxTime:maxTime,
                    useCurrent:false,//Bug 82142
                    onSelectDate:function(a,b){
                        var aDay =  a.getDate();
                    if(aDay.toString().length==1)
                        aDay = "0"+aDay;
                       if(((a.getMonth()+1).toString()).length > 1) 
                       var selectedDate = aDay + "/" + (a.getMonth()+1) +"/" + a.getFullYear();
                       else
                            var selectedDate = aDay + "/" + ("0" + (a.getMonth()+1).toString()) +"/" + a.getFullYear();
                       if(selectedDate=="" || selectedDate==currentDate){                       
                            this.setOptions({                       
                            maxTime:new Date().getTime()                        
                         });                  
                        } else{
                            this.setOptions({
                            maxTime:false
                         });
                        }      
                     },
                     onChangeDateTime:function(a,b){
                        if($(b).val()!=currentJQueryDatePickerValue)
                            $(b).trigger("change");
                        currentJQueryDatePickerValue=$(b).val();

                    },
                    onShow:function(a,b){
                        currentJQueryDatePickerValue=$(b).val();

                    }
                });
            }
            else if(!$(ref).attr('mindate')==''&&$(ref).attr('maxdate')==''){
                $(ref).datetimepicker({
                    formatDate:'d/m/y',
                    maxDate:false,//Bug 81230
                    minDate:$(ref).attr('mindate'),
                    useCurrent:false,//Bug 82142
                     onChangeDateTime:function(a,b){
                        if($(b).val()!=currentJQueryDatePickerValue)
                            $(b).trigger("change");
                        currentJQueryDatePickerValue=$(b).val();
                    },
                    onShow:function(a,b){
                        currentJQueryDatePickerValue=$(b).val();
                    }
                });
            }
            else{
                $(ref).datetimepicker({
                    formatDate:'d/m/y',
                    minDate:false,//Bug 81230
                    maxDate:false,//Bug 81230
                    useCurrent:false,//Bug 82142
                    onChangeDateTime:function(a,b){
                        if($(b).val()!=currentJQueryDatePickerValue)
                            $(b).trigger("change");
                        currentJQueryDatePickerValue=$(b).val();

                    },
                    onShow:function(a,b){
                        currentJQueryDatePickerValue=$(b).val();
                    }
                });
            }
            //Bug 76754 End
        }
    }

    function disablePrevious(){
        try{
        getContentWindow('iFrameSearchModal').getElementById("fetchedData").parentNode.innerHTML=""; //Bug 86671 
        }catch(ex){}
        document.getElementById("picklistPrevious").disabled = true;
        document.getElementById("picklistNext").disabled= false;
        var ctrlId = getContentWindow('iFrameSearchModal').getElementById("controlId").value;
        if(window.postHookPickListCancel ){
            return postHookPickListCancel(ctrlId);
        }
        
    }

    function showNextPreviousResult(from)
    {
        var contrlid,batchsize,isModal,searchString,columnName;
        try
        {
            contrlid = window.frames["iFrameSearchModal"].contentWindow.document.getElementById("controlId").value;
            batchsize= window.frames["iFrameSearchModal"].contentWindow.document.getElementById("batchSize").value;
            isModal=window.frames["iFrameSearchModal"].contentWindow.document.getElementById("isModal").value;
            searchString=window.frames["iFrameSearchModal"].contentWindow.document.getElementById("searchBox").value;
            columnName=window.frames["iFrameSearchModal"].contentWindow.document.getElementById("selectedColumn").options[window.frames["iFrameSearchModal"].contentWindow.document.getElementById("selectedColumn").selectedIndex].value;
        }
        catch(ex){
            contrlid = window.frames["iFrameSearchModal"].document.getElementById("controlId").value;
            batchsize= window.frames["iFrameSearchModal"].document.getElementById("batchSize").value;
            isModal= window.frames["iFrameSearchModal"].document.getElementById("isModal").value;
            searchString=window.frames["iFrameSearchModal"].document.getElementById("searchBox").value;
            columnName=window.frames["iFrameSearchModal"].document.getElementById("selectedColumn").options[window.frames["iFrameSearchModal"].document.getElementById("selectedColumn").selectedIndex].value;
        }
        var url = "action.jsp";
        requestString=  "controlId="+contrlid +"&from="+from+"&isListModal="+isModal+"&searchString="+encodeURIComponent(searchString)+"&columnName="+encodeURIComponent(columnName);               
        var contentLoaderRef = new net.ContentLoader(url, picklistHandler, picklisterrorHandler, "POST", requestString, true);

    }

    function picklistHandler(){
        try
        {
            if(this.req.getResponseHeader("Next")=="false"){
                document.getElementById("picklistNext").disabled= true;
            }
            else if(this.req.getResponseHeader("Next")=="true"){
                document.getElementById("picklistNext").disabled= false;
            }
            if(this.req.getResponseHeader("Previous")=="false"){
                document.getElementById("picklistPrevious").disabled = true;
            }else if(this.req.getResponseHeader("Previous")=="true"){
                document.getElementById("picklistPrevious").disabled= false;
            }
            //Bug 83107 Start
            $(window.frames["iFrameSearchModal"].contentWindow.document.getElementById("myTable")).find("tbody").html(this.req.responseText);
            $("#myTable").floatThead('reflow');
            showSelectedRow();
            //Bug 83107 End
            //window.frames["iFrameSearchModal"].contentWindow.document.getElementById("myTable").innerHTML = this.req.responseText;
        }
        catch(ex){
            //Bug 83107 Start
            $(window.frames["iFrameSearchModal"].document.getElementById("myTable")).find("tbody").html(this.req.responseText);
            $("#myTable").floatThead('reflow');
            showSelectedRow();
            //Bug 83107 End
            //window.frames["iFrameSearchModal"].document.getElementById("fetchedData").innerHTML = this.req.responseText;
        }

    }

    function picklisterrorHandler(){

    }

    function getControlValue(element)
    {
        if(element.className.search("tile")>=0)
            return encode_ParamValue($(element).attr("value"));

        switch(element.type) {
            case "tile":return encode_ParamValue(element.getAttribute("value"));
            case "range":return encode_ParamValue(element.getAttribute("value"));
            case "textarea":
            case "text":
            {
                    if(element.getAttribute("datatype") == "combobox"){//Bug 83221 Start
                        var ele = element.parentNode.getElementsByClassName("es-visible");
                        var listItems = jQuery(".es-list").find("li");
                        if (ele != null && ele.length > 0) {
//                        if (ele[0].getAttribute("value") == null || ele[0].getAttribute("value") == undefined)
//                            return "";
                        for( var p=0; p < listItems.length; p++ ) {
                            var option = listItems[p].textContent;
                            if (element.value == option)
                                return encode_ParamValue(listItems[p].getAttribute("originalValue"));
                        }
                        }else{
                            return element.value; // Bug 91924
                        }
                    }else{
                    //Bug 83221 End
                    if (element.getAttribute("maskingPattern") != null && element.getAttribute("maskingPattern") != undefined && element.getAttribute("maskingPattern") != '' && element.getAttribute("maskingPattern") != 'nomasking' && element.getAttribute("maskingPattern") != 'email') {
                        if (element.getAttribute("maskingPattern").toString() === 'currency_rupees' || element.getAttribute("maskingPattern").toString() === 'currency_dollar' || element.getAttribute("maskingPattern").toString() === 'currency_yen' || element.getAttribute("maskingPattern").toString() === 'currency_euro' || element.getAttribute("maskingPattern").toString() === 'currency_french' || element.getAttribute("maskingPattern").toString() === 'currency_greek' || element.getAttribute("maskingPattern").toString() === 'percentage' || element.getAttribute("maskingPattern").toString() === 'dgroup2' || element.getAttribute("maskingPattern").toString() === 'dgroup3' || element.getAttribute("maskingPattern").toString() === 'NZP')
                            return jQuery(element).autoNumeric('get');
                        else {
                            if (element.getAttribute("datatype") != "date")
                                return jQuery(element).cleanVal();
                            else
                                return encode_ParamValue(element.value);
                        }

                }
                else{
                    if(document.getElementById(element.id).type == "text" && document.getElementById(element.id).style.textTransform == "uppercase")
                        return encode_ParamValue(document.getElementById(element.id).value.toUpperCase());
                    else if(document.getElementById(element.id).type == "text" && document.getElementById(element.id).style.textTransform == "lowercase")
                          return encode_ParamValue(document.getElementById(element.id).value.toLowerCase());
                    else
                        return encode_ParamValue(document.getElementById(element.id).value);
                }
                    }      
                }
            break;
            case "checkbox":
                return element.checked;
                break;
            case "radio":
                return jQuery("input[name="+element.name+"]:checked").val();
                break;
            case "select-one":
                //Bug 81160 - Error in getControlValue() API in IForms 
                if($(element).hasClass("editableCombo")){//Bug 83221 Start
                    element=document.getElementById(element.id);
                    var ele = element.parentNode.getElementsByClassName("es-visible");
                        if( ele != null )
                            return encode_ParamValue(ele[0].getAttribute("originalValue"));
                }//Bug 83221 End
                if(element.selectedIndex==-1)
                    return "";
                else
                    return encode_ParamValue(element.options[element.selectedIndex].value);
                break;
            case "date":
                return encode_ParamValue(document.getElementById(element.id).value);
            case "datetime-local":
                return encode_ParamValue(document.getElementById(element.id).value);
            case "password":{   //Bug 86217
                    var eToken = '674649353866384637';
                    var bf = new Blowfish('DES');
                    var ePwd = bf.encryptx(element.value,eToken);
                    //pwd.value = encode_utf8(ePwd);
                    return encode_utf8(ePwd);
            }
        }
    }

    /* 
     * To change this template, choose Tools | Templates
     * and open the template in the editor.
     */

    if(!com)
    {
        var com = {}
    }

    if(!com.newgen)
    {
        com.newgen={}
    }

      function showGridAddDeleteButtons(controlId,showHideAddDelete){
        var addBtn = document.getElementById("add_"+controlId);
        var deleteBtn = document.getElementById("delete_"+controlId);
        if(showHideAddDelete!=undefined && showHideAddDelete!=null){
            if(showHideAddDelete=="1"){
                deleteBtn.style.display="";
            }
            else if(showHideAddDelete=="2"){
                addBtn.style.display="";
            }
            else if(showHideAddDelete=="3"){
                addBtn.style.display="";
                deleteBtn.style.display="";
            }
        }
    }
    function setStyleInRichText(controlId, attributeName, attributeValue){
        var richTextDiv = document.getElementById("expandibleDiv_"+controlId);
        if(richTextDiv!=null && richTextDiv!=undefined){
        if(attributeName=="visible"){
            if(attributeValue=="true" || attributeValue==true){
                var parent = richTextDiv;
                    while(!parent.classList.contains("form-group")){
                        parent = parent.parentNode;
                    }
                    parent.style.display=""; 
                    parent.parentNode.style.display="";
            }
            else if(attributeValue=="false" || attributeValue==false){
                var parent = richTextDiv;
                while(!parent.classList.contains("form-group")){
                    parent = parent.parentNode;
                }
                parent.parentNode.style.display="none";
            }
        }
        else if(attributeName=="disable" || attributeName=="readonly"){
           if(attributeValue=="true"){
               richTextDiv.classList.add("disabledTextarea");
                $("#"+controlId).froalaEditor('edit.off');
           }
           else if(attributeValue=="false"){
                richTextDiv.classList.remove("disabledTextarea");
                $("#"+controlId).froalaEditor('edit.on');
           }
        }
        else if(attributeName=="mandatory"){
            if(attributeValue=="true"){
                document.getElementById(controlId+"_label").classList.add("mandatoryLabel");
                document.getElementById(controlId).required=true;
            }
            else if(attributeValue=="false"){
                 document.getElementById(controlId+"_label").classList.remove("mandatoryLabel");
                 document.getElementById(controlId).required=false;
            }
        }      
    }
       }
    function setStyle(controlId, attributeName, attributeValue,showHideAddDelete)
    {
        var control = document.getElementById(controlId);
        if(useCustomIdAsControlName && (control==null || control==undefined)){
            control = document.getElementsByName(controlId)[0];
            if(control != null && control != undefined)
                controlId = control.getAttribute("id");
        }
        var richTextDiv = document.getElementById("expandibleDiv_"+controlId);
        if(richTextDiv!=null && richTextDiv!=undefined)
            setStyleInRichText(controlId,attributeName,attributeValue);
        else
        {
        if(control != null && control !=undefined)
        {
        if( attributeName.toLowerCase() === "backcolor")
        {
            if(control.classList.contains("picklistStyle")){
                control.classList.remove("picklistStyle");
            }
            if(/(^[0-9A-F]{6}$)|(^#[0-9A-F]{3}$)/i.test(attributeValue))
                jQuery("#"+controlId).css("background-color","#"+attributeValue);
            else
                jQuery("#"+controlId).css("background-color",attributeValue);
        }
        else if(attributeName.toLowerCase() == "title"){
            control.removeAttribute("onmouseover");
            control.title = attributeValue;
        }

        else if( attributeName.toLowerCase() === "fontcolor")
        {
            if(/(^[0-9A-F]{6}$)|(^#[0-9A-F]{3}$)/i.test(attributeValue))
                jQuery("#"+controlId).css("color","#"+attributeValue);
            else
                jQuery("#"+controlId).css("color",attributeValue);        
        }
        else if( attributeName.toLowerCase() == "charcase"){
            if(attributeValue.toLowerCase() == "up")
                jQuery("#"+controlId).css("text-transform","uppercase");
            else if(attributeValue.toLowerCase() == "low")
                jQuery("#"+controlId).css("text-transform","lowercase");
        }
        else if( attributeName.toLowerCase() === "visible")
        {
            if( attributeValue.toLowerCase() === "true"){
                if(control.classList.contains("iform-emptycell")||control.classList.contains("iform-emptyrow")){
                    control.parentNode.style.display="";
                 }
                else if(control.tagName == 'TABLE'){

                    //                var el=control;
                    //                while ((el = el.parentElement) && !el.classList.contains("col-md-12"));
                    //                el.style.display = "";
                    var mainTable = control.parentNode.parentNode.parentNode;
                    mainTable.style.display = "";
                }
                else if(controlId.indexOf("sheet")!=-1){
                    //jQuery("#"+controlId).css("display","inline");
                    jQuery("#"+controlId).css("display","");
                    jQuery("#"+controlId+"_label").css("display","");
                }
                 else if(control.classList.contains("FrameControl")){
                    control.parentNode.style.display="";
                }
                else{
                    jQuery("#"+controlId).css("display","");
                    jQuery("#"+controlId+"_label").css("display","");
                    control.style.display="";
                    if(control.getAttribute("datatype")!='date' && control.getAttribute("datatype")!='Text' && control.getAttribute("datatype")!='checkbox'&& control.tagName!='LABEL'){
                        var parent = document.getElementById(controlId).parentNode;
                        var isRadio=false;
                        for(var i=0;i<parent.parentNode.classList.length;i++)
                        {
                            if(parent.parentNode.classList[i].indexOf("radio")!==-1)
                            {
                                isRadio=true;
                                break;
                            }    
                        }                                                     
                        if(isRadio)
                        {
                            parent.style.display="";
                        }
                        while(!parent.classList.contains("form-group")){
                            parent = parent.parentNode;
                        }
                        parent.style.display=""; 
                        parent.parentNode.style.display="";
                    }
                    else{
                       var parent = document.getElementById(controlId).parentNode;
                        while(!parent.classList.contains("iform-control")){
                            parent = parent.parentNode;
                        }
                        parent.style.display=""; 
                        parent.parentNode.style.display=""; 
                    }
                    if (control.tagName == 'SELECT' && control.multiple) {     //Bug 81918 - setStyle() API not working on multiselect     
                        $(control).siblings().find('.dropdown-toggle').css("display","");
                        jQuery("#"+controlId+"_label").css("display","");
                        jQuery("#"+controlId).css("display","none");
                    }
                }
            }
            else if( attributeValue.toLowerCase() === "false"){
                if(control.classList.contains("iform-emptycell")||control.classList.contains("iform-emptyrow")){
                    control.parentNode.style.display="none";
                 }
                else if(control.tagName == 'TABLE'){
                    //var el=control;
                    //while ((el = el.parentElement) && !el.classList.contains("col-md-12"));
                    //el.style.display = "none";
                    var tableRef = control.parentNode.parentNode.parentNode;
                    tableRef.style.display = "none";
                }
                else if(controlId.indexOf("sheet")!=-1){
                    var tabId = controlId.substr(0,controlId.indexOf("_"))+"_"+controlId.substr(controlId.indexOf("sheet")+5, controlId.length-1);
                    jQuery("#"+tabId).css("display","none");
                    jQuery("#"+controlId).css("display","none");
                    jQuery("#"+controlId+"_label").css("display","none");
                }
                else if(control.classList.contains("FrameControl")){
                    control.parentNode.style.display="none";
                }
                else{
                    jQuery("#"+controlId).css("display","none");
                    jQuery("#"+controlId+"_label").css("display","none");
                    if(control.getAttribute("datatype")!='date' && control.getAttribute("datatype")!='Text' && control.getAttribute("datatype")!='checkbox'&& control.tagName!='LABEL'){
                        var parent = document.getElementById(controlId).parentNode;
                        var isRadio=false;
                        for(var i=0;i<parent.parentNode.classList.length;i++)
                        {
                            if(parent.parentNode.classList[i].indexOf("radio")!==-1)
                            {
                                isRadio=true;
                                break;
                            }    
                        }                                                     
                        if(isRadio)
                        {
                            parent.style.display="none";
                        }
                        else
                        {
                            while(!parent.classList.contains("form-group")){
                                parent = parent.parentNode;
                            }
                            parent.parentNode.style.display="none";
                        }
                    }                   
                    else{
                       var parent = document.getElementById(controlId).parentNode;
                        while(!parent.classList.contains("iform-control")){
                            parent = parent.parentNode;
                        }
                        parent.parentNode.style.display="none"; 
                    }
                    if (control.tagName == 'SELECT' && control.multiple) {        //Bug 81918 - setStyle() API not working on multiselect 
                        $(control).siblings().find('.dropdown-toggle').css("display","none");
                        jQuery("#"+controlId+"_label").css("display","none");                
                    }
    //                if(control.getAttribute("datatype")=='date'){
    //                    var calendarIcon = control.parentNode.parentNode.parentNode.childNodes[1];
    //                    calendarIcon.style.display="none";
    //                }
    //                 if(control.getAttribute("datatype")=='checkbox'){
    //                    var checkRef = control.parentNode.parentNode.parentNode;
    //                    checkRef.style.display="none";
    //                }
                }
            }
            $(".iform-table").floatThead('reflow');
        }
        else if( attributeName.toLowerCase() === "disable")
        {
            if( attributeValue.toLowerCase() === "true"){
                    if(control.tagName=="TABLE"){
                        var tableDiv = control.parentNode.parentNode;
                        var selectRowColumns = tableDiv.getElementsByClassName("selectRowColumn");                        
                        var addRef = document.getElementById("add_"+controlId);
                        if(addRef!=null && addRef!=undefined){
                            addRef.disabled = true;
                            addRef.style.display = "none";
                        }
                        var deleteRef = document.getElementById("delete_"+controlId);
                        if(deleteRef!=null && deleteRef!=undefined)
                            deleteRef.style.display = "none";                       
                        var i;
                        for(i=0;i<selectRowColumns.length;i++){
                            selectRowColumns[i].firstElementChild.firstElementChild.disabled=true;
                            if(i!=0){
                                   selectRowColumns[i].parentNode.classList.add("disabledTableBGColor");
                                   jQuery(selectRowColumns[i].parentNode.getElementsByClassName("listviewlabel")).addClass("disabledTableFont");
                            }
                        }
                        $("#"+controlId).floatThead('reflow');
                        control.classList.add("disabledTable");
                        if(control.getAttribute("type")=="Table"){
                            $("#"+controlId+' .control-class').addClass("disabledTableBGColor");
                        }
                        else{
                             $("#"+controlId+' .control-class').each(function(){
                                 this.parentNode.classList.add("disabledTableBGColor");
                             });
                        }
                        if(document.getElementById(controlId+"div_pad")!=null){
                            document.getElementById(controlId+"div_pad").firstChild.style.display="none";
                        }
                        if(isDatePicker=="N")
                        {
                            var dateicons = control.getElementsByClassName("glyphicon-calendar");
                            for(var i=0;i<dateicons.length;i++){
                                dateicons[i].style.visibility="hidden";
                    }
                        }
                    }
                    if(control.getAttribute("datatype")!=undefined && control.getAttribute("datatype")=="label")
                    {
                        control.style.pointerEvents = "none";
                    }
                if(control.getAttribute("datatype")!=undefined && control.getAttribute("datatype")=="date"){
                    if(mobileMode!="ios" &&mobileMode!="android")
                    {
                        control.parentNode.parentNode.getElementsByClassName("input-group-addon calenderinput")[0].style.pointerEvents = "none";
                        control.parentNode.parentNode.getElementsByClassName("input-group-addon calenderinput")[0].style.opacity = "0.6";
			if(isDatePicker=="N")
                        	control.parentNode.parentNode.getElementsByClassName("input-group-addon calenderinput")[0].style.visibility = "hidden";
                    }
                    
                }
                 if(!control.classList.contains("FrameControl")){
                    control.disabled = "true";
                 }         
                var radiostyle2 = control.getElementsByClassName("radioTwo");
                if(radiostyle2 != null && radiostyle2 !=undefined)
                {
                    for (var i = 0; i < radiostyle2.length; i++)
                    {
                        radiostyle2[i].childNodes[1].style.background = "#D3D3D3";
                    }
                }              
                 if( $(control.parentNode).hasClass("radioThree")){
                        control = control.parentNode.parentNode;
                    }
                var radiostyle3 = control.getElementsByClassName("radioThree");
                if(radiostyle3 != null && radiostyle3 !=undefined)
                {
                    for (i = 0; i < radiostyle3.length; i++)
                    {
                        radiostyle3[i].style.pointerEvents = "none";
                    }
                }
                if(control.type=="text" || control.type=="textarea")
                    control.title=control.value;
                
                if(control.type!=null&&control.type=="text"){
                   disablePicklistButtons(controlId, true);
            }
                if(control.type!=undefined!=null && control.type!=undefined && control.type=="button"){
                    control.classList.add("disabledBtnColor");
                }

                $("#"+controlId+' .iform-button').addClass("disabledBtnColor");
                $("#"+controlId+' .control-class').attr('disabled', true);//.css("opacity","0.7");
                $("#"+controlId+' .selectRow').attr('disabled', true);
                $("#select_"+controlId).attr('disabled', true);
                $("#"+controlId+' a.control-class').each(function(){
                   // if(this.hasAttribute("href"))
                        $(this).css({"pointer-events": "none","cursor":"default","text-decoration":""});
                });
                $("#"+controlId+' img.control-class').each(function(){
                        $(this).css({"pointer-events": "none"});
                });
                if(control.classList.contains("FrameControl")){
                    if(isDatePicker=="N")
                    {
                        var dateicons = control.getElementsByClassName("glyphicon-calendar");
                        for(var i=0;i<dateicons.length;i++){
                            dateicons[i].style.visibility="hidden";
                        }
                    }
                    $("#"+controlId+' .control-class').addClass("disabledBGColor");
                     $("#"+controlId+' .control-class').each(function(){
                         setStyleInRichText(this.id,attributeName,attributeValue);
                         disablePicklistButtons(this.id, true);
                     });
                    $("#"+controlId+' .iform-table').each(function(){
                        if(this.id!="")
                            disableListView(this.id);
                    });
                }
                else{
                if(control.tagName!="TABLE" && !control.classList.contains("iform-radio"))
                   control.classList.add("disabledBGColor");
                if(control.getAttribute("type")=="checkbox")
                   control.parentNode.childNodes[1].style.cssText="background:#D3D3D3 !important";
                }              
                if(showHideAddDelete=="4")
                {                                                             
                    var i;
                    for (i = 0; i < selectRowColumns.length; i++) {
                        selectRowColumns[i].firstElementChild.firstElementChild.removeAttribute("disabled");
                        if (i != 0) {
                            selectRowColumns[i].parentNode.classList.remove("disabledTableBGColor");
                            jQuery(selectRowColumns[i].parentNode.getElementsByClassName("listviewlabel")).removeClass("disabledTableFont");
                        }                     
                    }
                }

            }

            else if( attributeValue.toLowerCase() === "false"){
                if(control.tagName=="TABLE"){
                        showGridAddDeleteButtons(controlId,showHideAddDelete);
                        var addRef = document.getElementById("add_"+controlId);
                        if(addRef!=null && addRef!=undefined){
                            addRef.disabled = false;
                            addRef.style.display = "";
                        }
                        var deleteRef = document.getElementById("delete_"+controlId);
                        if(deleteRef!=null && deleteRef!=undefined)
                            deleteRef.style.display = "";
                        var tableDiv = control.parentNode.parentNode;
                        var selectRowColumns = tableDiv.getElementsByClassName("selectRowColumn");
                        var i;
                        for(i=0;i<selectRowColumns.length;i++){
                            selectRowColumns[i].firstElementChild.firstElementChild.removeAttribute("disabled");
                            if(i!=0){
                                 selectRowColumns[i].parentNode.classList.remove("disabledTableBGColor");
                                 jQuery(selectRowColumns[i].parentNode.getElementsByClassName("listviewlabel")).removeClass("disabledTableFont");
                            }
                            if(showHideAddDelete=="3"){
                                selectRowColumns[i].style.display="";
                            }
                        }
                        
                        $("#"+controlId).floatThead('reflow');
                        var tableinput = control.getElementsByClassName("tableinput");
                        for(var i=0;i<tableinput.length;i++){
                                tableinput[i].removeAttribute("disabled");
                        }
                        control.classList.remove("disabledTable");
                        if(control.getAttribute("type")=="Table"){
                            $("#"+controlId+' .control-class').removeClass("disabledTableBGColor");
                        }
                        else{
                             $("#"+controlId+' .control-class').each(function(){
                                 this.parentNode.classList.remove("disabledTableBGColor");
                             });
                        }
                        if(document.getElementById(controlId+"div_pad")!=null){
                            document.getElementById(controlId+"div_pad").firstChild.style.display="";
                        }
                        if(isDatePicker=="N")
                        {
                            var dateicons = control.getElementsByClassName("glyphicon-calendar");
                            for(var i=0;i<dateicons.length;i++){
                                dateicons[i].style.visibility="";
                            }
                        }

                    }
                    if(control.getAttribute("datatype")!=undefined && control.getAttribute("datatype")=="label")
                    {
                        control.style.pointerEvents = "";
                    }
                 if(control.getAttribute("datatype")!=undefined && control.getAttribute("datatype")=="date"){
                    if(mobileMode!="ios" &&mobileMode!="android")
                    {
                        control.parentNode.parentNode.getElementsByClassName("input-group-addon calenderinput")[0].style.pointerEvents = "";
                        control.parentNode.parentNode.getElementsByClassName("input-group-addon calenderinput")[0].style.opacity = "";
			if(isDatePicker=="N")
                        	control.parentNode.parentNode.getElementsByClassName("input-group-addon calenderinput")[0].style.visibility = "";
                    }
                    
                }
                if(control.type!=null&&control.type=="text"){
                    disablePicklistButtons(controlId, false);
                }
                if(control.type!=undefined!=null && control.type!=undefined && control.type=="button"){
                    control.classList.remove("disabledBtnColor");
                }
                control.removeAttribute("disabled");
                var radiostyle2 = control.getElementsByClassName("radioTwo");
                if(radiostyle2 != null && radiostyle2 !=undefined)
                {
                    for (var i = 0; i < radiostyle2.length; i++)
                    {
                        radiostyle2[i].childNodes[1].style.background = "unset";
                    }
                }
                if( $(control.parentNode).hasClass("radioThree")){
                    control = control.parentNode.parentNode;
                }
                var radiostyle3 = control.getElementsByClassName("radioThree");
                if(radiostyle3 != null && radiostyle3 !=undefined)
                {
                    for (i = 0; i < radiostyle3.length; i++)
                    {
                        radiostyle3[i].style.pointerEvents = "";
                    }
                }              
                if(control.tagName == 'SELECT' && control.multiple){ //Bug 89121 Start
                    $(control).siblings().children()[0].classList.remove("disabled");
                } //Bug 89121 End
                control.classList.remove("disabledBGColor");
                $("#"+controlId+' .iform-button').removeClass("disabledBtnColor");
                $("#"+controlId+' .control-class').attr('disabled', false);//.css("opacity","");
                $("#"+controlId+' a.control-class').each(function(){
                    //if(this.hasAttribute("href"))
                        $(this).css({"pointer-events": "","cursor":"","text-decoration":"underline"});
                });
                $("#"+controlId+' img.control-class').each(function(){
                        $(this).css({"pointer-events": ""});
                });
                if(control.classList.contains("FrameControl")){
                    if(isDatePicker=="N")
                    {
                        var dateicons = control.getElementsByClassName("glyphicon-calendar");
                        for(var i=0;i<dateicons.length;i++){
                            dateicons[i].style.visibility="";
                        }
                    }
                     $("#"+controlId+' .control-class').removeClass("disabledBGColor");
                     $("#"+controlId+' .control-class').each(function(){
                         setStyleInRichText(this.id,attributeName,attributeValue);
                         disablePicklistButtons(this.id, false);
                         if(this.tagName == 'SELECT' && this.multiple){
                            reloadListBoxLayout(this.id);
                        }
                     });
                    $("#"+controlId+' .iform-table').each(function(){
                        if(this.id!="")
                            enableListView(this.id,showHideAddDelete);
                    });
                }
               else{
                 if(control.tagName!="TABLE" && !control.classList.contains("iform-radio")){
                   control.classList.remove("disabledBGColor");
                   if(control.getAttribute("type")=="checkbox"){
                       control.parentNode.childNodes[1].style.cssText="background:unset";
                   }
               }
                 if(showHideAddDelete=="3"){
                     jQuery(".selectRowColumn").css("display","auto");     
                 }
                }
        }
        }
        else if( attributeName.toLowerCase() === "readonly")
        {
            if( attributeValue.toLowerCase() == "true"){
                if(controlId.indexOf("button")!=-1) 
                    $("#"+controlId).attr('disabled', true);
                control.readOnly  = true;
                if(control.type!=null&&control.type=="text"){
                    if(document.getElementById(controlId+"_pickListbtn")!=null)
                        document.getElementById(controlId+"_pickListbtn").disabled=true;
                     if(document.getElementById(controlId+"_pickListClearbtn")!=null && document.getElementById(controlId+"_pickListClearbtn")!=undefined)
                      document.getElementById(controlId+"_pickListClearbtn").disabled = true;
                }
                if(control.type!=null&&control.type=="select-one"){
                    var options = control.options;
                    for(var i=0;i<options.length;i++){
                        options[i].disabled = true;
                    }
                }
                if(control.classList.contains("FrameControl")){           
                    $("#"+controlId+' .control-class').attr('readonly', true);                                                       
                }
                $("#"+controlId+'.control-class').attr('readonly', true);//Bug 90052               
            }
            else if( attributeValue.toLowerCase() == "false"){
                if(controlId.indexOf("button")!=-1) 
                    $("#"+controlId).attr('disabled', false);
                if(control.type!=null&&control.type=="text"){
                    if(document.getElementById(controlId+"_pickListbtn")!=null)
                        document.getElementById(controlId+"_pickListbtn").disabled=false;
                     if(document.getElementById(controlId+"_pickListClearbtn")!=null && document.getElementById(controlId+"_pickListClearbtn")!=undefined)
                      document.getElementById(controlId+"_pickListClearbtn").disabled = false;
                }
                control.readOnly = false;
                if(control.type!=null&&control.type=="select-one"){
                    var options = control.options;
                    for(var i=0;i<options.length;i++){
                        options[i].disabled = false;
                    }
                }
                if(control.classList.contains("FrameControl")){           
                    $("#"+controlId+' .control-class').attr('readonly', false);        
                }
                $("#"+controlId+'.control-class').attr('readonly', false); //Bug 90052
            }
        }

        else if(attributeName.toLowerCase() == "lock"){
            var lockNode = control.getElementsByClassName("sectionStyle");
            if(attributeValue == "true"){
                lockNode[0].onclick = '';
                document.getElementById(controlId+"_img").style.display="none";
            }
            if(attributeValue == "false"){
                $(lockNode[0]).click(function(){toggleSection(this);});
                document.getElementById(controlId+"_img").style.display="";
    //            lockNode[0].onclick = 'toggleSection()t;'
    //                function(){
    //                toggleSection();
    //            };
            }
        }

        else if(attributeName == "collapsible"){
            var lockNode = control.getElementsByClassName("sectionStyle");
            if(attributeValue == "true"){
                lockNode[0].onclick = function(){
                    toggleSection();
                };
            }
            if(attributeValue == "false"){
                lockNode[0].onclick = '';
            }
        }

        else if(attributeName == "sectionstate"){
            var ref=control.getElementsByClassName("sectionStyle")[0];//Bug 82828
            if(attributeValue == "expanded"){
                if(jQuery(ref).attr("state") == "collapsed")
                    toggleSection(ref);            
            }
            if(attributeValue == "collapsed"){
                if(jQuery(ref).attr("state") == "expanded")
                    toggleSection(ref);
            }
        }

        else if(attributeName == "mandatory"){
            var nodes = control.getElementsByClassName("control-class");
            var mandatoryLabel = document.getElementById(controlId+"_label");
            if(attributeValue == "true"){
                for(var i=0;i<nodes.length;i++){
                    nodes[i].required = true;
                }
                control.required = true;
                if(control.classList.contains("iform-radio")){
                    var buttons = document.getElementsByName(controlId);
                    for(var i=0;i<buttons.length;i++){
                        buttons[i].required = true;
                    }
                }
                mandatoryLabel.classList.add("mandatoryLabel");
            }
            else if(attributeValue == "false"){
                for(var i=0;i<nodes.length;i++){
                    nodes[i].required = false;
                }
                toggleErrorTooltip(control,mndMsgRef,null,false,0);
                control.required = false;
                 if(control.classList.contains("iform-radio")){
                    var buttons = document.getElementsByName(controlId);
                    for(var i=0;i<buttons.length;i++){
                        buttons[i].required = false;
                    }
                }
                mandatoryLabel.classList.remove("mandatoryLabel");
				var ctrlType=jQuery(control).attr("type");//Bug 83904 Start
                if(control.classList.contains("iform-radio")){
                    delete ComponentValidatedMap[jQuery(control).attr("id")];
                }
                else if(ctrlType=="text" || ctrlType=="textarea"|| typeof ctrlType=="undefined"){
                    var value=getControlValue(document.getElementById(jQuery(control).attr("id")));
                    if(typeof ctrlType=="undefined")
                        value=jQuery(control).val();
                    if(jQuery(control).attr("multiple")!="undefined"){
                        jQuery(control).siblings().find('.dropdown-toggle').removeClass("mandatory");
                    }
                    if((value!=null) && (value!='') && (!validateValue(document.getElementById(jQuery(control).attr("id")), ctrlType)) && (control.style.display!="none")){                                              
                        ComponentValidatedMap[jQuery(control).attr("id")]=false;
                    }
                    else
                        delete ComponentValidatedMap[jQuery(control).attr("id")];
                }
                else if(ctrlType=="checkbox"){
                    delete ComponentValidatedMap[jQuery(control).attr("id")];
                }
                if(jQuery(control).parent().parent().parent().hasClass("floating-label-form-group"))
                        jQuery(control).parent().parent().parent().removeClass("mandatory");
                    else
                        jQuery(control).removeClass("mandatory");
                var mndMsgRef=document.getElementById(controlId+"_msg");
                if(mndMsgRef!=null)
                    toggleErrorTooltip(control,mndMsgRef,null,true,0);
                    //mndMsgRef.style.display="none";//Bug 83904 End
            }
        }
        //82661 starts
        else if(attributeName == "maxlength"){
            if(attributeValue!='')
                control.setAttribute("maxlength", attributeValue);
        }
        //82661 ends

        else if( attributeName.toLowerCase() === "fontfamily")
            jQuery("#"+controlId).css("font-family",attributeValue);
        else if( attributeName.toLowerCase() === "fontweight")
            jQuery("#"+controlId).css("font-weight",attributeValue);
        else if( attributeName.toLowerCase() === "fontstyle")
            jQuery("#"+controlId).css("font-style",attributeValue);
        else if( attributeName.toLowerCase() === "fontsize")
            jQuery("#"+controlId).css("font-size",attributeValue);
            else if( attributeName.toLowerCase() == "tooltip")
            jQuery("#"+controlId).attr("title",attributeValue);
        else if(attributeName.toLowerCase() == "custompattern")
        {
            var control = document.getElementById(controlId);
            if(useCustomIdAsControlName && (control==null || control==undefined)){
		            control = document.getElementsByName(controlId)[0];
                    if(control != null && control != undefined)
		                controlId = control.getAttribute("id");
		    }
            if (control != null)
            {
                document.getElementById(controlId + "_patternString").setAttribute("custompattern", attributeValue);
                document.getElementById(controlId + "_patternString").innerHTML = attributeValue;
            }
        }
        else if(attributeName == "identifier"){
             if(attributeValue=="true")
                jQuery("#"+controlId+"_identifier").css("display","");
            else
                jQuery("#"+controlId+"_identifier").css("display","none");
        }
        }
        
        //Bug 81918 - setStyle() API not working on multiselect 
        if (control!=null && control!=undefined && control.tagName == 'SELECT') {           
            if(control.multiple){
                reloadListBoxLayout(controlId);
    }
        }
    }
    }
    
    function disablePicklistButtons(controlId,isDisable){
        if(document.getElementById(controlId+"_pickListbtn")!=null)
            document.getElementById(controlId+"_pickListbtn").disabled=isDisable;
        if(document.getElementById(controlId+"_pickListClearbtn")!=null && document.getElementById(controlId+"_pickListClearbtn")!=undefined)
            document.getElementById(controlId+"_pickListClearbtn").disabled = isDisable;
    }


    function isValueChanged()
    {
        return valueChanged;
    }

    function isComponentValidated(ref)
    {
        var tempFormMode=typeof formMode=="undefined"?"W":formMode;//Bug 82321
        //Bugzilla – Bug 59011
        if( ref != 'Y'&&tempFormMode!="R"){//Bug 82321
          if( window.skipValidation ){
              //return window.skipValidation();
              if(window.skipValidation()){
                  saveRichTextEditorData();//rich text not getting set while using skipValidation
                  return true;
          }
          }
          if(!validateMandatoryFields())
            return false;
          fetchCollapsedFrameHTML();
           if(Object.keys(ComponentValidatedMap).length>0){  //Bug 83114
               setFocus(Object.keys(ComponentValidatedMap)[0], false);
               return false;
           }
        }

        saveRichTextEditorData();
        if(!customServerValidation(ref))
            return false;
         return true;     
    }

    function clearValueChanged()
    {
        valueChanged=false; 
    }

    function fireFormValidation(type)
    {
        if(type != "S")
            return Object.keys(ComponentValidatedMap).length==0;
        else
            return true;
    }


    var ENCODING="UTF-8";
    var hexArr = new Array('0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F');

    function encode_utf8(ch)
    {
        if (ENCODING.toUpperCase() != "UTF-8")
            return escape(ch);

        return encodeURIComponent(ch);

        var i,bytes;
        var utf8 = new String();
        var temp;

        for(i=0, bytes = 0; i<ch.length; i++)
        {
            temp = ch.charCodeAt(i);
            if(temp < 0x80)
            {
                utf8 += String.fromCharCode(temp);
            }
            else if (temp < 0x0800)
            {
                utf8 += String.fromCharCode((temp>> 6 | 0xC0));
                utf8 += String.fromCharCode((temp & 0x3F | 0x80));
            }
            else
            {
                utf8 += String.fromCharCode((temp>> 12 | 0xE0));
                utf8 += String.fromCharCode((temp>> 6 & 0x3F | 0x80));
                utf8 += String.fromCharCode((temp & 0x3F | 0x80));
            }
        }

        if (navigator.appName.indexOf("Netscape") == -1)
        {
            return escape(utf8);
        }
        var esc = new String();
        for(l=0;l<utf8.length;l++)
        {
            if(utf8.charCodeAt(l)<128)
                esc += escape(utf8[l]);
            else
            {
                esc += "%";
                esc += hexArr[utf8.charCodeAt(l)>>4];
                esc += hexArr[utf8.charCodeAt(l) & 0xf];
            }
        }
        return esc;
    }

    function decode_utf8(utftextBytes)
    {
        var utftext = unescape(utftextBytes);
        if (ENCODING.toUpperCase() != "UTF-8")
            return utftext;
        var plaintext = "",temp;

        var i=c1=c2=c3=c4=0;

        while(i<utftext.length)
        {
            c1 = utftext.charCodeAt(i);
            temp = '?';

            if (c1<0x80)
            {
                temp = String.fromCharCode(c1);
                i++;
            }
            else if( (c1>>5) ==    6) //2 bytes
            {
                c2 = utftext.charCodeAt(i+1);

                if( !((c2^0x80)&0xC0))
                    temp = String.fromCharCode(((c1&0x1F)<<6) | (c2&0x3F));
                i+=2;
            }
            else if( (c1>>4) == 0xE)  //3 bytes
            {
                c2 = utftext.charCodeAt(i+1);
                c3 = utftext.charCodeAt(i+2);

                if( !(((c2^0x80)|(c3^0x80))&0xC0) )
                    temp = String.fromCharCode(((c1&0xF)<<12) | ((c2&0x3F)<<6) | (c3&0x3F));
                i+=3;
            }
            else
                i++;
            plaintext += temp;
        }
        return plaintext;
    }

    function getContentWindow(modalId){
        var returnedObject = null;
        try{
            returnedObject =  window.frames[modalId].contentWindow.document;
        }catch(ex){
            returnedObject =  window.frames[modalId].document;
        }
        return returnedObject;
    }
    
    function executeWebService(ref,event,eventType,isKeyDown)//Bug 75527, Bug 75529
    {
        var name;
        if(ref.type=='radio')
            name=ref.name;
        else
            name= ref.id;
         if(window.webServicePreHook){
            if(!webServicePreHook(name)){
                return;
            }
        }
        if(typeof isKeyDown!="undefined"&&isKeyDown){
            var jsonArray=JSON.parse(decode_utf8(eventType));
            eventType="";
            for(var i=0;i<jsonArray.length;i++){
                if(event.keyCode==112){
                    if(jsonArray[i]=='KeyPressF1'){
                        eventType="KeyPressF1";
                        break;
                    }
                }
                else if(event.keyCode==113){
                    if(jsonArray[i]=='KeyPressF2'){
                        eventType="KeyPressF2";
                        break;
                    }
                }
                else if(event.keyCode==114){
                    if(jsonArray[i]=='KeyPressF3'){
                        eventType="KeyPressF3";
                        break;
                    }
                }
                else if(event.keyCode==115){
                    if(jsonArray[i]=='KeyPressF4'){
                        eventType="KeyPressF4";
                        break;
                    }
                }
                else if(event.keyCode==116){
                    if(jsonArray[i]=='KeyPressF5'){
                        eventType="KeyPressF5";
                        break;
                    }
                }
                else if(event.keyCode==117){
                    if(jsonArray[i]=='KeyPressF6'){
                        eventType="KeyPressF6";
                        break;
                    }
                }
                else if(event.keyCode==118){
                    if(jsonArray[i]=='KeyPressF7'){
                        eventType="KeyPressF7";
                        break;
                    }
                }
                else if(event.keyCode==119){
                    if(jsonArray[i]=='KeyPressF8'){
                        eventType="KeyPressF8";
                        break;
                    }
                }
                else if(event.keyCode==120){
                    if(jsonArray[i]=='KeyPressF9'){
                        eventType="KeyPressF9";
                        break;
                    }
                }
                else if(event.keyCode==121){
                    if(jsonArray[i]=='KeyPressF10'){
                        eventType="KeyPressF10";
                        break;
                    }
                }
                else if(event.keyCode==122){
                    if(jsonArray[i]=='KeyPressF11'){
                        eventType="KeyPressF11";
                        break;
                    }
                }
                else if(event.keyCode==123){
                    if(jsonArray[i]=='KeyPressF12'){
                        eventType="KeyPressF12";
                        break;
                    }
                }
                else{
                    if(jsonArray[i]=='KeyDown'){
                        eventType="KeyDown";
                        break;
                    }
                }
            }
        }
        if(eventType!=""){
            var url = "webservice.jsp";
            var requestString = "pid="+encode_utf8(pid)+"&wid="+encode_utf8(wid)+"&tid="+encode_utf8(tid)+"&fid="+encode_utf8(fid)+"&controlId="+encode_utf8(name)+"&eventType="+encode_utf8(eventType);//Bug 75527, Bug 75529
            var contentLoaderRef = new net.ContentLoader(url, WSResponseHandler, formErrorHandler, "POST", requestString, true);
        }

    }

    function getQueryStringValue (key) {  
      return decodeURIComponent(window.location.search.replace(new RegExp("^(?:.*[&\\?]" + encodeURIComponent(key).replace(/[\.\+\*]/g, "\\$&") + "(?:\\=([^&]*))?)?.*$", "i"), "$1"));  
    }  

    function openModal(controlId,header,batchSize,isListViewModal,rowId,colId)
    {
        document.getElementById("picklistHeader").innerHTML=header;
        if(window.picklistPreHook){//Bug 82813 Start
            var control = document.getElementById(controlId);
	        if(useCustomIdAsControlName && (control==null || control==undefined)){
	            control = document.getElementsByName(controlId)[0];
                    if(control != null && control != undefined)
                        controlId = control.getAttribute("id");
	        }
            if(!window.picklistPreHook(controlId))
                return;
        }//Bug 82813 End
        CreateIndicator("application");        
        var isListViewModalPickList=typeof isListViewModal=="undefined"?false:true;
        //Bug 81682 - Picklist functionality not working on nested complex variable
        var sid = jQuery("#sid").val();
        var context = '/' + window.location.pathname.split("/")[1];
        var url = context + "/components/viewer/picklistview.jsp";
        var reqTok = iforms.ajax.processRequest("formuri="+encode_utf8(url), context+"/GetReqToken");
        var requestString="picklistview.jsp?controlId="+controlId+"&rowId="+rowId+"&colId="+colId+"&batchSize="+batchSize+"&fid="+fid+"&buttonId="+getQueryStringValue("buttonId")+"&WD_SID=" + sid + "&WD_RID="+reqTok;//Bug 75468
        if(isListViewModalPickList)
            requestString+="&isListModal=1";
        document.getElementById("iFrameSearchModal").src=requestString;
        $("#searchModal").modal();
    }
    
    function setPickListHeader(controlId,header){
         document.getElementById("picklistHeader").innerHTML=header;
    }
    
    function pickListClear(controlId)
    {
        var control = document.getElementById(controlId);
	        if(useCustomIdAsControlName && (control==null || control==undefined)){
	            control = document.getElementsByName(controlId)[0];
                    if(control != null && control != undefined)
                        controlId = control.getAttribute("id");
	        }
        document.getElementById(controlId).value="";
        ctrOnchangeHandler(document.getElementById(controlId),1);
        if(window.clearPicklistPostHook)
            clearPicklistPostHook(controlId);
    }
    function WSResponseHandler()
{
    var WSResponse = this.req.getResponseHeader("WSResponseJSON");
    if (WSResponse == null) {
        var output = decode_utf8(this.req.responseText);
        var message = this.req.getResponseHeader("message");
        var WSControlId = getQueryVariable(this.params, "controlId");
        if (typeof message != "undefined" && message != "" && message != null)//Bug 82907
            showMessage("", message, "error");
        try {
            var outputArray = JSON.parse(output);
//        var outputArray = responseJSON.responseData;
//        if(responseJSON.APIData!=null)
//            renderExecuteServerEventAPIData(responseJSON.APIData);
            for (var i = 0; i < outputArray.length; i++)
            {
                for (var j = 0; j < outputArray[i].length; j++) {
                    try {
                        var dataArray = outputArray[i][j];
                        var controlId = dataArray.id;
                        var type = dataArray.type;
                        var dataValue = dataArray.value.value;
                        if (type == "textarea" || type == "textbox" || type == "label" || type == "combo" || type == "checkbox"
                                || type == "radio" || type == "datepick") {
                            setValue(controlId, dataValue);
                        } else if (type == "table") {
                            if (dataArray.isAppendData) {
                                $("#" + controlId + " tbody").html($("#" + controlId + " tbody").html() + encode_ParamValue(dataValue));
                            } else {
                                $("#" + controlId + " tbody").html(encode_ParamValue(dataValue));
                            }
                            //$("#"+controlId+ " tbody").appendChild(dataValue);
                            $("#" + controlId).floatThead('reflow');
                            //var dgroupColumns = this.req.getResponseHeader("dgroupColumns");
                            //var maskedLabels = this.req.getResponseHeader("maskedLabels");
                            checkTableHeight(controlId);
                            /*
                             for(var i=0;i<dgroupColumns.split(",").length;i++){
                             var className = "dgroup_"+controlId+"_"+dgroupColumns.split(",")[i];
                             //var dgroupCells = document.getElementsByClassName("dgroup_"+controlId+"_"+dgroupColumns.split(",")[i]);
                             
                             $('.'+className).each(function() {
                             var digitGroup = parseInt(dgroupColumns.split(",")[i].split("_")[1]);
                             var dec = '0';
                             if(jQuery(this).attr('typeofvalue')=='Float')
                             dec = jQuery(this).attr('Precision');
                             jQuery(this).autoNumeric('init',{
                             dGroup: digitGroup,
                             mDec: dec
                             }); 
                             });
                             }
                             */
                            $('.listviewlabel').each(function () {
                                var typeofvalue = typeof this.getAttribute("typeofvalue") == 'undefined' ? '' : this.getAttribute("typeofvalue");
                                if ((this.getAttribute("maskingpattern") != "nomasking" && this.getAttribute("maskingpattern") != "")
                                        || (typeofvalue == 'Float' && this.getAttribute("maskingpattern") == "nomasking"))
                                {
                                    maskfield(this, 'savedlabel');
                                }

                            });
                            $('.tabletextbox').each(function () {
                                var typeofvalue = typeof this.getAttribute("typeofvalue") == 'undefined' ? '' : this.getAttribute("typeofvalue");
                                if ((this.getAttribute("maskingpattern") != "nomasking" && this.getAttribute("maskingpattern") != "")
                                        || (typeofvalue == 'Float' && this.getAttribute("maskingpattern") == "nomasking"))
                                {
                                    maskfield(this, 'input');
                                }

                            });
                            var totalValueElements = document.getElementById('totallabel_' + controlId).innerHTML.split(",!,");
                            for (var k = 0; k < totalValueElements.length; k++) {
                                //var controlRef = document.getElementById('label'+'_'+controlId+'_'+maskedLabels.split(",")[i]);
                                if (totalValueElements[k] != '') {
                                    $(document.getElementsByClassName(totalValueElements[k].replace(/&lt;/g, '<').replace(/&gt;/g, '>').replace(/&quot;/g, '"').replace(/&amp;/g, '&'))).each(function () {
                                        var typeofvalue = typeof this.getAttribute("typeofvalue") == 'undefined' ? '' : this.getAttribute("typeofvalue");
                                        if ((this.getAttribute("maskingpattern") != "nomasking" && this.getAttribute("maskingpattern") != "")
                                                || (typeofvalue == 'Float' && this.getAttribute("maskingpattern") == "nomasking"))
                                        {
                                            maskfield(this, 'label');
                                        }
                                    });
                                }
                                showTotal('', totalValueElements[k]);
                            }

                            if (window.addRowPostHook)
                            {
                                addRowPostHook(controlId);
                            }
                        }
                    } catch (ex) {

                    }
                }
            }

        } catch (ex) {
        }
    } else {
        var control = getQueryVariable(this.params, "controlId");
        try {
            WSResponse = JSON.parse(WSResponse);
            for (var key in WSResponse)
            {
                setValue(decode_utf8(key), decode_utf8(WSResponse[key]));
            }

        } catch (ex) {
        }
    }
    var wsControlID = getQueryVariable(this.params, "controlId");
    if (window.webServicePostHook) {
        webServicePostHook(wsControlID);
    }
}
    function closeSubForm(){
        if(totalSubWindows>0){
            console.log("close window here..");
            allWindows[totalSubWindows].close();
        }
    }
    function doInit(loadType,subFormButtonId){
        alignNavigationContainerStyle();
        setProgressBar();
        try{
            if(typeof window.parent != 'undefined'){
                if(typeof window.parent.NGF_NotifyDataLoaded != 'undefined'){
                    window.parent.NGF_NotifyDataLoaded();
                }
            }
            }
            catch(ex){}
        
        try{

            $('.textbox').each(function() {
                var max=this.getAttribute("rangemax");
                var min=this.getAttribute("rangemin");
                var minValue = '-999999999999999999.99';
                if(this.getAttribute("minvalue")!=null && this.getAttribute("minvalue")!=undefined){
                    minValue=this.getAttribute("minvalue");
                }
                var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
                var precision=typeof this.getAttribute("Precision")=='undefined'?'2':this.getAttribute("Precision");
                var decimal='2';
                if(window.removePrecision){
                    if(removePrecision(this.id)){
                        precision='0';
                    }
                }
                if(typeofvalue =="Float")
                    decimal=precision;
                if(typeofvalue =="Integer")
                    decimal='0';
                if(typeofvalue =="Long")
                    decimal='0';

                if(this.getAttribute("maskingPattern").toString()!='nomasking'&&this.getAttribute("maskingPattern").toString()!=''){
                if(this.getAttribute("maskingPattern").toString()!='currency_rupees' && this.getAttribute("maskingPattern").toString()!=='currency_dollar' && this.getAttribute("maskingPattern").toString()!=='currency_yen' && this.getAttribute("maskingPattern").toString()!=='currency_euro' && this.getAttribute("maskingPattern").toString()!=='currency_french' && this.getAttribute("maskingPattern").toString()!=='currency_greek' && this.getAttribute("maskingPattern").toString()!=='' && this.getAttribute("maskingPattern").toString()!=='percentage'){
                        var placeholder;
                        if(this.getAttribute("maskingPattern").toString().charAt(this.getAttribute("maskingPattern").toString().length-1)!='$'){
                            if(this.getAttribute("maskingPattern").toString()=='dgroup3' || this.getAttribute("maskingPattern").toString()=='dgroup2'){
                                var digitGroup = parseInt(this.getAttribute("maskingPattern").charAt(this.getAttribute("maskingPattern").length-1));
                                jQuery(this).autoNumeric('init',{
                                    dGroup: digitGroup,
                                    mDec: decimal,
                                    vMin: minValue                              

                                });
                                var cleanValue=getValue(this.id);
                                if(cleanValue!=='')
                                    jQuery(this).autoNumeric('set', cleanValue);
                            }
                            else{
                                if(typeofvalue=='Float'&&this.getAttribute("maskingPattern").toString()=='NZP'){
                                jQuery(this).autoNumeric('init',{
                                    aSep : '',  
                                    aDec: '.', 
                                    mDec: decimal,
                                    aPad: false,
                                    vMin: minValue
                                });
                            }
                            else{
                                placeholder=this.getAttribute("maskingPattern").replace(/[A-Za-z0-9*#]/mg , "_");
                                jQuery(this).mask(this.getAttribute("maskingPattern"), {
                                    placeholder: placeholder
                                }, {
                                    clearIfNotMatch: true
                                });
                                return true;//Bug 79052
                            }
                            }
                        }
                    }

                    else{
                        var asign='';
                        var dgroup='';
                        var psign='p';
                    var adec='.';
                    var asep=',';
                        if(this.getAttribute("maskingPattern").toString()==='currency_rupees'){
                            asign='Rs ';
                            dgroup=2;
                        //                    jQuery(this).autoNumeric('init',{aSign: 'Rs ', dGroup: 2 , vMax: max, vMin: min});
                        }
                        else if(this.getAttribute("maskingPattern").toString()==='currency_dollar'){
                            asign='$ ';
                            dgroup=3;
                        //                        psign='s';
                        //                    jQuery(this).autoNumeric('init',{aSign: ' $', dGroup: 3,pSign: 's' ,vMax: max, vMin: min});
                        }
                        else if(this.getAttribute("maskingPattern").toString()==='currency_yen'){
                            asign='¥ ';
                            dgroup=3;
                        //                    jQuery(this).autoNumeric('init',{aSign: '¥ ', dGroup: 3, vMax: max, vMin: min});
                        }
                        else if(this.getAttribute("maskingPattern").toString()==='currency_euro'){
                            asign='€ ';
                            dgroup=3;
                        //                    jQuery(this).autoNumeric('init',{aSign: '€ ', dGroup: 3, vMax: max, vMin: min});
                        }
                    else if(this.getAttribute("maskingPattern").toString()==='currency_french'){
//                        asign=' CHF';
                        dgroup=3;
                        adec = ',';
                        asep = ' ';
                        psign= 's';
                    //                    jQuery(this).autoNumeric('init',{aSign: '€ ', dGroup: 3, vMax: max, vMin: min});
                    }
                     else if(this.getAttribute("maskingPattern").toString()==='currency_greek'){
                        dgroup=3;
                        adec = ',';
                        asep = '.';
                        psign= 's';
                    //                    jQuery(this).autoNumeric('init',{aSign: '€ ', dGroup: 3, vMax: max, vMin: min});
                    }
                        if(this.getAttribute("maskingPattern").toString()!=='percentage' && this.getAttribute("maskingPattern").toString() !=='currency_yen' ){
                            if(max===null)
                                jQuery(this).autoNumeric('init',{
                                    aSign: asign, 
                                    dGroup: dgroup,
                                    pSign:psign,
                                    mDec: decimal,
                                aNeg:true,
                                aDec: adec,
                                aSep: asep,
                                vMin: minValue
                                });
                            else{
                                jQuery(this).autoNumeric('init',{
                                    aSign: asign, 
                                    dGroup: dgroup,
                                    pSign:psign, 
                                mDec: decimal,
                                aDec: adec,
                                aSep: asep,
                                vMin: minValue
                                });
                            }
                        }
                        else if(this.getAttribute("maskingPattern").toString() =='currency_yen'){
                            if(max===null)
                                jQuery(this).autoNumeric('init',{
                                    aSign: asign, 
                                    dGroup: dgroup,
                                    pSign:psign,
                                    mDec: "0",
                                aNeg:true,
                                aDec: adec,
                                aSep: asep,
                                vMin: minValue
                                });
                            else{
                                jQuery(this).autoNumeric('init',{
                                    aSign: asign, 
                                    dGroup: dgroup,
                                    pSign:psign, 
                                mDec: "0",
                                aDec: adec,
                                aSep: asep,
                                vMin: minValue
                                });
                            }
                        }

                        else{
                            jQuery(this).autoNumeric('init',{
                                aSign: " %", 
                                pSign:'s',
                                mDec: decimal,
                                vMin: minValue
                            });//Bug 81106
                        }
                        var cleanValue=getValue(this.id);
                        if(cleanValue!=='')
                            jQuery(this).autoNumeric('set', cleanValue);
                    }

                }
                if(typeofvalue=='Float' && this.getAttribute("maskingPattern") && this.getAttribute("maskingPattern").toString()=='nomasking'){
                    jQuery(this).autoNumeric('init',{
                                aSep : '',  
                                aDec: '.', 
                                mDec: decimal,
                                vMin: minValue
                            });
                }
              

            });
        } catch(e){        
        }

        //  $('.tabletextbox').each(function() {
        //     if(this.getAttribute("maskingpattern")!="nomasking" && this.getAttribute("maskingpattern")!="" ){
        //         maskfield(this,'input');
        //     }

        // });

                applyFormattingGrid();
//        $('.tabletextbox').each(function()
//        {
//            if(this.getAttribute("maskingpattern")!=null && this.getAttribute("maskingpattern")!=undefined && this.getAttribute("maskingpattern")!="nomasking" && this.getAttribute("maskingpattern")!="" )
//            {
//            if(this.getAttribute("maskingPattern").toString()!='currency_rupees' && this.getAttribute("maskingPattern").toString()!=='currency_dollar' && this.getAttribute("maskingPattern").toString()!=='currency_yen' && this.getAttribute("maskingPattern").toString()!=='currency_euro'  && this.getAttribute("maskingPattern").toString()!=='currency_french' && this.getAttribute("maskingPattern").toString()!=='currency_greek' && this.getAttribute("maskingPattern").toString()!=='percentage' && this.getAttribute("maskingPattern").toString()!=='dgroup2' && this.getAttribute("maskingPattern").toString()!=='dgroup3' && this.getAttribute("maskingPattern").toString()!=='email' && this.getAttribute("maskingPattern").toString()!=='NZP')
//                {
//                    var placeholder;
//                    placeholder = this.getAttribute("maskingpattern").replace(/[A-Za-z0-9*#]/mg, "_");
//                    jQuery(this).mask(this.getAttribute("maskingpattern"), {
//                        placeholder: placeholder
//                    }, {
//                        clearIfNotMatch: true
//                    });
//                }
//                else{
//                            maskfield(this,'input');
//            }
//            }
//             var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
//            if(typeofvalue=='Float' && this.getAttribute("maskingpattern")=="nomasking")
//            {
//                maskfield(this,'input');
//            }
//        });
        
        $('.openPickerClass').each(function()
        {
            if(this.getAttribute("maskingPattern")!=null && this.getAttribute("maskingPattern")!=undefined && this.getAttribute("maskingPattern")!="" )
            {
                maskfield(this,'input');
            }
        });

        $('.maskedText').each(function(){
            var digitGroup  = parseInt(this.getAttribute("dgroup"));
            var dec = '0';
            if(jQuery(this).attr('typeofvalue')=='Float')
                dec = jQuery(this).attr('Precision');
            jQuery(this).autoNumeric('init',{
                dGroup: digitGroup,
                mDec: dec
            });
        });

        $('.maskedTotal').each(function(){
            var max=this.getAttribute("rangemax");
            var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
            var precision=typeof this.getAttribute("Precision")=='undefined'?'2':this.getAttribute("Precision");
            var decimal='2';
            if(window.removePrecision){
                    if(removePrecision(this.id)){
                        precision='0';
                    }
                }
                if(typeofvalue =="Float")
                    decimal=precision;
                if(typeofvalue =="Integer")
                    decimal='0';
                if(typeofvalue =="Long")
                    decimal='0';
            if(this.getAttribute("maskingPattern").toString()!='nomasking'&&this.getAttribute("maskingPattern").toString()!=''){
                if(this.getAttribute("maskingPattern").toString()!='currency_rupees' && this.getAttribute("maskingPattern").toString()!=='currency_dollar' && this.getAttribute("maskingPattern").toString()!=='currency_yen' && this.getAttribute("maskingPattern").toString()!=='currency_euro' && this.getAttribute("maskingPattern").toString()!=='currency_french' && this.getAttribute("maskingPattern").toString()!=='currency_greek' && this.getAttribute("maskingPattern").toString()!=='' && this.getAttribute("maskingPattern").toString()!=='percentage'){
                        var placeholder;
                        if(this.getAttribute("maskingPattern").toString().charAt(this.getAttribute("maskingPattern").toString().length-1)!='$'){
                            if(this.getAttribute("maskingPattern").toString()=='dgroup3' || this.getAttribute("maskingPattern").toString()=='dgroup2'){
                                var digitGroup = parseInt(this.getAttribute("maskingPattern").charAt(this.getAttribute("maskingPattern").length-1));
                                jQuery(this).autoNumeric('init',{
                                    dGroup: digitGroup,
                                    mDec: decimal                                

                                });
                                 if(this.value!==''&&this.value!==undefined)
                                    jQuery(this).autoNumeric('set', this.value);
                            }
                            else{
                                if(typeofvalue=='Float'&&this.getAttribute("maskingPattern").toString()=='NZP'){
                                jQuery(this).autoNumeric('init',{
                                    aSep : '',  
                                    aDec: '.', 
                                    mDec: decimal,
                                    aPad: false
                                });
                            }
                            else{
                                placeholder=this.getAttribute("maskingPattern").replace(/[A-Za-z0-9*#]/mg , "_");
                                jQuery(this).mask(this.getAttribute("maskingPattern"), {
                                    placeholder: placeholder
                                }, {
                                    clearIfNotMatch: true
                                });
                                return true;//Bug 79052
                            }
                            }
                        }
                    }

                    else{
                        var asign='';
                        var dgroup='';
                        var psign='p';
                    var adec='.';
                    var asep=',';
                        if(this.getAttribute("maskingPattern").toString()==='currency_rupees'){
                            asign='Rs ';
                            dgroup=2;
                        //                    jQuery(this).autoNumeric('init',{aSign: 'Rs ', dGroup: 2 , vMax: max, vMin: min});
                        }
                        else if(this.getAttribute("maskingPattern").toString()==='currency_dollar'){
                            asign='$ ';
                            dgroup=3;
                        //                        psign='s';
                        //                    jQuery(this).autoNumeric('init',{aSign: ' $', dGroup: 3,pSign: 's' ,vMax: max, vMin: min});
                        }
                        else if(this.getAttribute("maskingPattern").toString()==='currency_yen'){
                            asign='¥ ';
                            dgroup=3;
                        //                    jQuery(this).autoNumeric('init',{aSign: '¥ ', dGroup: 3, vMax: max, vMin: min});
                        }
                        else if(this.getAttribute("maskingPattern").toString()==='currency_euro'){
                            asign='€ ';
                            dgroup=3;
                        //                    jQuery(this).autoNumeric('init',{aSign: '€ ', dGroup: 3, vMax: max, vMin: min});
                        }
                    else if(this.getAttribute("maskingPattern").toString()==='currency_french'){
//                        asign=' CHF';
                        dgroup=3;
                        adec = ',';
                        asep = ' ';
                        psign= 's';
                    //                    jQuery(this).autoNumeric('init',{aSign: '€ ', dGroup: 3, vMax: max, vMin: min});
                    }
                    else if(this.getAttribute("maskingPattern").toString()==='currency_greek'){
                        dgroup=3;
                        adec = ',';
                        asep = '.';
                        psign= 's';
                    //                    jQuery(this).autoNumeric('init',{aSign: '€ ', dGroup: 3, vMax: max, vMin: min});
                    }
                        if(this.getAttribute("maskingPattern").toString()!=='percentage' && this.getAttribute("maskingPattern").toString() !=='currency_yen' ){
                            if(max===null)
                                jQuery(this).autoNumeric('init',{
                                    aSign: asign, 
                                    dGroup: dgroup,
                                    pSign:psign,
                                    mDec: decimal,
                                aNeg:true,
                                aDec: adec,
                                aSep: asep
                                });
                            else{
                                jQuery(this).autoNumeric('init',{
                                    aSign: asign, 
                                    dGroup: dgroup,
                                    pSign:psign, 
                                mDec: decimal,
                                aDec: adec,
                                aSep: asep
                                });
                            }
                        }
                        else if(this.getAttribute("maskingPattern").toString() =='currency_yen'){
                            if(max===null)
                                jQuery(this).autoNumeric('init',{
                                    aSign: asign, 
                                    dGroup: dgroup,
                                    pSign:psign,
                                    mDec: "0",
                                aNeg:true,
                                aDec: adec,
                                aSep: asep
                                });
                            else{
                                jQuery(this).autoNumeric('init',{
                                    aSign: asign, 
                                    dGroup: dgroup,
                                    pSign:psign, 
                                mDec: "0",
                                aDec: adec,
                                aSep: asep
                                });
                            }
                        }

                        else{
                            jQuery(this).autoNumeric('init',{
                                aSign: " %", 
                                pSign:'s',
                                mDec: decimal
                            });//Bug 81106
                        }
                       if(this.value!=='' && this.value != undefined)
                            jQuery(this).autoNumeric('set', this.value);
                    }

                }
        });
        setWidthForTabStyle4();
        $('.tabtheme4.iformTabUL.scrollingTabCSS').each(function(){
            $(this).removeClass("scrollingTabCSS");
            $(this).scrollingTabs({
                disableScrollArrowsOnFullyScrolled :true,
                enableRtlSupport :true,
                enableSwiping:true

            });
        });

        attachDatePicker();    
        initFloatingMessagesForPrimitiveFields('.errorMessageHoverDiv');
        initFloatingMessagesForTableCells();
        initFloatingMessagesForPrimitiveFields('.controlCustomCss');
        $(document).ready(function() {
            var $input = $('.form-input');

            var $textarea = $('.form-textarea');
            var $combo = $('select');
            if($input.attr("datatype")=="date"){
                $(this).focus({

                    })
            }
            $input.focusout(function() {
                if($(this).val().length > 0) {
                    $(this).addClass('input-focus');
                    $(this).next('.form-label').addClass('input-focus-label');
                }
                else {
                    $(this).removeClass('input-focus');
                    $(this).next('.form-label').removeClass('input-focus-label');

                }
            });


            $textarea.focusout(function() {
                if($(this).val().length > 0) {
                    $(this).addClass('textarea-focus');
                    $(this).next('.form-label').addClass('textarea-focus-label');
                }
                else {
                    $(this).removeClass('textarea-focus');
                    $(this).next('.form-label').removeClass('textarea-focus-label');

                }
            });
            $('.mdb-select').multiselect({
                buttonWidth: '100%',
                includeSelectAllOption: true
            });
            setListBoxStyle(); 
            $(document).bind("contextmenu", function(e) {
                if(!$(e.target).is('input') && !$(e.target).is('textarea')){
                    return false;
                }
            });
        });


        if(!isListviewOpened){
        /*    $('.richtexteditor').each(function() {
                $( this ).Editor();           
            });*/
        }

        var editors = document.getElementsByClassName("Editor-editor");

        for(var i=0;i<editors.length;i++){

            editors[i].onblur = function(){
                var txtobj = jQuery(this.parentNode.parentNode).find("[datatype='textarea']");
                txtobj.val(txtobj.Editor("getText"));

                ctrOnchangeHandler(txtobj.get(0),1);
            };       

        }
      
        setFrameScroll();
        if(loadType==="form")
        checkForExistingApplication();
        if(loadType!=null && loadType!=undefined && loadType=="form"){
            executeLoadEvents('1');
            formLoad();
            RemoveIndicator("application");
        }
        if(loadType!=null && loadType!=undefined && loadType=="subForm"){
            executeLoadEvents('2',subFormButtonId);
            if(window.subFormLoad)
                subFormLoad(subFormButtonId);
            RemoveIndicator("application");
        }

        var scrollerWidthofBrowser = getBrowserScrollSize().width;
        //Bug 77001 Start
        if(document.getElementById("affix_padding") && document.getElementById("headerDiv")){
            if(parseInt(window.innerHeight)>parseInt(document.getElementById("headerDiv").clientHeight*3)){

                document.getElementById("affix_padding").style.paddingTop= (parseInt(document.getElementById("headerDiv").clientHeight))+"px";
                if(document.getElementById("headerDiv").style.position!='fixed'){
                    document.getElementById("headerDiv").style.position='fixed';
                    document.getElementById("headerDiv").style.top='0';
                    document.getElementById("headerDiv").style.width=($(window).width() - scrollerWidthofBrowser )+"px";
                    }

            }
            else{
                document.getElementById("headerDiv").style.position='';
                document.getElementById("headerDiv").style.top='';
        //                    document.getElementById("headerDiv").classList.remove("affix");
                document.getElementById("headerDiv").style.width=($(window).width() - scrollerWidthofBrowser )+"px";
            }
        }
        //Bug 77001 End

        $('.listviewlabel').each(function() {
            
            var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
            if((this.getAttribute("maskingpattern")!="nomasking" && this.getAttribute("maskingpattern")!="")
            || (typeofvalue=='Float' && this.getAttribute("maskingpattern")=="nomasking"))
            {
                maskfield(this,'savedlabel');
            }


        });

        $('.totalLabel').each(function() {
            
            var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
            if((this.getAttribute("maskingpattern")!="nomasking" && this.getAttribute("maskingpattern")!="")
            || (typeofvalue=='Float' && this.getAttribute("maskingpattern")=="nomasking"))
            {
                maskfield(this,'savedlistviewlabel');
            }

        });

//            document.addEventListener(
//            'scroll',
//            function(event){
//                jQuery('.myjquerydatepicker').datetimepicker('hide');
//                jQuery('.myjquerydatetimepicker').datetimepicker('hide');
////                jQuery('.mydatepicker').datetimepicker1('hide');
////                jQuery('.mydatetimepicker').datetimepicker1('hide');
//            },
//            true 
//            );  

        if ( mobileMode=="ios" ){
            var inputs = jQuery("input");
            $(document).on('touchstart','body', function (evt) {
                var targetTouches = event.targetTouches;
                if (!inputs.is(targetTouches)){
                    inputs.context.activeElement.blur();
                }
            });
        }
         window.addEventListener('keydown', function (e) {
            if(document.getElementById("searchModal")!=null&&document.getElementById("searchModal").className==="modal in"){
                 var evtObj = window.event || e;
                 var keycode = evtObj.keyCode || evtObj.which;
                if(keycode=="40" || keycode=="38"){
                    cancelBubble(e);
                    togglePicklistRow(e,false);     
                }
                if(keycode=="9"){
                    cancelBubble(e);
                    handleTabKeyEvent(false);
                }
            }
        });
        
         makeStickyTabs();
         moveScroller();//Bug 85154
         
         if((typeof window.parent != 'undefined') && (typeof window.parent.formPopulatedEx != 'undefined')){
             try{
                 window.parent.formPopulatedEx(window);
             } catch(e){                 
             }
         }
         setTileHeight();
    }
    function setTileHeight(){
        var maxTileHeight = 0;
        var getHeight = 0;
        $('.tilePointsHeight').each(function(i,elem){
        getHeight =  parseInt($(elem).css('height').split('px')[0]);
        if(getHeight>maxTileHeight){
        maxTileHeight = getHeight;
        }
        });
        $('.tilePointsHeight').each(function(i,elem){
         $(elem).css('height',maxTileHeight);
        });
        maxTileHeight = 0;
        getHeight = 0;
        $('.tile').each(function(i,elem){
        getHeight = parseInt($(elem).css('height').split('px')[0]);
        if(getHeight>maxTileHeight){
        maxTileHeight = getHeight;
        }
        });
        $('.tile').each(function(i,elem){
         $(elem).css('height',maxTileHeight);
         $(elem).parent().css('height',maxTileHeight+30);
        });
    }
    function togglePicklistRow(e,isPicklistScope){
        var evtObj = window.event || e;
        var keycode = evtObj.keyCode || evtObj.which;
        var dataTable;
        if(isPicklistScope)
            dataTable = document.getElementById("myTable");
        else{
            try{
                dataTable = window.frames["iFrameSearchModal"].contentWindow.document.getElementById("myTable");
            }
            catch(ex){
                dataTable = window.frames["iFrameSearchModal"].document.getElementById("myTable"); 
            }
        }

        var dataTableRows = dataTable.tBodies[0].getElementsByTagName("tr");
        var selectedRowIndex=0;
        for(var i=0;i<dataTableRows.length;i++){
            if(dataTableRows[i].classList.contains("info")){
                selectedRowIndex=i;
                break;
            }
        }
        if(keycode=="40"){
            if(selectedRowIndex<dataTableRows.length-1){
                dataTableRows[selectedRowIndex].classList.remove("info");
                dataTableRows[selectedRowIndex+1].classList.add("info");
            }
        }
        else if(keycode=="38"){
            if(selectedRowIndex>0){
                dataTableRows[selectedRowIndex].classList.remove("info");
                dataTableRows[selectedRowIndex-1].classList.add("info");
            }
        }
    }
    
    function handleTabKeyEvent(isPicklistScope){
        var picklistOkBtn;
        var picklistCancelBtn;
        var picklistNextBtn = document.getElementById("picklistNext");
        var picklistPreviousBtn = document.getElementById("picklistPrevious");
        var columnList;
        var searchBox;
        if(isPicklistScope){
            try{
                picklistOkBtn = window.parent.frames["iFrameSearchModal"].parentNode.parentNode.parentNode.getElementsByClassName("btn-success")[0]
                picklistCancelBtn = window.parent.frames["iFrameSearchModal"].parentNode.parentNode.parentNode.getElementsByClassName("btn-danger")[0];
                columnList = document.getElementById("selectedColumn");
                searchBox = document.getElementById("searchBox");
            }
            catch(ex){
                picklistOkBtn = window.parent.document.getElementById("picklistOk");
                picklistCancelBtn = window.parent.document.getElementById("picklistOk");
                columnList = document.getElementById("selectedColumn");
                searchBox = document.getElementById("searchBox");
            }
        }
        else{
            picklistOkBtn = document.getElementById("picklistOk");
            picklistCancelBtn = document.getElementById("picklistCancel");
            if(picklistOkBtn==null || picklistOkBtn==undefined){
                picklistOkBtn = window.frames["iFrameSearchModal"].parentNode.parentNode.parentNode.getElementsByClassName("btn-success")[0];
            }
            if(picklistCancelBtn==null || picklistCancelBtn==undefined){
                picklistCancelBtn = window.frames["iFrameSearchModal"].parentNode.parentNode.parentNode.getElementsByClassName("btn-danger")[0];
            }
            try{
            columnList=window.frames["iFrameSearchModal"].contentWindow.document.getElementById("selectedColumn");
            searchBox=window.frames["iFrameSearchModal"].contentWindow.document.getElementById("searchBox");
            }
            catch(ex){
                columnList=window.frames["iFrameSearchModal"].document.getElementById("selectedColumn");
                searchBox=window.frames["iFrameSearchModal"].document.getElementById("searchBox");
            }
        }
       
        if(document.activeElement.id=="" || document.activeElement.id=="searchModal" || document.activeElement.tagName=="BODY"){
            picklistOkBtn.focus();
        }
        else if(document.activeElement==picklistOkBtn){
            picklistCancelBtn.focus();
        }
        else if(document.activeElement==picklistCancelBtn){
            if(picklistNextBtn.disabled==false){
                picklistNextBtn.focus();
            }
            else{
                if(picklistPreviousBtn.disabled==false){
                    picklistPreviousBtn.focus();
                }
                else{
                    columnList.focus();
                }
            }
        }
        else if(document.activeElement==picklistNextBtn){
            if(picklistPreviousBtn.disabled==false){
                picklistPreviousBtn.focus();
            }
            else{
                columnList.focus();
            }
        }
        else if(document.activeElement==picklistPreviousBtn){
            columnList.focus();
        }
        else if(document.activeElement==columnList){
            searchBox.focus();
        }
        else if(document.activeElement==searchBox){
            picklistOkBtn.focus();
        }
}
    function showSelectedRow(){
        var picklistTable;
        try{
            picklistTable = window.parent.frames["iFrameSearchModal"].contentWindow.document.getElementById("myTable");
        }
        catch(ex){
            if(window.parent.frames["iFrameSearchModal"]!=null && window.parent.frames["iFrameSearchModal"]!=undefined){
                if(window.parent.frames["iFrameSearchModal"].document!=null && window.parent.frames["iFrameSearchModal"].document!=undefined){
                    picklistTable = window.parent.frames["iFrameSearchModal"].document.getElementById("myTable");
                }
            else{
                    picklistTable = window.parent.frames["iFrameSearchModal"].contentWindow.document.getElementById("myTable");
                }
            }
            else{
                if(window.frames["iFrameSearchModal"].document!=null && window.frames["iFrameSearchModal"].document!=undefined){
                    picklistTable = window.frames["iFrameSearchModal"].document.getElementById("myTable");
                }
                else{
                    picklistTable = window.frames["iFrameSearchModal"].contentWindow.document.getElementById("myTable");
                }
                 
            }
            
        }
        var firstRowRef = picklistTable.tBodies[0].getElementsByTagName("tr")[0];
        firstRowRef.click();
    }
    
    function makeStickyTabs(isListView){
    var headerDiv = document.getElementById("headerDiv");
    var tabLists = document.getElementsByClassName("fixed-tabmenu");
    if(isListView)
        tabLists = document.getElementById("iFrameAdvancedListViewModal").getElementsByClassName("fixed-tabmenu");
    if(document.getElementById("affix_padding") && headerDiv){
        if(parseInt(window.innerHeight)>parseInt(headerDiv.clientHeight*3)){
            for(var i=0;i<tabLists.length;i++){
                if(tabLists[i].classList.contains("listviewTab"))
                    tabLists[i].style.top = "0px";
                else
                    tabLists[i].style.top = (headerDiv.clientHeight-5)+"px";
            }
        }
        else{
            for(var i=0;i<tabLists.length;i++){
                tabLists[i].style.top = "0px";
            }
        }
    }
    else{
        for(var i=0;i<tabLists.length;i++){
            tabLists[i].style.top = "0px";
        }
    }
    
}

    function listViewInit(controlId,action){//Bug 80908
        $('.tableControl.textbox').each(function() {
            var max=this.getAttribute("rangemax");
            var min=this.getAttribute("rangemin");
             var minValue = '-999999999999999999.99';
             if(this.getAttribute("minvalue")!=null && this.getAttribute("minvalue")!=undefined){
                minValue=this.getAttribute("minvalue");
            }
            var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
            var precision=typeof this.getAttribute("Precision")=='undefined'?'2':this.getAttribute("Precision");
            var decimal='2';
            if(typeofvalue =="Float")
                decimal=precision;
            if(typeofvalue =="Integer")
                decimal='0';
            if(typeofvalue =="Long")
                decimal='0';

            if(this.getAttribute("maskingPattern").toString()!='nomasking'){
            if(this.getAttribute("maskingPattern").toString()!='currency_rupees' && this.getAttribute("maskingPattern").toString()!=='currency_dollar' && this.getAttribute("maskingPattern").toString()!=='currency_yen' && this.getAttribute("maskingPattern").toString()!=='currency_euro' && this.getAttribute("maskingPattern").toString()!=='currency_french' && this.getAttribute("maskingPattern").toString()!=='currency_greek' && this.getAttribute("maskingPattern").toString()!=='' && this.getAttribute("maskingPattern").toString()!=='percentage'){
                    var placeholder;
                    if(this.getAttribute("maskingPattern").toString().charAt(this.getAttribute("maskingPattern").toString().length-1)!='$'){
                        if(this.getAttribute("maskingPattern").toString()=='dgroup3' || this.getAttribute("maskingPattern").toString()=='dgroup2'){
                            var digitGroup = parseInt(this.getAttribute("maskingPattern").charAt(this.getAttribute("maskingPattern").length-1));
                            jQuery(this).autoNumeric('init',{
                                dGroup: digitGroup,
                                mDec: decimal,
                                vMin: minValue                               

                            });
                        }
                        else{
                        if(typeofvalue=='Float' && this.getAttribute("maskingPattern") && this.getAttribute("maskingPattern").toString()=='NZP'){
                            jQuery(this).autoNumeric('init',{
                                aSep : '',  
                                aDec: '.', 
                                mDec: decimal,
                                aPad: false,
                                vMin: minValue
                            });
                        }
                        else{
                            placeholder=this.getAttribute("maskingPattern").replace(/[A-Za-z0-9*#]/mg , "_");
                            jQuery(this).mask(this.getAttribute("maskingPattern"), {
                                placeholder: placeholder
                            }, {
                                clearIfNotMatch: true
                            });
                            return true;//Bug 79052
                        }
                    }
                    }
                }

                else{
                    var asign='';
                    var dgroup='';
                    var psign='p';
                var adec='.';
                var asep=',';
                    if(this.getAttribute("maskingPattern").toString()==='currency_rupees'){
                        asign='Rs ';
                        dgroup=2;
                    }
                    else if(this.getAttribute("maskingPattern").toString()==='currency_dollar'){
                        asign='$ ';
                        dgroup=3;
                    }
                    else if(this.getAttribute("maskingPattern").toString()==='currency_yen'){
                        asign='¥ ';
                        dgroup=3;
                    }
                    else if(this.getAttribute("maskingPattern").toString()==='currency_euro'){
                        asign='€ ';
                        dgroup=3;
                    }
                else if(this.getAttribute("maskingPattern").toString()==='currency_french'){
//                    asign=' CHF';
                    dgroup=3;
                    adec = ',';
                    asep = ' ';
                    psign= 's';
                }
                else if(this.getAttribute("maskingPattern").toString()==='currency_greek'){
                    dgroup=3;
                    adec = ',';
                    asep = '.';
                    psign= 's';
                }
                    if(this.getAttribute("maskingPattern").toString()!=='percentage' && this.getAttribute("maskingPattern").toString() !=='currency_yen' ){
                        if(max===null)
                            jQuery(this).autoNumeric('init',{
                                aSign: asign, 
                                dGroup: dgroup,
                                pSign:psign,
                                mDec: decimal,
                            aNeg:true,
                            aDec: adec,
                            aSep: asep,
                            pSign: psign,
                            vMin: minValue
                            });
                        else{
                            jQuery(this).autoNumeric('init',{
                                aSign: asign, 
                                dGroup: dgroup,
                                pSign:psign, 
                            mDec: decimal,
                            aDec: adec,
                            aSep: asep,
                            pSign: psign,
                            vMin: minValue
                            });

                        }
                    }
                     else if(this.getAttribute("maskingPattern").toString() =='currency_yen'){
                            if(max===null)
                                jQuery(this).autoNumeric('init',{
                                    aSign: asign, 
                                    dGroup: dgroup,
                                    pSign:psign,
                                    mDec: "0",
                                aNeg:true,
                                aDec: adec,
                                aSep: asep,
                                vMin: minValue
                                });
                            else{
                                jQuery(this).autoNumeric('init',{
                                    aSign: asign, 
                                    dGroup: dgroup,
                                    pSign:psign, 
                                mDec: "0",
                                aDec: adec,
                                aSep: asep,
                                vMin: minValue
                                });
                            }
                        }
                    else
                        jQuery(this).autoNumeric('init',{
                            aSign: " %", 
                            pSign:'s',
                            mDec: decimal,
                            vMin: minValue
                        });
                }

            }
            if(typeofvalue=='Float' && this.getAttribute("maskingPattern") && this.getAttribute("maskingPattern").toString()=='nomasking'){
            jQuery(this).autoNumeric('init',{
                aSep : '',  
                aDec: '.', 
                mDec: decimal,
                vMin: minValue
            });
        }

            //if(this.value!=='')
              //  jQuery(this).autoNumeric('set', this.value)
        });
        initFloatingMessagesForPrimitiveFields('.errorMessageHoverDiv.tableControlDiv');
        initFloatingMessagesForTableCells();
        $('.tableControl.maskedText').each(function(){
            var digitGroup  = parseInt(this.getAttribute("dgroup"));
            var dec = '2';
            if(jQuery(this).attr('typeofvalue')=='Float')
                dec = jQuery(this).attr('Precision');
            jQuery(this).autoNumeric('init',{
                dGroup: digitGroup,
                mDec: dec
            });
        });
        
        $('.openPickerClass').each(function()
        {
            if(this.getAttribute("maskingPattern")!=null && this.getAttribute("maskingPattern")!=undefined && this.getAttribute("maskingPattern")!="" )
            {
                maskfield(this,'input');
            }
        });
        
        attachDatePicker();
        executeLoadEvents('3',controlId);
        clearComponentMap("listview");
        disableListViewControls(controlId);
        listViewLoad(controlId,action);//Bug 80908
       
    }

    function modifyClass(ref){
        document.getElementById(ref.id+"_label").classList.add('input-focus-label');
    }

    function openDatePicker(controlId){
        if($('#'+controlId).data("DateTimePicker") !=undefined){

            $('#'+controlId).data("DateTimePicker").show();
            attachDateRange(document.getElementById(controlId));
        }
        else {
            $('#'+controlId).datetimepicker('show');
            attachDateRange(document.getElementById(controlId));
        }
    }

    function openTableDatePicker(ref){
        //Bug 76652 Start
        if($($(ref).parent().parent().children().first()).data("DateTimePicker") !=undefined){
            $($(ref).parent().parent().children().first()).data("DateTimePicker").show();
            //attachDateRange($($(ref).parent().parent().children().first()));
        }
        else{
            $($(ref).parent().parent().children().first()).datetimepicker('show');
            //attachDateRange($($(ref).parent().parent().children().first()));
        }
        //Bug 76652 End
        //$($(ref).parent().parent().children().first()).datepicker().data('datepicker').show();
    }

    function validateEmail(ref) {
        var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        if(!re.test(ref.value) && ref.value!='')
            {
                var key = ref.getAttribute("dataClass");//Bug 89678 Start
                if(key==="")
                    key = ref.name;
                if(key==="")
                    key = ref.id;
                var validateMapKey=ref.id;
                if(ref.name!=null&&ref.name!=undefined&&ref.name!="")
                    validateMapKey=ref.name;
                if( ref.getAttribute("typeofvalue") && (ref.getAttribute("typeofvalue")==='Text' )){
                    ComponentValidatedMap[validateMapKey]=false;//Bug 83970
                    valueChanged=false;                        		
                }//Bug 89678 End
                jQuery("#"+ref.id+"_patternMsg").text(INVALID_EMAIL);
                toggleErrorTooltip(ref,null,document.getElementById(ref.id+"_patternMsg"),false,1);
                //jQuery("#"+ref.id+"_patternMsg").css("display","block");
                return false;    
            }else
            {
                toggleErrorTooltip(ref,null,document.getElementById(ref.id+"_patternMsg"),false,0);
                //jQuery("#"+ref.id+"_patternMsg").css("display","none");
                return true;
            }

    }

    function tablevalidateEmail(ref) {
        var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        if(!re.test(ref.value) && ref.value!='')
            {
                ref.value="";
                return false;    
            }else
            {
                return true;
            }

    }

    //function validatePhone(ref){
    //   var re = /^\(\d{2}\) \d{10}$/;
    //   if(ref.value!='' && !re.test(ref.value))
    //        {
    //            jQuery("#"+ref.id+"_patternMsg").text(INVALID_PHONE);
    //            jQuery("#"+ref.id+"_patternMsg").css("display","block");
    //            ref.value="";
    //            return false;    
    //        }else
    //        {
    //            jQuery("#"+ref.id+"_patternMsg").css("display","none");
    //            return true;
    //        }
    //}

    function setModifiedData(ref,controlId){
        var rowIndex = $(ref).closest('tr').index();
        var colIndex = parseInt($(ref).closest('td').index())-1;
        var type=jQuery(ref).attr("datatype");
        //Bug 75125
        if(!validateTableCellValue(ref,controlId,colIndex))
        {
            //Bug 88289 
            cancelBubble(event);
            setTimeout(function() { 
                ref.focus();     
            }, 300);
                  
            return;        
        }
        setTableModifiedFlag(controlId);
        var cellValue = ref.value;
        if(ref.className.indexOf("dgroup")!=-1){
           cellValue = jQuery(ref).autoNumeric('get');
        }
        if(ref.getAttribute("maskingPattern")!=null && ref.getAttribute("maskingPattern")!=undefined && ref.getAttribute("maskingPattern")!='' && ref.getAttribute("maskingPattern")!='nomasking' && ref.getAttribute("maskingPattern")!='email'){
    	if(ref.getAttribute("maskingPattern").toString()==='currency_rupees' || ref.getAttribute("maskingPattern").toString()==='currency_dollar' || ref.getAttribute("maskingPattern").toString()==='currency_yen' || ref.getAttribute("maskingPattern").toString()==='currency_euro' || ref.getAttribute("maskingPattern").toString()==='currency_french' || ref.getAttribute("maskingPattern").toString()==='currency_greek' || ref.getAttribute("maskingPattern").toString()==='percentage'|| ref.getAttribute("maskingPattern").toString()==='dgroup2'|| ref.getAttribute("maskingPattern").toString()==='dgroup3'||ref.getAttribute("maskingPattern").toString()==='NZP')
                    cellValue = jQuery(ref).autoNumeric('get');
            else
            {
                 if(ref.getAttribute("controltype") != "date")
                    cellValue = jQuery(ref).cleanVal();
                 else{
                    validateDateValue(ref);
                    cellValue = ref.value;
                }
            }
                    
        }
        $(ref).attr("title",ref.value);
        var requestString="";
        var url = "action.jsp";
        requestString=  "controlId="+controlId +"&rowIndex="+rowIndex+"&colIndex="+colIndex +"&cellData=" + encode_utf8(cellValue) + "&modifyFlag=yes";  
        var contentLoaderRef = new net.ContentLoader(url, listviewResponseHandler, ajaxFormErrorHandler, "POST", requestString, false);
        if(window.onTableCellChange){//Bug 84437 Start
            onTableCellChange(rowIndex,colIndex,ref,controlId);
        }//Bug 84437 End
    }

    function checkDuplicates(ref){
        var duplicates = false;
        if(ref.className.indexOf("noDuplicate")!=-1){
            var contents = {};
            var refclass = ref.className.substring(ref.className.indexOf("noDuplicate"));
            var tableCells = document.getElementsByClassName(refclass);
            for(var i=0;i<tableCells.length;i++){
                var tdContent = tableCells[i].value;
                if (tdContent!="" && contents[tdContent]==true) {
                    duplicates = true;
                    break;
                }
                contents[tdContent] = true;

            }
            if (duplicates){
                showMessage(ref,"Duplicate values not allowed","error");
                //            $('.ui-dialog-titlebar-close').html("X");
                //            document.getElementById("pnlDialog").overflow = "unset !important";
                ref.value = "";

                return true;
            }
            else{
                return false;
            }
        }
    }

    function getTextBox(ref,controlId){
        if(window.formChangeHook)
            formChangeHook(ref);
        var txtboxvalue = ref.textContent;
        //    var txtbox = document.createElement("input");
        //    txtbox.value = txtboxvalue.trim();
        //    ref.innerHTML = "";
        //    txtbox.style.width="100%";
        //    txtbox.style.paddingRight = "0px";
        //    txtbox.style.paddingLeft = "0px";
        //    txtbox.className = "inputStyle form-control1";
        //    txtbox.style.height="100%";
        //        txtboxvalue = this.value;
        //        var txtboxparent = this.parentNode;
        //        txtboxparent.innerHTML = txtboxvalue;
        var isValid=true;
        if(checkDuplicates(ref) || (ref.getAttribute("maskingpattern")!=null && ref.getAttribute("maskingpattern")!=undefined && ref.getAttribute("maskingpattern")=="email" && !tablevalidateEmail(ref)))
        {
            isValid=false;
        }
        if(isValid){
            setModifiedData(ref,controlId); 
        }
    //    return txtbox; 
    }

    function getTextArea(ref,controlId){
        if(window.formChangeHook)
            formChangeHook(ref);
        var txtAreaValue = ref.textContent;
        //    var txtArea = document.createElement("textarea");
        //    txtArea.value = txtAreaValue.trim();
        //    ref.innerHTML = "";
        //    txtArea.style.width="100%";
        //    txtArea.style.paddingRight = "0px";
        //    txtArea.style.paddingLeft = "0px";
        //    txtArea.className = "inputStyle form-control1";
        //    txtArea.style.height="100%";
        //    ref.onblur = function(){
        //        txtAreaValue = this.value;
        //        var txtAreaParent = this.parentNode;
        //        
        //        txtAreaValue.innerHTML = txtAreaValue;
        var isDuplicate = checkDuplicates(ref);
        if(!isDuplicate){
            setModifiedData(ref,controlId); 
        }

    //    };
    //    return txtArea;
    }

    function getLabel(ref,controlId){
        var labelValue = "label";
        //    var label = document.createElement("label");
        //    label.value = labelValue.trim();
        //    ref.innerHTML = "";
        //    label.className = "control-label labelStyle fmarginbottom0";
        //    label.style.height="100%";
        //    label.style.background = "inherit";
        //    label.innerHTML = "label";
        //    ref.onblur = function(){
        //        labelValue = this.value;
        //        var labelParent = this.parentNode;
        //        
        //        labelValue.innerHTML = labelValue;
        setModifiedData(ref,controlId)
    //    }
    //    return label; 
    }

    function getButton(ref,controlId){
        var buttonValue = "button";
        //    var button = document.createElement("button");
        //    button.value = buttonValue.trim();
        //    ref.innerHTML = "";
        //    button.className = "btn btn-sm";
        //    button.innerHTML = "button";
        //    ref.onblur = function(){
        //        buttonValue = this.value;
        //        var buttonParent = this.parentNode;
        //        
        //        buttonValue.innerHTML = buttonValue;
        setModifiedData(ref,controlId)
        //    }
        return button;
    }

    function getCheckbox(ref,controlId){
        if(window.formChangeHook)
            formChangeHook(ref);
        //    var checkboxValue = "checkbox";
        ref.value=ref.checked;
        setModifiedData(ref,controlId);
    }

    function getRadio(ref,controlId){
        if(window.formChangeHook)
            formChangeHook(ref);
        //    var radioValue = "radio";
        ref.value=ref.checked;
        setModifiedData(ref,controlId);
    }

    function getDatePicker(ref,controlId){
        if(window.formChangeHook)
            formChangeHook(ref);
        validateDateValue(ref);
        var txtboxvalue = ref.textContent;
        var isDuplicate = checkDuplicates(ref);
        if(!isDuplicate){
            setModifiedData(ref,controlId); 
        }
    //setModifiedData(ref,controlId);
    //    var datePicker = document.createElement("input");
    //    datePicker.value = txtboxvalue.trim();
    //    ref.innerHTML = "";
    //    datePicker.style.width="100%";
    //    datePicker.style.paddingRight = "0px";
    //    datePicker.style.paddingLeft = "0px";
    //    datePicker.className = "form-control mydatepicker inputStyle fpadding3";
    //    datePicker.style.height="100%";
    //    datePicker.onkeydown = "return false";
    //    datePicker.id = "datepick";
    //    datePicker.type = "text";
    //    datePicker.readOnly='true'


    //    ref.onblur = function(){
    //        ref = this.value;
    //        var radioParent = this.parentNode;
    //        setModifiedData(ref,controlId)
    //    }
    //    ref.onclick = function() {
    //    $(".mydatepicker").datepicker(
    //    {
    //        autoclose: true, 
    //        todayHighlight: true, 
    //        disableTouchKeyboard: true,
    //        clearBtn: true
    //    });
    //    }
    //    return datePicker;
    }

    function getComboBox(ref,controlId){
        if(window.formChangeHook)
            formChangeHook(ref);
        //   var selectedItem = selectCtrl.options[selectCtrl.selectedIndex];
        ref.title = ref.options[ref.selectedIndex].label;
        setModifiedData(ref, controlId);
    }

    function createTextBox(ref,createTextBox,controlId){  
        if( ref.children.length == 0 ){
            if(createTextBox == 1 ) {
                var txtbox = getLabel(ref,controlId);
            }
            if(createTextBox == 2 ) {
                var txtbox = getTextBox(ref,controlId);
            }
            if(createTextBox == 3 ) {
                var txtbox = getTextArea(ref,controlId);
            }
            if(createTextBox == 4 ) {
                var txtbox = getButton(ref,controlId);
            }
            if(createTextBox == 5 ) {
                var txtbox = getCheckbox(ref,controlId);
            }
            if(createTextBox == 6 ) {
                var txtbox = getRadio(ref,controlId);
            }
            if(createTextBox == 7){
                var txtbox = getDatePicker(ref,controlId);
            }
            //        if(createTextBox == 8){
            //            var txtbox = getImage(ref,controlId);
            //        }
            //        if(createTextBox == 9){
            //            var txtbox = getIframe(ref,controlId);
            //        }
            ref.appendChild(txtbox);
            var temp=jQuery(txtbox).val();
            if(createTextBox == 5){
                var label = document.createElement('label')
                label.htmlFor = "id";
                label.style = "font-weight:normal;padding-left:8px;";
                label.appendChild(document.createTextNode('checkbox'));
                ref.appendChild(label);

            }
            if(createTextBox == 6){
                var label = document.createElement('label')
                label.htmlFor = "id";
                label.style = "font-weight:normal;padding-left:8px;";
                label.appendChild(document.createTextNode('radio'));
                ref.appendChild(label);

            }
            jQuery(txtbox).val('');
            jQuery(txtbox).val(temp.trim());
            jQuery(txtbox).focus();


        }
    }

    function deleteTableRow(ref, controlId){
        if(window.tableOperation){
            if(tableOperation(controlId,"DeleteRow") == false)
                return;
        }
        var rowIndex = $(ref).closest('tr').index();
        var url = "action.jsp";
        var requestString=  "controlId="+controlId +"&rowIndex="+rowIndex+"&deleteFlag=yes";  
        var contentLoaderRef = new net.ContentLoader(url, tableRowDeleteResponseHandler, ajaxFormErrorHandler, "POST", requestString, false);
    }


    function selectAllRows(ref,controlId){
        var rowChecks = document.getElementById(controlId).getElementsByClassName("selectRow");
        for(var i=0;i<rowChecks.length;i++){
            if( jQuery(rowChecks[i]).attr("disabled") !== "disabled"){
                rowChecks[i].checked = ref.checked;
                if(!rowChecks[i].checked)
                    jQuery(rowChecks[i]).parents("tr").removeClass("highlightedRow");
                else
                    jQuery(rowChecks[i]).parents("tr").addClass("highlightedRow");
            }
        }
        enableDeleteBtn(ref,controlId);
    }
    function setRowColorInListView(controlId,rowIndex ,colorCode)
    {
        //var rowcheck = document.getElementById("select_"+controlId);
        var table = document.getElementById(controlId);
        if (table != null && table != undefined)
        {
            var row = table.tBodies[0].getElementsByTagName('tr')[rowIndex];
            var setColor = "#"+colorCode+" !important";
            row.style.cssText='background:'+setColor;         
        }
    }
    
    function setRowSelectionInListView(controlId,rowIndices)
    {
        var table = document.getElementById(controlId);
        if (table != null && table != undefined)
        {
            var rows = table.tBodies[0].getElementsByTagName("tr");
            if(rowIndices[0] == -1 ){
                for(var i=0;i<rows.length;i++)
                    rows[i].getElementsByClassName('selectRow')[0].checked = false;
            }
            else{
                for(var i=0;i<rowIndices.length;i++)
                    rows[rowIndices[i]].getElementsByClassName('selectRow')[0].checked = true;
            }
        }
    }
    
    function enableDeleteBtn(ref,controlId){
        var maincheck = document.getElementById("select_"+controlId);
//BUG 75696 starts
        //var allchecked = true;
        var allchecked = false;
        //BUG 75696 : ends
        if(ref!=undefined){
            if(!ref.checked) maincheck.checked = false;
        }
        var selectedRows=[];
        var checks = document.getElementById(controlId).getElementsByClassName('selectRow');
        var deleteFlag = false;
        for(var i=0;i<checks.length;i++){
            if(checks[i].checked){
                deleteFlag = true;
                break;
            }
        }
        for(var i=0;i<checks.length;i++){
            if(checks[i].checked){
                selectedRows.push(i);
            }
        }
        ////BUG 75696 starts
        /*for(var i=0;i<checks.length;i++){
            if(!checks[i].checked){
                allchecked = false;
                break;
            }
        }*/
        var countTicks = 0;
        for(var i=0;i<checks.length;i++){
            if(checks[i].checked){
                countTicks++;
            }
        }
        if(countTicks === checks.length && checks.length >= 1){
            allchecked = true;
        } 
        //BUG 75696 ends
        if(allchecked==true){
            maincheck.checked = true;
        }
        else{
            maincheck.checked = false;
        }

        if(deleteFlag==true){
            document.getElementById("delete_"+controlId).disabled = false;
            if(document.getElementById("delete_"+controlId).childNodes[0].childElementCount > 0)
                document.getElementById("delete_"+controlId).childNodes[0].childNodes[0].setAttribute("src","./resources/images/DeleteIconEnabled.png");
        }
        else{
            document.getElementById("delete_"+controlId).disabled = true;
            if(document.getElementById("delete_"+controlId).childNodes[0].childElementCount > 0)
                document.getElementById("delete_"+controlId).childNodes[0].childNodes[0].setAttribute("src","./resources/images/DeleteIconDisabled.png");
        }
        if(window.selectRowHook){
            selectRowHook(controlId,selectedRows,allchecked);
        }
    }

    function fetchBatch(ref,controlId,action,controlType)
    {
        var isDisabled=document.getElementById(controlId).classList.contains("disabledTable");
        var url = "action.jsp";
        var requestString=  "controlId="+controlId +"&Action="+action+"&pid="+encode_utf8(pid)+"&wid="+encode_utf8(wid)+"&tid="+encode_utf8(tid)+"&fid="+encode_utf8(fid)+"&controlType="+controlType+"&isDisabled="+isDisabled;  
        var contentLoaderRef="";
        var tableDataChangeFlag=false;
        for(var i=0;i<tableDataChangeArray.length;i++){
            var jsonObject=tableDataChangeArray[i];
            if(jsonObject.controlId==controlId){
                tableDataChangeFlag=true;
                tableDataChangeArray.splice(i, 1);
                break;
            }
        }
        if(!tableDataChangeFlag)
        {
            contentLoaderRef = new net.ContentLoader(url, batchHandler, ajaxFormErrorHandler, "POST", requestString, false);        
            return;
        }

        var strMSg = BATCH_MSG;

        var buttons = {
            confirm: {
                label: YES,
                className: 'btn-success'

            },
            cancel: {
                label: NO,
                className: 'btn-danger'

            }
        }

        var callback = function(result){
            if(result == true){
                requestString=requestString+"&SaveCurrentBatch=Y";
                contentLoaderRef = new net.ContentLoader(url, saveBatchHandler, ajaxFormErrorHandler, "POST", requestString, false);
               // jQuery(this).dialog("close");
            }
            else if(isBootboxCloseClicked==false && result == false){
                 contentLoaderRef = new net.ContentLoader(url, batchHandler, ajaxFormErrorHandler, "POST", requestString, false);
  
                // jQuery(this).dialog("close");
            }
            if(isBootboxCloseClicked==true) isBootboxCloseClicked=false;
        }
    //        
    //    var buttons = 
    //    {
    //        Yes: function()
    //        {                        
    //            requestString=requestString+"&SaveCurrentBatch=Y";
    //            var contentLoaderRef = new net.ContentLoader(url, batchHandler, ajaxFormErrorHandler, "POST", requestString, false);        
    //            jQuery(this).dialog("close");
    //        },
    //        No: function() 
    //        { 
    //            var contentLoaderRef = new net.ContentLoader(url, batchHandler, ajaxFormErrorHandler, "POST", requestString, false);        
    //            jQuery(this).dialog("close" );
    //        }
    //    };

         showConfirmDialog(strMSg,buttons,callback); 

        // tableDataChangeFlag=false;
    }

    function showConfirmDialog(msg,btns,callback,isClose){
        msg="<div class='typeInfo' style='color:#0072c6;margin-bottom: 10px;'><span style='font-size:35px;padding-right: 10px;' class='glyphicon glyphicon-info-sign'></span><span style='font-size:16px;'>Info</span></div>"+msg;
        if( isClose == undefined ){
            isClose = true;
        }
        bootbox.confirm({
        message: msg,
        buttons: btns,
        closeButton: isClose, 
        callback: callback,
        size: "medium"
    });
     $('.bootbox-close-button').on("click",function(){
       isBootboxCloseClicked=true; 
    });
    }




    function saveBatchHandler()
    {
      //document.getElementById(this.req.getResponseHeader("tableControlId")).tBodies[0].remove();  
      var tableId=getQueryVariable(this.params, "controlId");
      
      if(!isNaN(this.req.responseText.trim())){
          var code = parseInt(this.req.responseText.trim());
          if( code !== 0){
               showMessage("", "Error in Saving Data.", "error");
               return;
          }
      }
      $("#"+tableId+" tbody").empty();
      $("#"+tableId+ " tbody").append(this.req.responseText);
      $("#"+tableId).floatThead('reflow');
      checkTableHeight(tableId);
      var preEnabled=this.req.getResponseHeader("preEnabled");
      var nextEnabled=this.req.getResponseHeader("nextEnabled");
      var batchCounter=this.req.getResponseHeader("batchCounter");
      var sortOrder=this.req.getResponseHeader("SortOrder");
      if(preEnabled=="true"){
        $("#pre_"+tableId).prop("disabled", false);
        document.getElementById("preimage_"+tableId).src = "./resources/images/PaginationLeftEnabled.png";
      }
      else{
        $("#pre_"+tableId).prop("disabled", true);
        document.getElementById("preimage_"+tableId).src = "./resources/images/PaginationLeftDisabled.png";
      }
      if(nextEnabled=="true"){
        $("#next_"+tableId).prop("disabled", false);
        document.getElementById("nextimage_"+tableId).src = "./resources/images/PaginationRightEnabled.png";
      }
      else{
        $("#next_"+tableId).prop("disabled", true);
         document.getElementById("nextimage_"+tableId).src = "./resources/images/PaginationRightDisabled.png";
        }
        
      applyFormattingGrid();
      var totalValueElements=document.getElementById('totallabel_'+tableId).innerHTML.split(",!,");
      for(var i=0;i<totalValueElements.length;i++){
        if(totalValueElements[i]!=''){
         $(document.getElementsByClassName(totalValueElements[i].replace(/&lt;/g, '<').replace(/&gt;/g, '>').replace(/&quot;/g, '"').replace(/&amp;/g, '&'))).each(function() {
        var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
            if((this.getAttribute("maskingpattern")!="nomasking" && this.getAttribute("maskingpattern")!="")
            || (typeofvalue=='Float' && this.getAttribute("maskingpattern")=="nomasking"))
            {
            maskfield(this,'label');
            }
        });
        }
        showTotal('',totalValueElements[i]);
        reshuffleIndices(tableId,sortOrder,batchCounter);
     }
    }
     function batchHandler()
    {
      //document.getElementById(this.req.getResponseHeader("tableControlId")).tBodies[0].remove();  
      var tableId=getQueryVariable(this.params, "controlId");      
      
      $("#"+tableId+" tbody").empty();
      $("#"+tableId+ " tbody").append(this.req.responseText);
      $("#"+tableId).floatThead('reflow');
      checkTableHeight(tableId);
      var preEnabled=this.req.getResponseHeader("preEnabled");
      var nextEnabled=this.req.getResponseHeader("nextEnabled");
      var batchCounter=this.req.getResponseHeader("batchCounter");
      var sortOrder=this.req.getResponseHeader("SortOrder");
      if(preEnabled=="true"){
        $("#pre_"+tableId).prop("disabled", false);
        document.getElementById("preimage_"+tableId).src = "./resources/images/PaginationLeftEnabled.png";
      }
      else{
        $("#pre_"+tableId).prop("disabled", true);
        document.getElementById("preimage_"+tableId).src = "./resources/images/PaginationLeftDisabled.png";
      }
      if(nextEnabled=="true"){
        $("#next_"+tableId).prop("disabled", false);
        document.getElementById("nextimage_"+tableId).src = "./resources/images/PaginationRightEnabled.png";
      }
      else{
        $("#next_"+tableId).prop("disabled", true);
         document.getElementById("nextimage_"+tableId).src = "./resources/images/PaginationRightDisabled.png";
        }
      applyFormattingGrid();
      var totalValueElements=document.getElementById('totallabel_'+tableId).innerHTML.split(",!,");
      for(var i=0;i<totalValueElements.length;i++){
        if(totalValueElements[i]!=''){
         $(document.getElementsByClassName(totalValueElements[i].replace(/&lt;/g, '<').replace(/&gt;/g, '>').replace(/&quot;/g, '"').replace(/&amp;/g, '&'))).each(function() {
        var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
            if((this.getAttribute("maskingpattern")!="nomasking" && this.getAttribute("maskingpattern")!="")
            || (typeofvalue=='Float' && this.getAttribute("maskingpattern")=="nomasking"))
            {
            maskfield(this,'label');
            }
        });
        }
        showTotal('',totalValueElements[i]);
        reshuffleIndices(tableId,sortOrder,batchCounter);
     }


     var dgroupColumns = this.req.getResponseHeader("dgroupColumns");
     if(dgroupColumns!=null && dgroupColumns!=undefined){
     for(var i=0;i<dgroupColumns.split(",").length;i++){
        var className = "dgroup_"+tableId+"_"+dgroupColumns.split(",")[i];
        //var dgroupCells = document.getElementsByClassName("dgroup_"+controlId+"_"+dgroupColumns.split(",")[i]);

        $('.'+className).each(function() {
            var digitGroup = parseInt(dgroupColumns.split(",")[i].split("_")[1]);
            jQuery(this).autoNumeric('init',{
                dGroup: digitGroup,
                mDec: '0'
            }); 
        });
     }
     }
     try{
            $($('#'+tableId).get(0).parentNode.parentNode).find('th.tableStyle').removeAttr("SortOrder");    
            $($('#'+tableId).get(0).parentNode.parentNode).find('th.tableStyle').css({
                "background-repeat":"",
                "background-position":"",
                "background-image":""
            });
        }
        catch(ex){}
        if(window.nextPreviousBatchHook)
        {
            nextPreviousBatchHook(tableId);
        }
    }
    function deleteTableRows(ref, controlId, deletingRowIndices){
        if(window.tableOperation){
            if(tableOperation(controlId,"DeleteRow") == false)
                return;
        }
        var rowIndices = "";
        var deleterow = "";
        var rowChecks = document.getElementById(controlId).getElementsByClassName("selectRow");
        if(deletingRowIndices!=null && deletingRowIndices!=undefined){
            for(var i=0;i<deletingRowIndices.length;i++){
                    rowIndices += deletingRowIndices[i]+",";
            }
        }
        else{
            for(var i=0;i<rowChecks.length;i++){
                if(rowChecks[i].checked){
                    rowIndices += i+",";
                }
            }
        }
        for(var i=rowIndices.split(",").length-1;i>=0;i--){
            var rowIndex = rowIndices.split(",")[i];
            if(rowIndex!=""){
                /*if(document.getElementById(controlId).tBodies[0].children[rowIndex].className=='rowinhtml')
                    deleterow+="y,"
                else*/
                deleterow+="y,";
            }
        }
        document.getElementById("select_"+controlId).checked = false;
        var url = "action.jsp";
        //    var requestString=  "controlId="+controlId +"&rowIndex="+rowIndex+"&deleteFlag=yes";  
        var requestString=  "controlId="+controlId +"&rowIndices="+rowIndices+"&deleteFlag=yes&deleterow="+deleterow;  
        var contentLoaderRef = new net.ContentLoader(url, tableRowsDeleteResponseHandler, ajaxFormErrorHandler, "POST", requestString, false);
        calculateTotalForGrid(controlId);//Bug 85784
        setTableModifiedFlag(controlId);
    }

    function setTableModifiedFlag(controlId)
    {
        var idfound=false;
        for(var i=0;i<tableDataChangeArray.length;i++)
        {
            if(controlId==tableDataChangeArray[i].controlId)
            {
               idfound=true;
               break;
            }           
        }
        if(!idfound)
        {
            var jsonObject={};
            jsonObject.controlId=controlId;
            jsonObject.value=true;
            tableDataChangeArray.push(jsonObject);
        }
    }

    function tableRowsDeleteResponseHandler(){
        var tableControlId=getQueryVariable(this.params, "controlId");
        jQuery('#delete_'+tableControlId).blur(); //Bug 90080 Start
        jQuery('#delete_'+tableControlId).attr('disable',true); //Bug 90080 End
        jQuery('#delete_'+tableControlId).removeClass("hightlightAddDeleteRow")
        var rowIndices = getQueryVariable(this.params, "rowIndices");
        var batchCounter=this.req.getResponseHeader("batchCounter");  
        deleteRowsFromGridAction(tableControlId,rowIndices,this.req.getResponseHeader("altrowcolor"),batchCounter);//Bug 85784
    }

    function reshuffleIndices(tableId,sortOrder,batchCounter){
        try{
            var x;
            if(batchCounter==undefined ||batchCounter!=""){
                x=batchCounter;
            }
            var table = document.getElementById(tableId);
            var children = table.parentNode.parentNode.childNodes;
            var theads = children[0].getElementsByTagName("th");
            var autoIncrementColumnsIndices = [];
            var rows = document.getElementById(tableId).tBodies[0].getElementsByTagName("tr");
            for(var i=1;i<theads.length;i++){
                if(theads[i].classList.contains("autoIncrementLabel")){
                    autoIncrementColumnsIndices[i]=i;
                }
            }
            if(sortOrder==undefined || (sortOrder==""||sortOrder=="A" || sortOrder=="N")){
                for(var i=1;i<=getGridRowCount(tableId);i++){
                    for(var j=1;j<=rows[i-1].getElementsByTagName("td").length;j++){
                        if(autoIncrementColumnsIndices[j]!=null && autoIncrementColumnsIndices[j]!=undefined)
                            if(batchCounter!=undefined && batchCounter!=""){
                                rows[i-1].getElementsByTagName("td")[autoIncrementColumnsIndices[j]].getElementsByClassName("control-class")[0].innerHTML = x;
                                x++;
                            }
                        else{
                            rows[i-1].getElementsByTagName("td")[autoIncrementColumnsIndices[j]].getElementsByClassName("control-class")[0].innerHTML = i;
                        }
                    }
                }
            }
            else{
                for(var i=1;i<=getGridRowCount(tableId);i++){
                    for(var j=1;j<=rows[getGridRowCount(tableId)-i].getElementsByTagName("td").length;j++){
                        if(autoIncrementColumnsIndices[j]!=null && autoIncrementColumnsIndices[j]!=undefined)
                            if(batchCounter!=undefined&& batchCounter!=""){
                            rows[getGridRowCount(tableId)-i].getElementsByTagName("td")[autoIncrementColumnsIndices[j]].getElementsByClassName("control-class")[0].innerHTML = x;
                            x++;
                            }
                        else{
                            rows[getGridRowCount(tableId)-i].getElementsByTagName("td")[autoIncrementColumnsIndices[j]].getElementsByClassName("control-class")[0].innerHTML = i;
                        }
                    }
                } 
            }
        }
        catch(ex){}
    }

    function highlightRow(ref, controlId,event){
        var rowIndex = $(ref).closest('tr').index();
        var url = "action.jsp";
        var requestString=  "controlId="+controlId +"&rowIndex="+rowIndex+"&deleteFlag=no";  
        if(event=='hover'){
            //        ref.style.backgroundColor='#ff7f7f';
            var contentLoaderRef = new net.ContentLoader(url, tableRowHighlight, ajaxFormErrorHandler, "POST", requestString, false);
        }
        else{
            //        ref.style.backgroundColor='#fff';
            var contentLoaderRef = new net.ContentLoader(url, tableRowHighlightRemove, ajaxFormErrorHandler, "POST", requestString, false);
        }
    }
    function tableRowHighlight(){
        var tableControlId=getQueryVariable(this.params, "controlId");
        var rowIndex=getQueryVariable(this.params, "rowIndex");
        document.getElementById(tableControlId).tBodies[0].children[rowIndex].style.border="2px solid #ff7f7f ";
    }
    function tableRowHighlightRemove(){
        var tableControlId=getQueryVariable(this.params, "controlId");
        var rowIndex=getQueryVariable(this.params, "rowIndex");
        if(document.getElementById(tableControlId).tBodies[0].children[rowIndex])
            document.getElementById(tableControlId).tBodies[0].children[rowIndex].style.border="1px #ffffff";
    }
    function tableRowDeleteResponseHandler(){
        var tableControlId=getQueryVariable(this.params, "controlId");
        var rowIndex=getQueryVariable(this.params, "rowIndex");
        if(document.getElementById(tableControlId).tBodies[0].children[rowIndex].className=='rowinhtml')
            document.getElementById(tableControlId).tBodies[0].deleteRow(rowIndex);
        else
            document.getElementById(tableControlId).tBodies[0].children[rowIndex].style.display="none";
    }

    function toggleSection(ref){
        jQuery(ref).siblings().toggle(450,function(){
            jQuery(ref).find("polyline").attr("transform",jQuery(ref).siblings().is(":visible") ? "translate(8.000000, 8.000000) scale(-1, -1) translate(-8.000000, -8.000000)" : "");
            if((jQuery(ref).siblings().is(":visible")))
            {
                try{
                //ref.parentNode.scrollIntoView(false);     //Bug 83346
                }
                catch(ex){}

            }
            var sectionState;
            if(jQuery(ref).attr("state") == "collapsed")
            {
               sectionState="expanded";
               jQuery(ref).attr("state","expanded");  
            }
            else
            {
                sectionState="collapsed";
                jQuery(ref).attr("state","collapsed");            
            }  
            if( jQuery(ref).attr("painted")!= undefined){   //Bug 85630,85657
            if(window.onChangeSectionState)
                window.onChangeSectionState(jQuery(ref).parent().attr("id"),sectionState);
            }
            $("#"+jQuery(ref).parent().attr("id")+" .iform-table").floatThead('reflow');
        }
        );
        var url = "action_API.jsp";
        requestString = "frameId="+jQuery(ref).parent().attr("id")+"&frameState="+jQuery(ref).attr("state")+"&pid="+encode_utf8(pid)+"&wid="+encode_utf8(wid)+"&tid="+encode_utf8(tid)+"&fid="+encode_utf8(fid);
        if( jQuery(ref).attr("painted")== undefined)
            new net.ContentLoader(url, frameResponseHandler, frameErrorHandler, "POST", requestString, false);
    }
    function frameResponseHandler(){
        $(".iform-table").floatThead('reflow');
        var framehtml = this.req.responseText.trim();
        var frameid = getQueryVariable(this.params, "frameId");
        //   HandleProgressBar(data);
        var parentNode=document.getElementById(frameid).parentNode;
        parentNode.innerHTML="";
        jQuery(parentNode).html(framehtml);    
        doInit();
        var jsElm = document.createElement("script");
        var jsSrc="resources/scripts/"+processName+"/"+formName+"/"+frameid +".js";
        jsElm.type = "application/javascript";
        jsElm.src = jsSrc;
        if(!isScriptAlreadyIncluded(jsSrc))//Bug 84916
            document.getElementsByTagName("head")[0].appendChild(jsElm);
        executeLoadEvents('4',frameid);
        if(window.onLoadSection)
            window.onLoadSection(frameid);
         //Bug 85630
        var sectionState = "";
        if(document.getElementById(frameid)!=null && document.getElementById(frameid).childNodes[0]!=null){
            sectionState = document.getElementById(frameid).childNodes[0].getAttribute("state");
        }
         if(window.onChangeSectionState)
                window.onChangeSectionState(frameid,sectionState);
    }
    
    function isScriptAlreadyIncluded(src){//Bug 84916 Start
        var scripts = document.getElementsByTagName("script");
        for(var i = 0; i < scripts.length; i++) 
        if(scripts[i].getAttribute('src') == src) return true;
        return false;
    }//Bug 84916 End

    function frameErrorHandler(){}

    $(document).ready(function(){
        var loaded = 0;

        if($('.embed-responsive-item').length>1){
            document.getElementById("fade").style.display="block";
            CreateIndicator("application");
        }
        $('.embed-responsive-item').on( 'load',function (){

            if($('.embed-responsive-item').length-1==++loaded){
                document.getElementById("fade").style.display="none";
                RemoveIndicator("application");
            }
        });
        setTimeout(function() { 
            if($('#application').length>0){
                document.getElementById("fade").style.display="none";
                RemoveIndicator("application");
            }
        }, 100);
    });

    function setTabStyle(tabID,index,attributeName, attributeValue,showHideAddDelete)
    {
        var tab = document.getElementById(tabID);
        if (tab != null && tab != undefined)
        {
            var tabli = tab.getElementsByTagName("li")[index];
            var sheet = tab.getElementsByClassName("tab-pane fade")[index];
            var controls = sheet.getElementsByClassName("control-class");
            var tableControls = sheet.getElementsByClassName("iform-table");
            var frameControls = sheet.getElementsByClassName("FrameControl");
            //    console.log(tabli);
            //    console.log(sheetconsole.log);
            //    console.log(controls);

            //    var tabitem = document.getElementById(tabID+"_"+index);
            //    var sheetID = tabID+"_sheet"+index;

            if (attributeName.toLowerCase() == "backcolor") {
                jQuery("#" + sheet.id + " .control-class").css("background-color", attributeValue);
            } else if (attributeName.toLowerCase() == "fontcolor") {
                jQuery("#" + sheet.id + " .control-class").css("color", attributeValue);
            } else if (attributeName.toLowerCase() == "visible")
            {
                if (attributeValue.toLowerCase() == "true") {
                    tabli.style.display = "inline";
                    sheet.style.display = "";
                    //jQuery("#"+sheetID).css("display","");
                } else if (attributeValue.toLowerCase() == "false") {
                    tabli.style.display = "none";
                    sheet.style.display = "none";
                    //jQuery("#"+sheetID).css("display","none");
                }
                jQuery("#"+tabID +" .tabtheme4.iformTabUL").each(function(){
                    $(this).scrollingTabs('refresh');
                });
            
            } else if (attributeName.toLowerCase() == "disable")
            {
                if (attributeValue.toLowerCase() == "true") {
                    for (var i = 0; i < controls.length; i++) {
                        //controls[i].disabled = "true";
                        if(!controls[i].classList.contains("listviewlabel"))
                          setStyle(controls[i].id, "disable", "true");
                    }
                    for (var j = 0; j < tableControls.length; j++) 
                        setStyle(tableControls[j].id, "disable", "true");
                    for (var k = 0; k < frameControls.length; k++) 
                        setStyle(frameControls[k].id, "disable", "true");
                    //$("#"+sheetID+' .control-class').attr('disabled', true);
                }else if (attributeValue.toLowerCase() == "false") {
                    for (var i = 0; i < controls.length; i++) {
                        //controls[i].removeAttribute("disabled");
                        if(!controls[i].classList.contains("listviewlabel"))
                        setStyle(controls[i].id, "disable", "false",showHideAddDelete);
                    }
                    for (var j = 0; j < tableControls.length; j++) 
                        setStyle(tableControls[j].id, "disable", "false");
                    for (var k = 0; k < frameControls.length; k++) 
                        setStyle(frameControls[k].id, "disable", "false",showHideAddDelete);
                    //$("#"+sheetID+' .control-class').attr('disabled', false);
                }
            } else if (attributeName.toLowerCase() == "readonly")
            {
                if (attributeValue.toLowerCase() == "true") {
                    for (var i = 0; i < controls.length; i++) {
                        //controls[i].readOnly = "true";
                        setStyle(controls[i].id, "readonly", "true");
                    }
                } else if (attributeValue.toLowerCase() == "false") {
                    for (var i = 0; i < controls.length; i++) {
                        //controls[i].removeAttribute("readOnly   ");
                        setStyle(controls[i].id, "readonly", "false");
                    }
                }
            } else if (attributeName.toLowerCase() == "fontfamily")
                jQuery("#" + sheet.id + " .control-class").css("font-family", attributeValue);
            else if (attributeName.toLowerCase() == "fontweight")
                jQuery("#" + sheet.id + " .control-class").css("font-weight", attributeValue);
            else if (attributeName.toLowerCase() == "fontstyle")
                jQuery("#" + sheet.id + " .control-class").css("font-style", attributeValue);
            else if (attributeName.toLowerCase() == "fontsize")
                jQuery("#" + sheet.id + " .control-class").css("font-size", attributeValue);
        }
    }

    //function setTabStyle(tabID,index,attributeName, attributeValue){
    //    var tab = document.getElementById(tabID);
    //    var tabli = tab.getElementsByTagName("li")[index];
    //    var sheet = tab.getElementsByClassName("tab-pane fade")[index];
    //
    //    if( attributeName.toLowerCase() == "backcolor"){
    //        jQuery("#"+sheetID+" .control-class").css("background-color",attributeValue);
    //    }
    //    else if( attributeName.toLowerCase() == "fontcolor"){
    //        jQuery("#"+sheetID+" .control-class").css("color",attributeValue);
    //    }
    //    else if( attributeName.toLowerCase() == "visible")
    //    {
    //        if( attributeValue.toLowerCase() == "true"){
    //             tabli.style.display = "inline";
    //             sheet.style.display = "";
    //        }
    //        else if( attributeValue.toLowerCase() == "false"){
    //            tabli.style.display = "none";
    //            sheet.style.display = "none";
    //        }
    //    }
    //     else if( attributeName.toLowerCase() == "disable")
    //    {
    //        if( attributeValue.toLowerCase() == "true"){
    //            for(var i=0;i<controls.length;i++){
    //                controls[i].disabled = "true";
    //            }
    //        }
    //        else if( attributeValue.toLowerCase() == "false"){
    //            for(var i=0;i<controls.length;i++){
    //                controls[i].removeAttribute("disabled")
    //            }
    //        }
    //    }
    //    else if( attributeName.toLowerCase() == "readonly")
    //    {
    //        if( attributeValue.toLowerCase() == "true"){
    //            for(var i=0;i<controls.length;i++){
    //                controls[i].readOnly = "true";
    //            }
    //        }
    //        else if( attributeValue.toLowerCase() == "false"){
    //            for(var i=0;i<controls.length;i++){
    //                controls[i].removeAttribute("readOnly")
    //            }
    //        }
    //    }
    //    
    //    else if( attributeName.toLowerCase() == "fontfamily")
    //        jQuery("#"+sheetID+" .control-class").css("font-family",attributeValue);
    //    else if( attributeName.toLowerCase() == "fontweight")
    //        jQuery("#"+sheetID+" .control-class").css("font-weight",attributeValue);
    //    else if( attributeName.toLowerCase() == "fontstyle")
    //        jQuery("#"+sheetID+" .control-class").css("font-style",attributeValue);
    //    else if( attributeName.toLowerCase() == "fontsize")
    //        jQuery("#"+sheetID+" .control-class").css("font-size",attributeValue);
    //}

    //Custom function
    /*function tableOperation(tableId,operationType){
        if( tableId == "table1"){
            if( operationType == "AddRow"){
                if(getValue("textbox1")=="aman"){
                    setFocus("textarea2")
                    return false;
                }
            }
             if( operationType == "DeleteRow"){
                if(getValue("textarea1")=="22"){
                    setCellDisabled(tableId,"2",1,"true")
                    return false;
                }
            }
        }
    }
    */

    function getWorkItemData(property){
        if(property.toLowerCase()=="processinstanceid"){
            return pid;
        }
        else if(property.toLowerCase() == "workitemid"){
            return wid;
        }

        else if(property.toLowerCase() == "taskid"){
            return tid;
        }

        else if(property.toLowerCase() == "activityname"){
            return activityName;
        }

        else if(property.toLowerCase() == "appserverip"){
            return appServerIp;
        }

        else if(property.toLowerCase() == "appserverport"){
            return appServerPort;
        }

        else if(property.toLowerCase() == "username"){
            return userName;
        }

        else if(property.toLowerCase() == "sessionid"){
            return sessionId;
        }
        else if(property.toLowerCase() == "cabinetname"){
            return cabinetName;
        }

        else if(property.toLowerCase() == "processname"){
            return processName;
        }

        else if(property.toLowerCase() == "subtaskid"){
            return subTaskId;
        }

        else if(property.toLowerCase() == "taskname"){
            return taskName;
        }
        else if(property.toLowerCase() == "assignedto"){
            return assignedTo;
        }

        else if(property.toLowerCase() == "prioritylevel"){
            return priorityLevel;
        }
        
        else if(property.toLowerCase() == "lockedbyname"){
            return lockedByName;
        }
        
        else if(property.toLowerCase() == "processedby"){
            return processedBy;
        }
        
        else if(property.toLowerCase() == "introductiondatetime"){
            return introductionDateTime;
        }
        
        else if(property.toLowerCase() == "introducedat"){
            return introducedAt;
        }
        
        else if(property.toLowerCase() == "queueid"){
            return queueId;
        }
        
        else if(property.toLowerCase() == "lockstatus"){
            return lockStatus;
        }
        
        else if(property.toLowerCase() == "useremailid"){
            return userEmailId;
        }
        
        else if(property.toLowerCase() == "userpersonalname"){
            return userPersonalName;
        }
        
        else if(property.toLowerCase() == "userfamilyname"){
            return userFamilyName;
        }
        
        else if(property.toLowerCase() == "userindex"){
            return userIndex;
        }

    }

    function setRowsDisabled(tableId,rowIndices,disableSelectCheckbox)
    {
        disableSelectCheckbox=typeof disableSelectCheckbox =="undefined"?false:disableSelectCheckbox;
        var table = document.getElementById(tableId);
        if (table != null && table != undefined)
        {
            var rows = table.tBodies[0].getElementsByTagName('tr');
            for (var i = 0; i < rowIndices.length; i++) 
            {
                var controls = rows[rowIndices[i] ].getElementsByClassName("control-class");
                for (var j = 0; j < controls.length; j++) 
                {
                    controls[j].disabled = "true";
                    var cellRef = rows[rowIndices[i] ].getElementsByTagName("td")[j + 1];
                    $(cellRef).prop('onclick', null).off('click');

                }
                if(disableSelectCheckbox){
                    var selectcheckbox = rows[rowIndices[i] ].getElementsByClassName("selectRow");
                    if(selectcheckbox.length>0){
                        selectcheckbox[0].disabled=true;
                    }
                }
            }
        }
    }

    function setRowStyle(tableId,rowIndex,attributeName,attributeValue)
    {
        var table = document.getElementById(tableId);
        if (table != null && table != undefined)
        {
            var rows = table.tBodies[0].getElementsByTagName('tr');
            if (attributeName.toLowerCase() == "visible") {
                if (attributeValue.toLowerCase() == "true") {
                    rows[rowIndex].style.display = "";
                } else if (attributeValue.toLowerCase() == "false" && rows != null && rows[rowIndex] != null) {
                    rows[rowIndex].style.display = "none";
                }
            }else if (attributeName.toLowerCase() == "disable") {
                var controls = rows[rowIndex].getElementsByClassName("control-class");
                for (var i = 0; i < controls.length; i++) {
                    if (attributeValue.toLowerCase() == "true") {
                        controls[i].disabled = "true";
                    } else if (attributeValue.toLowerCase() == "false") {
                        controls[i].removeAttribute("disabled");
                    }
                }
            }
        }
        var totalValueElements=document.getElementById('totallabel_'+tableId).innerHTML.split(",!,");
            for(var i=0;i<totalValueElements.length;i++){
             //var controlRef = document.getElementById('label'+'_'+controlId+'_'+maskedLabels.split(",")[i]);
             if(totalValueElements[i]!=''){
             $(document.getElementsByClassName(totalValueElements[i].replace(/&lt;/g, '<').replace(/&gt;/g, '>').replace(/&quot;/g, '"').replace(/&amp;/g, '&'))).each(function() {
                 var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
            if((this.getAttribute("maskingpattern")!="nomasking" && this.getAttribute("maskingpattern")!="")
            || (typeofvalue=='Float' && this.getAttribute("maskingpattern")=="nomasking"))
            {
                    maskfield(this,'label');
            }
         });
    }
                showTotal('',totalValueElements[i]);
            }
    }
    //    
    //function showRowInTable(tableId,rowIndex,flag){
    //    var table = document.getElementById(tableId);
    //    var rows = table.getElementsByClassName('rowinhtml');
    //    if(flag=="false"){
    //        rows[rowIndex].style.display = "none";
    //    }
    //    else if(flag=="true"){
    //        rows[rowIndex].style.display = "";
    //    }
    //}

    //function getValueFromTable(tableId)
    //{
    //    var table = document.getElementById(tableId);
    //    //var tablerows = table.getElementsByClassName("rowinhtml");
    //    if (table != null && table != undefined)
    //    {
    //        var tablerows = table.getElementsByTagName("tr");
    //        var theadrow = table.parentNode.parentNode.childNodes[0].getElementsByTagName("th");
    //        //var doc = document.implementation.createDocument(null,"Table");
    //        //var rows = document.createElement("Rows");
    //        //var row = document.createElement("Row");
    //
    //        var XMLString = "";
    //        XMLString += "<Rows>\n<Row>\n";
    //        for (var i = 1; i < theadrow.length; i++) {
    //            var header = theadrow[i].textContent;
    //            //var headerNode = document.createElement("Header");
    //            //headerNode.appendChild(document.createTextNode(header));
    //            // row.appendChild(headerNode);
    //            //rows.appendChild(row);
    //            XMLString += "<header>" + header + "</header>\n";
    //        }
    //        //doc.documentElement.appendChild(rows);
    //        XMLString += "</Row>\n";
    //
    //        for (i = 1; i < tablerows.length; i++) {
    //            var row = tablerows[i];
    //            var controls = row.getElementsByClassName("control-class");
    //            XMLString += "<Row>\n"
    //            //row = document.createElement("Row");
    //            for (var j = 1; j <= controls.length; j++) {
    //                var control = controls[j - 1];
    //                var value = "";
    //                if (control.type == 'text' || control.type == 'select-one' || control.type == 'ComboBox' || control.type == 'textarea') {
    //                    value = control.value;
    //
    //                } else if (control.tagName == 'LABEL') {
    //                    value = control.innerHTML;
    //                } else if (control.type == "radio" || control.id.indexOf('radio') != -1)
    //                {
    //                    value = control.checked;
    //                } else if (control.type == 'checkbox')
    //                {
    //                    value = control.checked;
    //                }
    //                // var headName = theadrow[j].textContent.replaceAll(" ","");
    //                //  var colNode = document.createElement(headName);
    //                //  colNode.appendChild(document.createTextNode(value));
    //                //  row.appendChild(colNode);
    //                //   rows.appendChild(row);
    //                //  doc.documentElement.appendChild(rows);
    //
    //                XMLString += "<" + theadrow[j].textContent + ">" + value + "</" + theadrow[j].textContent + ">\n";
    //            }
    //
    //            XMLString += "</Row>\n"
    //        }
    //        XMLString += "</Rows>";
    //        //console.log(doc);
    //        return XMLString;
    //    }
    //}

    function getValueFromTable(tableId){
        if(tableId!=null && tableId!=undefined){

            var table = document.getElementById(tableId);
            var rows = table.tBodies[0].getElementsByTagName("tr");
            if(rows.length>=1){
                var XMLString = "";
                XMLString += "<ListItems>\n";
                var numOfRows = rows.length;
                var numOfColumns = rows[0].getElementsByClassName("control-class").length;
                for(var i=0;i<numOfRows;i++){
                    XMLString += "<ListItem>\n";
                    for(var j=0;j<numOfColumns;j++){
                        XMLString += "<SubItem>";
                        var cellValue = getValueFromTableCell(tableId,i,j);
                        cellValue =cellValue.toString().replace(/&/g,"&amp;").replace(/>/g, "&gt;").replace(/</g, "&lt;");
                        XMLString += cellValue;
                        XMLString += "</SubItem>\n";
                    }
                    XMLString += "</ListItem>\n";
                }
                XMLString += "</ListItems>\n";
                return XMLString;
            }
        }
    }

    function clearValue(controlId,sync)
    {
        var control = document.getElementById(controlId);
        if (control == null)
            control = document.getElementsByName(controlId)[0];
        if (control != null && control != undefined)
        {
            var nodes = [];
            nodes.push(control);
            var children = control.getElementsByClassName("control-class");
            for (var i = 0; i < children.length; i++) {
                nodes.push(children[i]);
            }
            // console.log(nodes);
            for (var i = 0; i < nodes.length; i++) {
                jsonObj = {};
                if (nodes[i].type == 'text' || nodes[i].type == 'select-one' || nodes[i].type == 'ComboBox' || nodes[i].type == 'textarea') {
                    jsonObj[controlId] = "";
                } else if (nodes[i].tagName == 'LABEL') {
                    //nodes[i].innerHTML="";
                    jsonObj[controlId] = "";
                } else if (nodes[i].type == "radio" || nodes[i].id.indexOf('radio') != -1)
                {
                    //nodes[i].checked = false;
                    jsonObj[controlId] = "false";
                } else if (nodes[i].type == 'checkbox')
                {
                    //nodes[i].checked = false;
                    jsonObj[controlId] = "false";
                }
                var patternRef = document.getElementById(controlId+"_patternMsg");
                var msgRef = document.getElementById(controlId+"_msg");
                if(control.getAttribute("required"))
                    toggleErrorTooltip(control,null,patternRef,true,0);
                else
                    toggleErrorTooltip(control,null,patternRef,false,0);      
                setValues(jsonObj, sync);
            }
        }
    }

    function setValues(jsonObj,sync){
        var url = "action_API.jsp";

        var attrTypes ={};
        var customJSON = {};
        for(key in jsonObj){           
            var control = document.getElementById(key);
            if(control == null || control.classList.contains("iform-radio")){
                control = document.getElementsByName(key)[0];
            }
            var attrName = control.getAttribute("dataClass");
            if(attrName=="")
                attrName = control.name;
            if(attrName=="")
                attrName = control.id;
            if(control.type=='select-multiple'){
            setValue(key,jsonObj[key]);
            var lbJSON = {};
            for(var i=0;i<jsonObj[key].length;i++){
                lbJSON[i] = jsonObj[key][i];
            }
            customJSON[attrName] = lbJSON;
            attrTypes[attrName] = control.getAttribute("combotype");
        }
        else{
            jsonObj[key]=setValue(key,jsonObj[key]);//Bug 81232
            customJSON[attrName] = jsonObj[key];
            attrTypes[attrName] = control.getAttribute("datatype");
        }
        }
        var jsonString = JSON.stringify(customJSON);
        var attrTypesJSONString =  JSON.stringify(attrTypes);
        requestString = "setValuesFlag=yes&jsonString="+encode_utf8(jsonString)+"&attrTypesJSONString="+encode_utf8(attrTypesJSONString)+"&pid="+encode_utf8(pid)+"&wid="+encode_utf8(wid)+"&tid="+encode_utf8(tid);
        if(sync==false)
            new net.ContentLoader(url, setValuesHandler, setValuesErrorHandler, "POST", requestString, true);
        else if(sync==true){
                iforms.ajax.processRequest(requestString, url);
        }
    }

    function setValuesHandler(){
        /*var controlsHeader = this.req.getResponseHeader("controls");
        var valuesHeader = this.req.getResponseHeader("values");
        var values = valuesHeader.split(",");
        var controls = controlsHeader.split(",");
        for(var i=0;i<controls.length;i++){
            var controlId  = controls[i].replace(/\./g, '_');
            setValue(controlId, values[i]);
        }*/
    }

    function setValuesErrorHandler(){
    }


    function setDataInControlsFromDB(query,controls,sync){  
        var url = "action_API.jsp";
        query = "controls="+controls.toString()+"&setdata="+query+"&syncFlag="+sync;
        if(sync==false)
            var contentLoaderRef = new net.ContentLoader(url, setDataInControlsHandler, DBErrorHandler, "POST", query, true);
        else if(sync==true){
            try{
                var jsonObj = JSON.parse(iforms.ajax.processRequest(query,url));
                var json={};
                if(jsonObj[0]==null){
                    for(var i=0;i<controls.split(",").length;i++){
                        var objComp = document.getElementById(controls.split(",")[i]);
                        if(objComp==null)
                        {
                            objComp =  document.getElementsByName(controls.split(",")[i])[0];
                        }
                        if((objComp.type=='text' && objComp.classList.contains("editableCombo")) || objComp.type=='select-one' || objComp.type=='ComboBox' || objComp.type=='select-multiple'){
                            populateComboValuesfromString(controls.split(",")[i],{});
                        }
                        else{
                            json[controls.split(",")[i]] =  "";
                        }
                    }
                    setValues(json,true);
                    return;
                }
                //Bug 75527 Start
                if(controls.split(",").length==1&&Object.keys(jsonObj).length==2){
                    populateComboValuesfromString(controls.split(",")[0],jsonObj[0],jsonObj[1]);
                }
                else
                {
                    for(var i=0;i<controls.split(",").length;i++)
                    {
                        var objComp = document.getElementById(controls.split(",")[i]);
                        if(objComp==null)
                        {
                            objComp =  document.getElementsByName(controls.split(",")[i])[0];
                        }
                        if((objComp.type=='text' && objComp.classList.contains("editableCombo")) ||objComp.type=='select-one' || objComp.type=='ComboBox' || objComp.type=='select-multiple'){
                            populateComboValuesfromString(controls.split(",")[i],jsonObj[i]);
                        }
                        else{
                            json[controls.split(",")[i]] =  jsonObj[i][0];
                        }
                    }
                    //Bug 75527 End
                    setValues(json,true);
                }
            }
            catch(ex){}
        }
    }

    function setDataInControlsHandler(){
        var jsonString = this.req.responseText;
        var controls = getQueryVariable(this.params, "controls");
        try{
            var jsonObj = JSON.parse(jsonString);
            var json = {};
            if(jsonObj[0]==null){
                for(var i=0;i<controls.split(",").length;i++){
                    var objComp = document.getElementById(controls.split(",")[i]);
                    if(objComp==null)
                    {
                        objComp =  document.getElementsByName(controls.split(",")[i])[0];
                    }
                    if((objComp.type=='text' && objComp.classList.contains("editableCombo")) || objComp.type=='select-one' || objComp.type=='ComboBox' || objComp.type=='select-multiple'){
                        populateComboValuesfromString(controls.split(",")[i],{});
                    }
                    else{
                        json[controls.split(",")[i]] =  "";
                    }
                }
                setValues(json,true);
                return;
            }
            //Bug 75527 Start
            if(controls.split(",").length==1&&Object.keys(jsonObj).length==2){
                populateComboValuesfromString(controls.split(",")[0],jsonObj[0],jsonObj[1]);
            }
            else{
                for(var i=0;i<controls.split(",").length;i++){
                    if(jsonObj[i]==null)
                        break;
                    var objComp = document.getElementById(controls.split(",")[i]);
                    if(objComp==null)
                    {
                        objComp =  document.getElementsByName(controls.split(",")[i])[0];
                    }
                    if((objComp.type=='text' && objComp.classList.contains("editableCombo")) || objComp.type=='select-one' || objComp.type=='ComboBox' || objComp.type=='select-multiple'){
                        populateComboValuesfromString(controls.split(",")[i],jsonObj[i]);
                    }
                    else{
                        json[controls.split(",")[i]] =  jsonObj[i][0];
                    }
                }
                //Bug 75527 End
                setValues(json,true);
            }
        }
        catch(ex){}
    //    for(var i=0;i<controls.split(",").length;i++){
    //        json[controls.split(",")[i]] =  jsonObj[i];
    //    }
    //    setValues(json,false);
    }

    function DBErrorHandler(){
    }

    function showMessage(control,msg,dialogType, isClose){
        /*if(dialogType.toLowerCase() == "error")
        {
            msg="<div class='typeError' style='color:#ba3212;margin-bottom: 10px;'><span style='font-size:35px;padding-right: 10px;' class='glyphicon glyphicon-remove-sign'></span><span  style='font-size:16px;font-weight: bold;'>Something went wrong</span></div>"+msg;
        }
        if(dialogType.toLowerCase() == "warning")
        {
            msg="<div class='typeWarning' style='color:#b36106;margin-bottom: 10px;'><span style='font-size:35px;padding-right: 10px;' class='glyphicon glyphicon-exclamation-sign'></span><span style='font-size:16px;font-weight: bold;'>Warning</span></div>"+msg;
            dialogType="error";
        }
        if(dialogType.toLowerCase() == "success")
        {
            msg="<div class='typeSuccess' style='color:#268844;margin-bottom: 10px;'><span style='font-size:35px;padding-right: 10px;' class='glyphicon glyphicon-ok-sign'></span><span style='font-size:16px;'>Success</span></div>"+msg;
        }
        if(dialogType.toLowerCase() == "info")
        {
            msg="<div class='typeInfo' style='color:#0072c6;margin-bottom: 10px;'><span style='font-size:35px;padding-right: 10px;' class='glyphicon glyphicon-info-sign'></span><span style='font-size:16px;'>Info</span></div>"+msg;
        }*/
        if( isClose == undefined ){
            isClose = true;
        }
        if(dialogType.toLowerCase() == "error"){
            //showError(control,msg,"error");
            showBootBox(control, msg, "error",isClose)
        }
        else if(dialogType.toLowerCase() == "confirm"){
            //showError(control,msg,"confirm");
            showBootBox(control, msg, "confirm", isClose)
        }
		setStyle('button62', "disable", "false");
    }

    function showBootBox(control,msg,type,isClose){
        if(type=='error'){
            bootbox.alert({ 
                size: "small",
                message: msg,
                closeButton: isClose,    
                callback: function(){
                    if(window.okOperation){
                        okOperation(control);
                    }
                    else{
                        if(control!=null)
                        {
                            this.modal('hide');
                            setFocus(control);
                        }
                    }
                }
            })

        }

        else if(type=='confirm'){
            bootbox.confirm({ 
                size: "small",
                message: msg, 
                closeButton: isClose,  
                callback: function(result){
                    if(result==true){
                       if(window.okOperation){
                        okOperation(control);
                    }
                    else{
                        if(control!=null)
                        {
                            this.modal('hide');
                            setFocus(control);
                        }
                    } 
                    }
                    else{
                        if(window.cancelOperation){
                        cancelOperation(control);
                    }
                    else{
                        if(control!=null)
                        {
                             this.modal('hide');
                            setFocus(control);
                        }
                    } 
                    }

                }
            })
        }

    }

    //User defined custom code
    /*function okOperation(pComp){
        jQuery("#pnlDialog").dialog("close");
        if(pComp!=null)
        {
             clearTable("table1",true);
        }
    }

    function cancelOperation(pComp){
        jQuery("#pnlDialog").dialog("close");
        if(pComp!=null)
        {
             setValueInTableFromDB("ads","table1",true);
        }
    }
    */

    //function showConfirmDialog(pMsg,pButtons)
    //{            
    //    var objDialog = jQuery("#dlgContent");
    //    objDialog.html(pMsg);
    //    jQuery("#pnlDialog").dialog(
    //    {                
    //        resizable: false,
    //        height:160,
    //        modal: true,
    //		dialogClass:"oforms_dialog",
    //        buttons: pButtons,
    //        zIndex:9999,
    //        close:function( event, ui )
    //        {
    //            jQuery(".ui-widget-overlay").css("display","none");                        
    //        }
    //    });
    //    jQuery(".ui-dialog .ui-icon-closethick").attr("title", "Close");
    //    jQuery(".ui-dialog").css("z-index",9999);
    //    var arry = jQuery(".ui-button-text");  
    //    if( arry.length > 1 ){
    //        for( var p=0;p < arry.length; p++ ){
    //            if( arry.get(0).innerHTML == "Yes"){
    //            //arry.get(0).innerHTML = ALERT_YES;
    //            }
    //            else if( arry.get(0).innerHTML == "No"){
    //        //arry.get(0).innerHTML = ALERT_NO;
    //        }
    //        }
    //    }
    //    else{
    ////jQuery(".ui-button-text").text(ALERT_OK);
    //}
    //}

    //function showError(pComp,pMsg,dialogType){    
    //    if(pMsg==null || pMsg=="")
    //        return;
    //    if(dialogType == "error"){
    //        var buttons = 
    //        {
    //            Ok: function()
    //            {        
    //                if(window.okOperation){
    //                    okOperation(pComp);
    //                }
    //                else{
    //                    jQuery("#pnlDialog").dialog("close");
    //                    if(pComp!=null)
    //                    {
    //                        setFocus(pComp);
    //                    }
    //                }
    //            }
    //        };
    //    }
    //    else if(dialogType == "confirm"){
    //        var buttons = 
    //        {
    //            Ok: function()
    //            {
    //                if(window.okOperation){
    //                    okOperation(pComp);
    //                }
    //                else{
    //                    jQuery("#pnlDialog").dialog("close");
    //                    if(pComp!=null)
    //                    {
    //                        setFocus(pComp);
    //                    }
    //                }
    //                
    //            },
    //            Cancel: function()
    //            {   
    //                if(window.cancelOperation){
    //                    cancelOperation(pComp);
    //                }
    //                else{
    //                    jQuery("#pnlDialog").dialog("close");
    //                    if(pComp!=null)
    //                    {
    //                        setFocus(pComp);
    //                    }
    //                }
    //            }
    //        };
    //    }
    //            
    //    var origMsg = pMsg;
    //    if(window.getMessage)
    //    {
    //        if( typeof pComp == "string" ) 
    //            pMsg = getMessage(pComp,pMsg);
    //        else if( pComp instanceof jQuery)
    //            pMsg = getMessage(pComp.attr("id"),pMsg);
    //        else     
    //            pMsg = getMessage(pComp.id,pMsg);
    //    }
    //    if(pMsg == null || jQuery.trim(pMsg).length == 0)
    //        pMsg = origMsg;
    //    if( pMsg != "DONOTSHOWERRORMSG")
    //        showConfirmDialog(pMsg,buttons);
    //    if(window.removeMasking)
    //    {
    //        try
    //        {
    //            window.parent.hideProcessing();
    //        }
    //        catch(ex)
    //        {
    //                            
    //        }
    //        removeMasking();
    //    }
    ////alert(pMsg);
    //                            
    //}

    function getValueFromTableCell(tableId,rowIndex,colIndex)
    {
        var table = document.getElementById(tableId);
        //var row= table.getElementsByClassName("rowinhtml")[rowIndex];
        if (table != null && table != undefined)
        {
            //Bug 81548 
            //var row = table.getElementsByTagName("tr")[rowIndex + 1];
            var row = table.tBodies[0].getElementsByTagName("tr")[rowIndex];
            if(row != null && row != undefined)
            { 
                var cell = row.getElementsByTagName("td")[colIndex + 1];
                var control = cell.getElementsByClassName("control-class")[0];
                if( control === undefined ){
                    return cell.innerHTML;
                }
                if (cell != null && cell != undefined)
                {
                    if (control.type != undefined && control.type == "checkbox" || control.type == "radio")
                    {
                        //alert(control.checked);
                        return control.checked;
                    }
                    else if((table.getAttribute("type") == "Table" ||table.getAttribute("type") == "ListView") && (control.getAttribute("typeofvalue") == "Text" ||control.getAttribute("typeofvalue") == "Float"))//Bug 85502
                    {
                    if (control.getAttribute("maskingPattern") != null && control.getAttribute("maskingPattern") != undefined && control.getAttribute("maskingPattern") != '' && control.getAttribute("maskingPattern") != 'nomasking' && control.getAttribute("maskingPattern") != 'email') 
                    {
                        if (control.getAttribute("maskingPattern").toString() === 'currency_rupees' || control.getAttribute("maskingPattern").toString() === 'currency_dollar' || control.getAttribute("maskingPattern").toString() === 'currency_yen' || control.getAttribute("maskingPattern").toString() === 'currency_euro' || control.getAttribute("maskingPattern").toString() === 'currency_french' || control.getAttribute("maskingPattern").toString() === 'currency_greek' || control.getAttribute("maskingPattern").toString() === 'percentage' || control.getAttribute("maskingPattern").toString() === 'dgroup2' || control.getAttribute("maskingPattern").toString() === 'dgroup3' || control.getAttribute("maskingPattern").toString() === 'NZP')
                            return jQuery(control).autoNumeric('get');
                        else {
                            if (!control.getAttribute("datatype") == "date")
                                return jQuery(control).cleanVal();
                            else
                                return control.value;
                        }
                    }
                    else{
                        if (control.tagName == "LABEL" || control.tagName == "A")
                            return control.textContent;
                        else
                            return control.value;
                    }                      
                    }
                    else if (control.tagName == "LABEL" || control.tagName == "A"){
                        //alert(control.checked);
                        return control.textContent;
                    }
                    else{
                        //alert(control.value);
                        return control.value;
                    }
                }
            }
        }
    }


function getValueFromColumnName(tableId,rowIndex,colName)
    {
        var table = document.getElementById(tableId);
        if (table != null && table != undefined)
        {
            var children = table.parentNode.parentNode.childNodes;
            var theads = children[0].getElementsByTagName("th");
            var ColIndex = 0;
            for(var i=0;i<theads.length;i++){
                if(theads[i].innerText == colName)
                {
                    colIndex = i-1;
                    break;
                }
            }
            return getValueFromTableCell(tableId,rowIndex,colIndex);
        }
    }

    function setColumnVisible(tableId,colIndex,visibleFlag,sync)
    {
        // var table = document.getElementById(tableId);
        if (document.getElementById(tableId) != null && document.getElementById(tableId) != undefined)
        {
            var table = document.getElementById(tableId);
            var children = table.parentNode.parentNode.childNodes;
            var theads = children[0].getElementsByTagName("th");
                var url = "action_API.jsp";
            if(colIndex==''){

                var requestString = "tableId=" + tableId + "&colIndex=" + colIndex + "&visibleFlag=" + visibleFlag;
                if (sync === false) {
                    new net.ContentLoader(url, setColumnVisibleHandler, setColumnVisibleErrorHandler, "POST", requestString, true);
                } else if (sync === true) {
                    iforms.ajax.processRequest(requestString, url);
                    setColumnVisibleHelper(tableId, colIndex, visibleFlag);
                }
            }
            else if(colIndex <= (theads.length-2) && colIndex >= 0)
            {
                var requestString = "tableId=" + tableId + "&colIndex=" + colIndex + "&visibleFlag=" + visibleFlag;
                if (sync === false) {
                    new net.ContentLoader(url, setColumnVisibleHandler, setColumnVisibleErrorHandler, "POST", requestString, true);
                } else if (sync === true) {
                    iforms.ajax.processRequest(requestString, url);
                    setColumnVisibleHelper(tableId, colIndex, visibleFlag);
        }
    }
        }
    }


    function setColumnVisibleHandler(){
        var tableId = getQueryVariable(this.params, "tableId");
        var colIndex = getQueryVariable(this.params, "colIndex");
        var visibleFlag = getQueryVariable(this.params, "visibleFlag");
        setColumnVisibleHelper(tableId,parseInt(colIndex),visibleFlag);
    }

    function setColumnVisibleErrorHandler(){

    }

    function setColumnVisibleHelper(tableId,colIndex,flag)
    {
        var tds = document.getElementById(tableId).getElementsByTagName("td");
        var table = document.getElementById(tableId);
 
        if(table != null && table != undefined)
        { 
            var col=[]; 
            var children = table.parentNode.parentNode.childNodes;
            var theads = children[0].getElementsByTagName("th");
            var innerTheadsLength=0;
            var innerTheads="";
            if(table.tHead!=null && table.tHead!=undefined){
             innerTheads = table.tHead.getElementsByTagName("th");
             innerTheadsLength = innerTheads.length;
            }
            col.push(theads[colIndex+1]);
            var j=0;
            for(var i=0;i<colIndex+1;i++){
                if(theads[i].style.display!="none")
                    j++;
            }
            if(flag=="false" && innerTheadsLength>j)
                col.push(innerTheads[j]);
            var rows = table.tBodies[0].getElementsByTagName("tr");
            var cells=[];  
 
            for (var i = 0; i < rows.length; i++)
            {
                // if(<=theads.length)
                if (rows[i].getElementsByTagName("td").length > 0)
                    cells.push(rows[i].getElementsByTagName("td")[colIndex + 1]);
                if (rows[i].getElementsByTagName("th").length > 0){
                    cells.push(rows[i].getElementsByTagName("th")[colIndex + 1]);
                }
            }
            if(table.tFoot!=null && table.tFoot!=undefined){
            var rows = table.tFoot.getElementsByTagName("tr");
            
             for (var i = 0; i < rows.length; i++){
            
                if (rows[i].getElementsByTagName("th").length > 0){
                    cells.push(rows[i].getElementsByTagName("th")[colIndex + 1]);
                }
            }
            }
            
            for (var i = 0; i < cells.length; i++)
                col.push(cells[i]);
 
            // console.log(col);
            if (flag === "false" || flag == false) {
                for (var i = 0; i < col.length; i++) {
                    if (col[i] != null)
                        col[i].style.display = "none";
                }
            } else if (flag === "true" || flag == true) {
                for (var i = 0; i < col.length; i++) {
                    col[i].style.display = "";
                }
            }
 
            $("#" + tableId).floatThead('reflow');
 
        }
    }


    function setColumnDisable(tableId,colIndex,disableFlag,sync){
        var control = document.getElementById(tableId);
        var dateicons = control.getElementsByClassName("glyphicon-calendar");
        var url = "action_API.jsp";
        var requestString = "tableId="+tableId+"&colIndex="+colIndex+"&disableFlag="+disableFlag;
        if(sync===false){
            new net.ContentLoader(url, setColumnDisableHandler, setColumnDisableErrorHandler, "POST", requestString, true);
        }
        else if(sync===true){
            if(isDatePicker=="N")
            {
                for(var i=0;i<dateicons.length;i++)
                {
                    if(disableFlag == "true")
                        dateicons[i].style.visibility = "hidden";
                    else
                        dateicons[i].style.visibility = "";
                }
            }
                iforms.ajax.processRequest(requestString,url);
            setColumnDisableHelper(tableId,colIndex,disableFlag);
        }
    }

    function setColumnDisableHandler(){
        var tableId = getQueryVariable(this.params, "tableId");
        var colIndex = getQueryVariable(this.params, "colIndex");
        var disableFlag = getQueryVariable(this.params, "disableFlag");
            var control = document.getElementById(tableId);
        var dateicons = control.getElementsByClassName("glyphicon-calendar");
        if(isDatePicker=="N")
        {
            for (var i = 0; i < dateicons.length; i++)
            {
                if (disableFlag == "true")
                    dateicons[i].style.visibility = "hidden";
                else
                    dateicons[i].style.visibility = "";
            }
        }
        setColumnDisableHelper(tableId,parseInt(colIndex),disableFlag);
    }

    function setColumnDisableHelper(tableId,colIndex,flag){
        var tds = document.getElementById(tableId).getElementsByTagName("td");
        var col=[];
        var table = document.getElementById(tableId);
        var children = table.parentNode.parentNode.childNodes;
        var theads = children[0].getElementsByTagName("th");
        var innerTheads = table.getElementsByTagName("th");
        //col.push(theads[colIndex+1]);
        //col.push(innerTheads[colIndex+1]);
        var rows = table.tBodies[0].getElementsByTagName("tr");
        var cells=[];
        for(var i=0;i<rows.length;i++){
            cells.push(rows[i].getElementsByTagName("td")[colIndex+1]);
        }
        for(var i=0;i<cells.length;i++)
            col.push(cells[i]);

        // console.log(col);
        if(flag==="false" || flag==false){
            for(var i=0;i<col.length;i++){
                if( col[i].getElementsByClassName("control-class")[0]!=undefined){
                    col[i].getElementsByClassName("control-class")[0].disabled = false;
                    var type = col[i].getElementsByClassName("control-class")[0].tagName;
                    if(type=="A" || type=="IMG"){
                        col[i].getElementsByClassName("control-class")[0].style.pointerEvents = "";
                        col[i].getElementsByClassName("control-class")[0].style.cursor = "";
                    }
                }
            }
        }
        else if(flag==="true" || flag==true){
            for(var i=0;i<col.length;i++){
                if( col[i].getElementsByClassName("control-class")[0]!=undefined){
                    col[i].getElementsByClassName("control-class")[0].disabled = true;
                    var type = col[i].getElementsByClassName("control-class")[0].tagName;
                     if(type=="A" || type=="IMG"){
                        col[i].getElementsByClassName("control-class")[0].style.pointerEvents = "none";
                        col[i].getElementsByClassName("control-class")[0].style.cursor = "default";
                    }
                   
                }
            }
        }

    //    $("#"+tableId).floatThead('reflow');
    }

    function setColumnDisableErrorHandler(){

    }

    function setTableCellColor(tableId,rowIndex,colIndex,color)
    {
        var table = document.getElementById(tableId);
        // var row= table.getElementsByClassName("rowinhtml")[rowIndex];
        if(table != null && table !=undefined)
        {
        var row = table.tBodies[0].getElementsByTagName("tr")[rowIndex];
        var col = row.getElementsByTagName("td")[colIndex+1];
        col.style.backgroundColor = "#"+color;
        }
    }

    function setCellDisabled(tableId,rowIndex,colIndex,flag)
    {
        var table = document.getElementById(tableId);
        if (table != null && table != undefined)
        {
            // var row= table.getElementsByClassName("rowinhtml")[rowIndex];
            var row = table.tBodies[0].getElementsByTagName("tr")[rowIndex];
            var col = row.getElementsByTagName("td")[colIndex + 1];
            if(row != null && row != undefined )
            {
                var control = col.getElementsByClassName("control-class")[0];
            if (col != null && col != undefined)
            {
                if (flag == "true"){
                    control.disabled = "true";
                    jQuery(control).parent().css("pointerEvents","none");
                    jQuery(control).parent().css("cursor","default");
                    if(control.classList.contains("btn")){
                        control.classList.add("disabledCellBtn")
                    }
//                    if(control.tagName=="A" || control.tagName=="IMG")
//                    {
//                        
//                        control.style.pointerEvents = "none";
//                        control.style.cursor = "default";
//                    }
                }
                else if (flag == "false") {
                    control.removeAttribute("disabled");
                    jQuery(control).parent().css("pointerEvents","auto");
                    jQuery(control).parent().css("cursor","");
                    if(control.classList.contains("btn")){
                        control.classList.remove("disabledCellBtn")
                    }
//                    if(control.tagName=="A"|| control.tagName=="IMG")
//                    {
//                        control.style.pointerEvents = "";
//                        control.style.cursor = "";
//                    }
                }
            }
            }
        }
    }

    function removeRow(tableId,rowIndex)
    {
        var table = document.getElementById(tableId);
        if (table != null && table != undefined )
        {
            //var rows = table.getElementsByClassName('rowinhtml'); 
            var rows = table.tBodies[0].getElementsByTagName('tr');
            if(rows != null && rows != undefined && rows[rowIndex] != null && rows.length != null)
            {
                rows[rowIndex].remove();
            }
        }
    }



    function setTableData(tableId,jsonObj,sync){
        var url = "action_API.jsp";
            var rowIndex,colIndex,cellData;
        var jsonString = JSON.stringify(jsonObj);
        var requestString = "setTableDataFlag=yes&tableId="+tableId+"&jsonString="+encode_utf8(jsonString)+"&pid="+encode_utf8(pid)+"&wid="+encode_utf8(wid)+"&tid="+encode_utf8(tid)+"&fid="+encode_utf8(fid);

        if(sync=="false" || sync==false){
            new net.ContentLoader(url, setTableDataHandler, formErrorHandler, "POST", requestString, true);
        }
        else if(sync=="true" || sync==true){
            iforms.ajax.processRequest(requestString, url);
            for(key in jsonObj){
                rowIndex = key.split(",")[0];
                colIndex = key.split(",")[1];
                cellData = jsonObj[key];
                setTableDataHelper(tableId, rowIndex, colIndex, cellData);
            }
        }
    }

    function setTableDataHandler(){
        var rowIndices = this.req.getResponseHeader("rowIndices");
        var colIndices = this.req.getResponseHeader("colIndices");
        var cellDatas = this.req.getResponseHeader("cellDatas");
        var tableId = getQueryVariable(this.params, "tableId");
        for(var i=0;i<rowIndices.length;i++){
            setTableDataHelper(tableId, rowIndices.split(",")[i], colIndices.split(",")[i], cellDatas.split(",")[i]);
        }
    }

    function setTableDataHelper(tableId,rowIndex,colIndex,cellData){
        var table = document.getElementById(tableId);
        if(table==null)
        {
            table =  document.getElementsByName(tableId)[0];
        }
        var row;
       if(table.getElementsByTagName("tr")[parseInt(rowIndex)+1]){
            row = table.getElementsByTagName("tr")[parseInt(rowIndex)+1];
            if(row.style.display=="none"){
                     row = table.getElementsByClassName("rowinhtml")[parseInt(rowIndex)];
            }
        }
        else
            return;
        var col;
        if(row.getElementsByTagName("td")[parseInt(colIndex)+1])
            col = row.getElementsByTagName("td")[parseInt(colIndex)+1];
        else
            return;
        var control = col.getElementsByClassName("control-class")[0];
        if(control.type=='text'||control.type=="textarea"){
            control.value=cellData;
        }//Bug 76737 End
        if(control.type=='select-one' || control.type=='ComboBox')
        {   
            control.value=cellData;   
        }
        else if(control.tagName=='LABEL')
        {
            control.innerHTML=escapeStringForHTML(cellData);
        }
        else if(control.type=='radio')
        {
            if(cellData=="true")
                control.checked=true;
            else
                control.checked=false;
        }
        else if(control.type=='checkbox')
        {
            if(cellData.toLowerCase()=="true")
            {
                control.checked=true;
            }
            else
            {
                control.checked=false;
            }
        }
        else
            control.value = cellData;
    }


    function getSelectedIndex(controlId){
        return $("select[id="+controlId+"] option:selected").index();
    }


    function saveWorkItem(bshowMsg){
        if( bshowMsg == undefined )
            bshowMsg = true;
        if(mobileMode=="ios"||mobileMode=="android"){
            saveForm('S',true);
        }
        else{
            if(window.parent && window.parent.WFSave){
              window.parent.WFSave(bshowMsg)
            }
        }
    }

    function completeWorkItem(){
		decisionHistoryGrid();
        if(mobileMode=="ios"||mobileMode=="android"){
            saveForm('D',false);
        }
        else{
           if( window.parent &&  window.parent.WFDone){
              window.parent.WFDone();
           }
        }
    }

    function getStyle(controlId,styleName){
        if(styleName.toLowerCase()=="backcolor"){
            return jQuery('#'+controlId).css("background-color");
        }

        else if(styleName.toLowerCase()=="visibility"){
            return jQuery('#'+controlId).css("background-color");
        }

        else if(styleName.toLowerCase()=="islocked"){
            return $('#'+controlId).is('[readonly]');
        }

        else if(styleName.toLowerCase()=="isdisabled"){
            return $('#'+controlId).is('[disabled]');
        }

    }


    function getValue(controlId)
    {
        var control = document.getElementById(controlId);
        if(useCustomIdAsControlName && (control==null || control==undefined)){
	            control = document.getElementsByName(controlId)[0];
	            if(control != null && control != undefined)
	              controlId = control.getAttribute("id");	        
	        }
        if (control != null && control != undefined)
        {
            if (control != undefined && control.classList.contains("iform-radio")) {
                var buttons = document.getElementsByName(controlId);
                for (var i = 0; i < buttons.length; i++) {
                    if (buttons[i].checked) {
                        return buttons[i].value;
                        break;
                    }
                }
            }
            if (control.type == "textarea" || control.type == "text") {
                if(control.getAttribute("AutoCompleteValue")!=null && control.getAttribute("AutoCompleteValue")!=undefined){
                    return control.getAttribute("AutoCompleteValue");
                }
                if(control.getAttribute("datatype") == "combobox"){
                    var ele = control.parentNode.getElementsByClassName("es-visible");
                    if( ele != null && ele > 0 ){
                        //if(ele[0].getAttribute("value")==null || ele[0].getAttribute("value")==undefined) return "";
                        return ele[0].getAttribute("originalValue");
                    }
                }
                return getControlValue(control);//Bug 81189
            } else if (control.type == "checkbox") {
                return control.checked;
            } else if (control.type == "select-one") {
                if(control.selectedIndex>=0)
                    return control.options[control.selectedIndex].value;
            }
            //Bug 83359 starts
            else if (control.type == "select-multiple") {
                return jQuery(control).val();
            }
            //Bug 83359 ends
            
        else if(control.tagName == "LABEL")
        {
            return control.innerHTML;
        }
    }
}

    function getSelectedItemLabel(comboId)
    {
        var combo = document.getElementById(comboId);
        if( useCustomIdAsControlName && (combo==null || combo==undefined)){
            combo = document.getElementsByName(comboId)[0];
            comboId = combo.getAttribute("id");
        }
        if (combo != null && combo != undefined)
        {
                    if(combo.type == "text"&&combo.getAttribute("datatype") == "combobox"){
                            var ele = combo.parentNode.getElementsByClassName("es-visible");//Bug 83222
                            if( ele != null )
                                    return ele[0].innerHTML;
                    }
            var selectedText = combo.options[combo.selectedIndex].text;
            return selectedText;
        }
    }

    function getItemLabel(comboId,index)
    {
        var combo = document.getElementById(comboId);
        if( useCustomIdAsControlName && (combo==null || combo==undefined)){
            combo = document.getElementsByName(comboId)[0];
            comboId = combo.getAttribute("id");
        }
        if (combo != null && combo != undefined)
        {
            return combo.options[index].text;
        }
    }

    function addItemInCombo(comboId,label,value,tooltip,optionControlId)
    {   
        var combo = document.getElementById(comboId);
        if( useCustomIdAsControlName && (combo==null || combo==undefined)){
            combo = document.getElementsByName(comboId)[0];
            comboId = combo.getAttribute("id");
        }
        if(combo.tagName!="SELECT"){
            var fieldElements = document.getElementsByName(comboId);
            for(var i=0;i<fieldElements.length;i++)
            {
                if(fieldElements[i].tagName == "SELECT")
                    combo=document.getElementsByName(comboId)[i];
            }
        }
        var option;
        if (combo != null && combo != undefined)
        {
            //Bug 81099 If a field is mapped , the mapped field is coming twice in a dropdown
            var selectedValue=combo.value;
            if (combo.tagName == 'SELECT') {
                for( var len = combo.options.length-1 ; len >= 0 ; len-- ){
                    if( combo.options[len].text === label ){
                        combo.remove(len);
                }   
                }
            }
            else{//Bug 83222 Start
                var ul = combo.parentNode.childNodes[2];
                for(var i=ul.childNodes.length-1;i>=0;i--){
                    if(ul.childNodes[i].innerHTML==label)
                        ul.removeChild(ul.childNodes[i]);
                }
            }//Bug 83222 End

    //        var hasOption = $('#'+comboId+' option:contains(' + label + ')');        
    //        if (hasOption.length> 0) {
    //            combo.remove(hasOption.index());
    //        }   
            option = document.createElement('option');        
            if (combo.tagName == 'SELECT') {
                if( typeof optionControlId != "undefined" ){
                    option.id = optionControlId;
                }
                if (typeof label != "undefined" && typeof value == "undefined" && typeof tooltip == "undefined") {
                    option.text = label;
                    option.value = label;//Bug 84292
                    combo.add(option);
                }
                if (typeof label != "undefined" && typeof value != "undefined" && typeof tooltip == "undefined") {
                    option.text = label;
                    option.value = value;
                    combo.add(option);
                }

                if (typeof label != "undefined" && typeof value != "undefined" && typeof tooltip !== "undefined") {
                    option.text = label;
                    option.value = value;
                    option.setAttribute("data-toggle", "tooltip");
                    option.title = tooltip;
                    combo.add(option);                              
                }
                if(combo.multiple){
                    reloadListBoxLayout(comboId);
                }
            } else {
                var liElem = document.createElement('li');
                if( typeof optionControlId != "undefined" ){
                    liElem.id = optionControlId;
                }
                if (typeof label != "undefined" && typeof value == "undefined" && typeof tooltip == "undefined") {
                    liElem.appendChild(document.createTextNode(label));
                }
                if (typeof label != "undefined" && typeof value != "undefined" && typeof tooltip == "undefined") {
                    liElem.appendChild(document.createTextNode(label));
                    liElem.setAttribute("value", value);
                }

                if (typeof label != "undefined" && typeof value != "undefined" && typeof tooltip !== "undefined") {
                    liElem.appendChild(document.createTextNode(label));
                    liElem.setAttribute("value", value);
                    liElem.title = tooltip;
                }
                var ul = combo.parentNode.childNodes[2];
                liElem.style.display = "block";
                ul.appendChild(liElem);
            }
            //Bug 81099 If a field is mapped , the mapped field is coming twice in a dropdown
            combo.value=selectedValue;
        }
    }

    function reloadListBoxLayout(listboxId){
        var listBox = document.getElementById(listboxId);
        jQuery(listBox).multiselect('rebuild');
        $(listBox).siblings().find('.multiselect-container .checkbox').addClass('inputStyle');
        $(listBox).siblings().find('.multiselect-container .checkbox').css("border","0px");
        $(listBox).siblings().find('.dropdown-toggle').addClass('inputStyle');   
        //Bug 81918 - setStyle() API not working on multiselect 
        if(listBox.disabled){
            $(listBox).siblings().find('.dropdown-toggle').addClass('disabledBGColor');
            $(listBox).siblings().find('.dropdown-toggle').attr("disabled",true);
        }else{
            $(listBox).siblings().find('.dropdown-toggle').removeClass('disabledBGColor');
            $(listBox).siblings().find('.dropdown-toggle').removeAttr("disabled");
        }          
        $(listBox).siblings().find('.dropdown-toggle .caret').css('float',"right"); 
        $(listBox).siblings().find('.dropdown-toggle').attr("tooltip",jQuery(listBox).attr("tooltip"));
        $(listBox).siblings().find('.multiselect-container .checkbox').css("text-align",$(listBox).css("text-align"));
        $(listBox).siblings().find('.multiselect-container .checkbox').css("font-size",$(listBox).css("font-size"));
        $(listBox).siblings().find('.multiselect-container .checkbox').css("font-weight",$(listBox).css("font-weight"));
        $(listBox).siblings().find('.multiselect-container .checkbox').css("font-style",$(listBox).css("font-style"));
        $(listBox).siblings().find('.multiselect-container .checkbox').css("font-family",$(listBox).css("font-family"));
        $(listBox).siblings().find('.multiselect-container .checkbox').css("background-color",$(listBox).css("background-color"));
        $(listBox).siblings().find('.multiselect-container .checkbox').css("color",$(listBox).css("color"));       
        $(listBox).siblings().find('.dropdown-toggle').css("text-align",$(listBox).css("text-align"));
        $(listBox).siblings().find('.dropdown-toggle').css("font-size",$(listBox).css("font-size"));
        $(listBox).siblings().find('.dropdown-toggle').css("font-weight",$(listBox).css("font-weight"));
        $(listBox).siblings().find('.dropdown-toggle').css("font-style",$(listBox).css("font-style"));
        $(listBox).siblings().find('.dropdown-toggle').css("font-family",$(listBox).css("font-family"));
        $(listBox).siblings().find('.dropdown-toggle').css("background-color",$(listBox).css("background-color"));
        $(listBox).siblings().find('.dropdown-toggle').css("color",$(listBox).css("color"));        
    }

    function getItemCountInCombo(comboId){
        var combo = document.getElementById(comboId);
        if( useCustomIdAsControlName && (combo==null || combo==undefined)){
            combo = document.getElementsByName(comboId)[0];
            comboId = combo.getAttribute("id");
        }
        if (combo != null && combo != undefined)
        {
            return combo.length;
        }
    }

    function getSheetIndex(tabId){

        return $('#'+tabId+' .iformTabUL .active').index();
    }

    function removeItemFromCombo(comboId,itemIndex)
    {
        var combo = document.getElementById(comboId);
        if( useCustomIdAsControlName && (combo==null || combo==undefined)){
            combo = document.getElementsByName(comboId)[0];
            comboId = combo.getAttribute("id");
        }
        if (combo != null && combo != undefined)
        {
            combo.remove(itemIndex);
    //    for(var i=0;i<combo.length;i++){
    //        if(combo.options[i].label==label){
    //            combo.remove(i);
    //        }
    //    }
        }
        if(combo.multiple){
            reloadListBoxLayout(comboId);
        }
    }

    function selectSheet(tabID, index) {
        if (document.getElementById(tabID) != null && document.getElementById(tabID) != undefined)
        {
            var links = document.getElementById(tabID).getElementsByTagName("a");
            links[index].click();
        }
    }

    function setFocus(controlId,isListView){
        isListView=typeof isListView =="undefined"?false:isListView;
        var control = document.getElementById(controlId);
        if(useCustomIdAsControlName && (control==null || control==undefined)){
            control = document.getElementsByName(controlId)[0];
            if(control != null && control != undefined)
                controlId = control.getAttribute("id");
        }
        var checkedRadio;
        if(control!=null && control != undefined )
        {
           if(!isListView){
            var tab = control;
            var isTab = false;
            while(tab!=null && tab.classList!=null&&!tab.classList.contains("iformTabControl")){
                tab = tab.parentNode;
            }
            if(tab!=null && tab.classList!=null&&tab.classList.contains("iformTabControl")){
                isTab=true;
            }
            var section=control;
            var isSection=false;
            while(section!=null&&section.classList!=null&&!section.classList.contains("FrameControl")){
                section=section.parentNode;
            }
            if(section!=null &&section.classList!=null&& section.classList.contains("FrameControl")){
                isSection=true;
            }
            var ref;
            if(isSection){
                if(section.firstChild!=null&&section.firstChild.getAttribute("state")!=null&&section.firstChild.getAttribute("state")=="collapsed"){
                   ref=section.firstChild;
                   jQuery(ref).siblings().toggle(450,function(){
                        jQuery(ref).find("img").attr("src","resources/images/Arrows-"+(jQuery(ref).siblings().is(":visible") ? "Up" : "Down")+"-4-icon.png");
                        if((jQuery(ref).siblings().is(":visible")))
                        {
                            ref.parentNode.scrollIntoView(false);  
                        }
                        var sectionState;
                        if(jQuery(ref).attr("state") == "collapsed")
                        {
                        sectionState="expanded";
                        jQuery(ref).attr("state","expanded"); 
                        }
                        else
                        {
                            sectionState="collapsed";
                            jQuery(ref).attr("state","collapsed");           
                        } 
                        if(window.onChangeSectionState)
                            window.onChangeSectionState(jQuery(ref).parent().attr("id"),sectionState);
                        var secondSection=section.parentNode;
                        var isSecondSection=false;
                        while(secondSection!=null&&secondSection.classList!=null&&!secondSection.classList.contains("FrameControl")){
                            secondSection=secondSection.parentNode;
                        }
                        if(secondSection!=null &&secondSection.classList!=null&& secondSection.classList.contains("FrameControl")){
                            isSecondSection=true;
                        }
                        if(isSecondSection){
                            if(secondSection.firstChild!=null&&secondSection.firstChild.getAttribute("state")!=null&&secondSection.firstChild.getAttribute("state")=="collapsed"){
                                ref=secondSection.firstChild;
                                jQuery(ref).siblings().toggle(450,function(){
                                    jQuery(ref).find("img").attr("src","resources/images/Arrows-"+(jQuery(ref).siblings().is(":visible") ? "Up" : "Down")+"-4-icon.png");
                                    if((jQuery(ref).siblings().is(":visible")))
                                    {
                                        ref.parentNode.scrollIntoView(false);  
                                    }
                                    var sectionState;
                                    if(jQuery(ref).attr("state") == "collapsed")
                                    {
                                    sectionState="expanded";
                                    jQuery(ref).attr("state","expanded"); 
                                    }
                                    else
                                    {
                                        sectionState="collapsed";
                                        jQuery(ref).attr("state","collapsed");           
                                    } 
                                    if(window.onChangeSectionState)
                                        window.onChangeSectionState(jQuery(ref).parent().attr("id"),sectionState);
                                    if(isTab==true){
                                        var tabli = control;
                                        while(tabli.id.indexOf("sheet")==-1){
                                            tabli = tabli.parentNode;
                                        }
                                        var children = tab.getElementsByTagName("a");
                                        for(var i=0;i<children.length;i++){
                                            if(children[i].href.indexOf("#"+tabli.id)!=-1){
                                                break;
                                            }
                                        }
                                        $('[href=#'+tabli.id+']').on('shown.bs.tab', function (e) {
                                            if(control!=null && control.tagName == "BUTTON"){
                                                control.setAttribute("autofocus","");
                                                if(control.getAttribute("combotype")=="listbox"){
                                                    jQuery(control).parent().find("button").get(0).focus();
                                                }
                                                else
                                                {
                                                    control.focus();
                                                }
                                            }
                                            else if(control.classList.contains("iform-radio")){
                                                checkedRadio =  getCheckedRadioRef(control);
                                                checkedRadio.focus();
                                            }
                                            else{
                                                if(control.getAttribute("combotype")=="listbox"){
                                                    jQuery(control).parent().find("button").get(0).focus();
                                                }
                                                else
                                                {
                                                    control.focus();
                                                }
                                            }
                                            //control.focus();
                                        });
                                        selectSheet(tab.id,i);
                                    }
                                    if(control!=null && control.tagName == "BUTTON"){
                                        control.setAttribute("autofocus","");
                                        control.focus();
                                    }
                                    else if(control.classList.contains("iform-radio")){
                                        checkedRadio =  getCheckedRadioRef(control);
                                        checkedRadio.focus();
                                    }
                                    else{
                                        if(control.getAttribute("combotype")=="listbox")
                                        {
                                            jQuery(control).parent().find("button").get(0).focus();
                                        }
                                        else
                                        {
                                            control.focus();
                                        }
                                    }
                                }
                                );
                                var url = "action_API.jsp";
                                requestString = "frameId="+jQuery(ref).parent().attr("id")+"&frameState="+jQuery(ref).attr("state")+"&pid="+encode_utf8(pid)+"&wid="+encode_utf8(wid)+"&tid="+encode_utf8(tid)+"&fid="+encode_utf8(fid);
                                if( jQuery(ref).attr("painted")== undefined)
                                    new net.ContentLoader(url, frameResponseHandler, frameErrorHandler, "POST", requestString, true);

                                return;
                            }
                            //toggleSection(secondSection.firstChild);
                        }
                        if(isTab==true){
                            var tabli = control;
                            while(tabli.id.indexOf("sheet")==-1){
                                tabli = tabli.parentNode;
                            }
                            var children = tab.getElementsByTagName("a");
                            for(var i=0;i<children.length;i++){
                                if(children[i].href.indexOf("#"+tabli.id)!=-1){
                                    break;
                                }
                            }
                            $('[href=#'+tabli.id+']').on('shown.bs.tab', function (e) {
                                if(control!=null && control.tagName == "BUTTON"){
                                        control.setAttribute("autofocus","");
                                        control.focus();
                                    }
                                    else if(control.classList.contains("iform-radio")){
                                        checkedRadio =  getCheckedRadioRef(control);
                                        checkedRadio.focus();
                                    }
                                    else{
                                        if(control.getAttribute("combotype")=="listbox"){
                                                    jQuery(control).parent().find("button").get(0).focus();
                                                }
                                                else
                                                {
                                                    control.focus();
                                                }
                                    }
                                if(control.getAttribute("combotype")=="listbox"){
                                    jQuery(control).parent().find("button").get(0).focus();
                                }
                                else
                                {
                                    control.focus();
                                }
                            });
                            selectSheet(tab.id,i);
                        }
                        if(control!=null && control.tagName == "BUTTON"){
                            control.setAttribute("autofocus","");
                            control.focus();
                        }
                        else if(control.classList.contains("iform-radio")){
                            checkedRadio =  getCheckedRadioRef(control);
                            checkedRadio.focus();
                        }
                        else{
                            if(control.getAttribute("combotype")=="listbox")
                                        {
                                            jQuery(control).parent().find("button").get(0).focus();
                                        }
                                        else
                                        {
                                            control.focus();
                                        }
                        }
                    }
                    );
                    var url = "action_API.jsp";
                    requestString = "frameId="+jQuery(ref).parent().attr("id")+"&frameState="+jQuery(ref).attr("state")+"&pid="+encode_utf8(pid)+"&wid="+encode_utf8(wid)+"&tid="+encode_utf8(tid)+"&fid="+encode_utf8(fid);
                    if( jQuery(ref).attr("painted")== undefined)
                        new net.ContentLoader(url, frameResponseHandler, frameErrorHandler, "POST", requestString, true);
                    return;
                }
                else if(section.firstChild!=null&&section.firstChild.getAttribute("state")!=null&&section.firstChild.getAttribute("state")=="expanded"){
                    var secondSection=section.parentNode;
                    var isSecondSection=false;
                    while(secondSection!=null&&secondSection.classList!=null&&!secondSection.classList.contains("FrameControl")){
                        secondSection=secondSection.parentNode;
                    }
                    if(secondSection!=null &&secondSection.classList!=null&& secondSection.classList.contains("FrameControl")){
                        isSecondSection=true;
                    }
                    if(isSecondSection){
                        if(secondSection.firstChild!=null&&secondSection.firstChild.getAttribute("state")!=null&&secondSection.firstChild.getAttribute("state")=="collapsed"){
                            ref=secondSection.firstChild;
                            jQuery(ref).siblings().toggle(450,function(){
                                jQuery(ref).find("img").attr("src","resources/images/Arrows-"+(jQuery(ref).siblings().is(":visible") ? "Up" : "Down")+"-4-icon.png");
                                if((jQuery(ref).siblings().is(":visible")))
                                {
                                    ref.parentNode.scrollIntoView(false);  
                                }
                                var sectionState;
                                if(jQuery(ref).attr("state") == "collapsed")
                                {
                                sectionState="expanded";
                                jQuery(ref).attr("state","expanded"); 
                                }
                                else
                                {
                                    sectionState="collapsed";
                                    jQuery(ref).attr("state","collapsed");           
                                } 
                                if(window.onChangeSectionState)
                                    window.onChangeSectionState(jQuery(ref).parent().attr("id"),sectionState);
                                if(isTab==true){
                                    var tabli = control;
                                    while(tabli.id.indexOf("sheet")==-1){
                                        tabli = tabli.parentNode;
                                    }
                                    var children = tab.getElementsByTagName("a");
                                    for(var i=0;i<children.length;i++){
                                        if(children[i].href.indexOf("#"+tabli.id)!=-1){
                                            break;
                                        }
                                    }
                                    $('[href=#'+tabli.id+']').on('shown.bs.tab', function (e) {
                                        if(control!=null && control.tagName == "BUTTON"){
                                            control.setAttribute("autofocus","");
                                            control.focus();
                                        }
                                        else if(control.classList.contains("iform-radio")){
                                            checkedRadio =  getCheckedRadioRef(control);
                                            checkedRadio.focus();
                                        }
                                        else{
                                           if(control.getAttribute("combotype")=="listbox"){
                                                jQuery(control).parent().find("button").get(0).focus();
                                            }
                                            else
                                            {
                                                control.focus();
                                            }
                                        }
                                        //control.focus();
                                    });
                                    selectSheet(tab.id,i);
                                }
                                if(control!=null && control.tagName == "BUTTON"){
                                    control.setAttribute("autofocus","");
                                    control.focus();
                                }
                                else if(control.classList.contains("iform-radio")){
                                   checkedRadio =  getCheckedRadioRef(control);
                                   checkedRadio.focus();
                                }
                                else{
                                    if(control.getAttribute("combotype")=="listbox"){
                                        jQuery(control).parent().find("button").get(0).focus();
                                    }
                                    else
                                    {
                                        control.focus();
                                    }
                                }
                            }
                            );
                            var url = "action_API.jsp";
                            requestString = "frameId="+jQuery(ref).parent().attr("id")+"&frameState="+jQuery(ref).attr("state")+"&pid="+encode_utf8(pid)+"&wid="+encode_utf8(wid)+"&tid="+encode_utf8(tid)+"&fid="+encode_utf8(fid);
                            if( jQuery(ref).attr("painted")== undefined)
                                new net.ContentLoader(url, frameResponseHandler, frameErrorHandler, "POST", requestString, true);

                            return;
                        }
                        //toggleSection(secondSection.firstChild);
                    }
                    if(isTab==true){
                        var tabli = control;
                        while(tabli.id.indexOf("sheet")==-1){
                            tabli = tabli.parentNode;
                        }
                        var children = tab.getElementsByTagName("a");
                        for(var i=0;i<children.length;i++){
                            if(children[i].href.indexOf("#"+tabli.id)!=-1){
                                break;
                            }
                        }
                        $('[href=#'+tabli.id+']').on('shown.bs.tab', function (e) {
                            if(control!=null && control.tagName == "BUTTON"){
                                    control.setAttribute("autofocus","");
                                    control.focus();
                                }
                                else if(control.classList.contains("iform-radio")){
                                    checkedRadio =  getCheckedRadioRef(control);
                                    checkedRadio.focus();
                                }
                                else{
                                    if(control.getAttribute("combotype")=="listbox"){
                                        jQuery(control).parent().find("button").get(0).focus();
                                    }
                                    else
                                    {
                                        control.focus();
                                    }
                                }
                        });
                        selectSheet(tab.id,i);
                    }
                    if(control!=null && control.tagName == "BUTTON"){
                        control.setAttribute("autofocus","");
                        control.focus();
                    }
                    else if(control.classList.contains("iform-radio")){
                        checkedRadio =  getCheckedRadioRef(control);
                        checkedRadio.focus();
                    }
                    else{
                        if(control.getAttribute("combotype")=="listbox"){
                            jQuery(control).parent().find("button").get(0).focus();
                        }
                        else
                        {
                            control.focus();
                        }
                    }
                    return;
                }
                //toggleSection(section.firstChild);
            }
            if(isTab==true){
                var tabli = control;
                while(tabli.id.indexOf("sheet")==-1){
                    tabli = tabli.parentNode;
                }
                var children = tab.getElementsByTagName("a");
                for(var i=0;i<children.length;i++){
                    if(children[i].href.indexOf("#"+tabli.id)!=-1){
                        break;
                    }
                }
                $('[href=#'+tabli.id+']').on('shown.bs.tab', function (e) {
                    if(control!=null && control.tagName == "BUTTON"){
                        control.setAttribute("autofocus","");
                        control.focus();
                    }
                    else if(control.classList.contains("iform-radio")){
                        checkedRadio =  getCheckedRadioRef(control);
                        checkedRadio.focus();
                    }
                    else{
                        if(control.getAttribute("combotype")=="listbox"){
                            jQuery(control).parent().find("button").get(0).focus();
                        }
                        else
                        {
                            control.focus();
                        }
                    }
                });
                selectSheet(tab.id,i);
            }
        }



        if(control!=null && control.tagName == "BUTTON"){
            control.setAttribute("autofocus","");
            control.focus();
        }
        else if(control.classList.contains("iform-radio")){
            checkedRadio =  getCheckedRadioRef(control);
            checkedRadio.focus();
        }
        else{
            if(control.getAttribute("combotype")=="listbox"){
                jQuery(control).parent().find("button").get(0).focus();
            }
            else
            {
                control.focus();
            }
        }
        } 
    }

    function getCheckedRadioRef(radioRef){
        var buttons = document.getElementsByName(radioRef.id);
        var returnRef=buttons[0];
        for(var i=0;i<buttons.length;i++){
            if(buttons[i].checked){
                returnRef = buttons[i];
                break;
            }
        }
        return returnRef;
    }

    function clearTable(controlId,sync)
    {
        var url = "action_API.jsp";
        var table = document.getElementById(controlId);
        var deleterow = "";
        //table.innerHTML = "";
        if (table != null && table != undefined)
        {
            var rows = table.tBodies[0].children;
            var l = rows.length;
            while (l--) {
                deleterow += "y,";
            }
            var requestString = "controlId=" + controlId + "&deleteTableFlag=yes&deleterow=" + deleterow;
            if (sync == false)
                new net.ContentLoader(url, clearTableResponseHandler, ajaxFormErrorHandler, "POST", requestString, true);
            else if (sync == true) {
                clearTableHelper(controlId);
                iforms.ajax.processRequest(requestString, url);
            }
        }
    }

    function clearTableResponseHandler(){
        var tableId = getQueryVariable(this.params, "controlId");
        clearTableHelper(tableId);
    }

    function clearTableHelper(tableId){
        var table = document.getElementById(tableId);
        //table.innerHTML = "";
        var rows = table.tBodies[0].children;
        var l = rows.length;
        while(l--){
            table.tBodies[0].deleteRow(l);
        }
        var totalValueElements=document.getElementById('totallabel_'+tableId).innerHTML.split(",!,");
            for(var i=0;i<totalValueElements.length;i++){
            if(totalValueElements[i]!=''){
             $(document.getElementsByClassName(totalValueElements[i].replace(/&lt;/g, '<').replace(/&gt;/g, '>').replace(/&quot;/g, '"').replace(/&amp;/g, '&'))).each(function() {
                var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
            if((this.getAttribute("maskingpattern")!="nomasking" && this.getAttribute("maskingpattern")!="") || (typeofvalue=='Float' && this.getAttribute("maskingpattern")=="nomasking"))
            {
                    maskfield(this,'label');
            }
            });
            }
                showTotal('',totalValueElements[i]);
            }
    }
    function setFrameScroll(){
        try{
            if(window.parent.document.getElementById("theme:scrollPosFrame")!==null && window.parent.document.getElementById("theme:scrollPosFrame")){
                var scrollTop=parseInt(window.parent.document.getElementById("theme:scrollPosFrame").value);
                if (window.parent.document.getElementById('previewThemeFrame')!=='undefined' && window.parent.document.getElementById('previewThemeFrame')!==null)
                    window.parent.document.getElementById('previewThemeFrame').contentWindow.scrollTo(0,scrollTop);
            }
        }
        catch(e){}
    }


    //Bug 75529 Start
    function executeCommand(event,obj,jsonData){
        try{
            var jsonArray=JSON.parse(decode_utf8(jsonData));
            for(var i=0;i<jsonArray.length;i++){
                var jsonObject=jsonArray[i];
               
                if(jsonObject.command=='WFSave'){
                    if(window.parent.WFSave)
                        window.parent.WFSave();
                }
                else if(jsonObject.command=='WFDone'){
                    if(window.parent.WFDone)
                        window.parent.WFDone();
                }
                else if(jsonObject.command=='NGExportToPDF'){
					$(".iform-table").not('.floatThead-table').each(function(){
                       $(this).floatThead('destroy'); 
                       $(this).parent().css("overflow","hidden");
                    });
                    html2canvas(jQuery("#oforms_iform").get(0), 
                                {
                                    onrendered: function(canvas) 
                                    {
                                        var ngForm=jQuery("#oforms_iform");

                                        var objForm=document.createElement("form");
                                        objForm.style.display="none";
                                        //Bug 56066 - exportPDf should store the pdf at particular location in server 
                                        var location="";
                                        if( location == undefined || location == null || location == "undefined" )
                                            location = "";
                                        objForm.setAttribute("action","/webdesktop/servlet/DownloadPDF?FormName="+"pFileName"+"&tiffFlag="+"false"+"&location="+encodeURIComponent(location));
                                        objForm.method  = "post";
                                        objForm.name = "newForm";  

                                        var pdfCont=document.createElement("textarea");
                                        pdfCont.setAttribute("type","text");
                                        pdfCont.setAttribute("name","pdfCont")
                                        pdfCont.style.display="none";
                                        pdfCont.value=canvas.toDataURL();
                                        objForm.appendChild(pdfCont);

                                        var formWidth=document.createElement("input");
                                        formWidth.setAttribute("type","text");
                                        formWidth.setAttribute("name","formWidth")
                                        formWidth.style.display="none";

                                        //Bugzilla – Bug 47543                                
        //                                formWidth.value=parseInt(parseInt(ngForm.css("width"))+parseInt(jQuery(window).width())/10)+"px";
                                        formWidth.value=jQuery("#oforms_iform").width()+"px";

                                        objForm.appendChild(formWidth);

                                        var formHeight=document.createElement("input");
                                        formHeight.setAttribute("type","text");
                                        formHeight.setAttribute("name","formHeight")
                                        formHeight.style.display="none";
                                        formHeight.value=jQuery("#oforms_iform").height()+"px";
                                        objForm.appendChild(formHeight);

                                        document.body.appendChild(objForm);
                                        objForm.submit();
										$(".iform-table").not('.floatThead-table').each(function(){
                                            $(this).floatThead('reflow'); 
                                            $(this).parent().css("overflow","auto");
										});
                                    }
                                });
                }
                else if(jsonObject.command=='NGLaunchURL'){
                    window.open(jsonObject.parameters.URL, jsonObject.parameters.windowName, jsonObject.parameters.windowDecoration);
                }
                else if(jsonObject.command=='GetPickList'&&event.keyCode==114){
                    event.keyCode=0;
                    if(event.stopPropagation)
                    {
                        event.stopPropagation();
                        event.preventDefault();
                    }
                    else
                    {
                        event = window.event;
                        event.cancelBubble = true;
                    }
                    if(document.getElementById(obj.id+"_pickListbtn")!=null){
                        document.getElementById(obj.id+"_pickListbtn").click();
                    }
                }
                else if(jsonObject.command=='AutoComplete'){
                    var parameters=jsonObject.query;
                    getAutoCompleteData(parameters.query,parameters.cache,obj.id,parameters.likesearch,parameters.keycount);//Bug 76751
                }
                else if(jsonObject.command=='WFRefreshInterfaces'){
                    if(window.parent.ReloadInterfaces)
                        window.parent.ReloadInterfaces();
                }
                else if(jsonObject.command=='RouteCriteria'){
                    routeToNextForm(obj, jsonObject.parameters);
                }
                else if(jsonObject.command=='RouteJourney'){
                    routeToNavigation(obj, jsonObject.parameters);
                }
                else if(jsonObject.command=='ValidateOTP'){
                    validateOTP(obj, jsonObject.parameters);
                }
            }
        }
        catch(ex){}
    }
    //Bug 75529 End
    //Bug 76751 Start
    function getAutoCompleteData(query,cache,controlId,likesearch,keycount){
        likesearch=typeof likesearch=="undefined"?"true":likesearch;
        keycount=typeof keycount=="undefined"?"1":keycount;
        var url = "action_API.jsp";
        var isCache=(cache=="true");
        if(isCache){
            query = "getcachedquery="+query+"&syncFlag="+"false";
        }
        else{
            query="&getquery="+query+"&syncFlag="+"false";
        }
        query=query+"&controlId="+controlId+"&likeSearch="+likesearch+"&keyCount="+keycount;
        //if(document.getElementById(controlId).value.length==keycount-1){
           var jsonString = iforms.ajax.processRequest(query,url);
           getAutoCompleteDataHelper(jsonString,controlId,likesearch,keycount);
        //}
            //new net.ContentLoader(url, getAutoCompleteDataResponse, DBErrorHandler, "POST", query, true);
    }
   function getAutoCompleteDataHelper(jsonString,controlId,likeSearch,keyCount){
        try{
            var jsonObj = JSON.parse(jsonString);
            var dataArr=new Array();
            if(jsonObj[0]){
                for(var j=0;j<jsonObj[0].length;j++){
                    var textData = jsonObj[0][j];
                    for(var i=0;i<Object.keys(jsonObj).length-1;i++){
                        textData = textData+" | "+ jsonObj[i+1][j];
                    }
                    dataArr.push(textData);
                }
                if(likeSearch=="true"){
                    jQuery('#'+controlId ).autocomplete(
                    {
                        autoFocus : true ,
                        source:dataArr,
                        minLength:keyCount,
                        change: function( event, ui )
                        {
                            if(dataArr.indexOf($(this).val())==-1){
                                if(window.isAutoCompleteClearPreHook)
                                {
                                    if(isAutoCompleteClearPreHook(controlId))
                                    {
                                        $(this).val("");
                                    }
                                }
                                else
                                    $(this).val("");
                                isAutoCompleteSelected=true;
                                $(this).trigger("change");
                            }
                        },
                        close: function (event, ui)
                        {
                             $(this).val(event.target.value.split(" | ")[0]);
                        },
                        select: function(event, ui){
                            $(this).val(ui.item.value.split(" | ")[0]);
                            $(this).attr("AutoCompleteValue",ui.item.value);
                            isAutoCompleteSelected=true;
                            $(this).trigger("change");
                        },
                        open:function(event,ui){//Bug 82878 Start
                            $('.iform-table').not('.floatThead-table').each(function() {
                                $(this).floatThead('reflow');
                            });
                        }//Bug 82878 End
                    });
                }
                else{
                    jQuery('#'+controlId ).autocomplete(
                    {
                        autoFocus : true ,
                        source:function( request, response ) {
                            var matcher = new RegExp( "^" + jQuery.ui.autocomplete.escapeRegex( request.term ), "i" );
                            response( jQuery.grep( dataArr, function( item ){
                                return matcher.test( item );
                            }) );
                            dataArr=jQuery.grep( dataArr, function( item ){
                                return matcher.test( item );
                            });
                        },
                        minLength:keyCount,
                        change: function( event, ui )
                        {
                            if(dataArr.indexOf($(this).val())==-1){
                                if(window.isAutoCompleteClearPreHook)
                                {
                                    if(isAutoCompleteClearPreHook(controlId))
                                    {
                                        $(this).val("");
                                    }
                                }
                                else
                                    $(this).val("");
                                isAutoCompleteSelected=true;
                                $(this).trigger("change");
                            }
                        },
                        close: function (event, ui)
                        {
                             $(this).val(event.target.value.split(" | ")[0]);
                        },
                        select: function(event, ui){
                            $(this).val(ui.item.value.split(" | ")[0]);
                             $(this).attr("AutoCompleteValue",ui.item.value);
                            isAutoCompleteSelected=true;
                            $(this).trigger("change");
                        },
                        open:function(event,ui){//Bug 82878 Start
                            $('.iform-table').not('.floatThead-table').each(function() {
                                $(this).floatThead('reflow');
                            });
                        }//Bug 82878 End
                    });
                }
            }
        }
        catch(ex){}
    }
    function getAutoCompleteDataResponse(){
        var jsonString = this.req.responseText;
        var controlId=getQueryVariable(this.params, "controlId");
        var likeSearch=getQueryVariable(this.params, "likeSearch");
        var keyCount=getQueryVariable(this.params, "keyCount");
        getAutoCompleteDataHelper(jsonString, controlId, likeSearch, keyCount);
    }
    function setTileDataFromDB(tileID , jsonObject){
        var value = "";
        if(tileDataModified == false){
            for(var i = 0 ; i < Object.keys(jsonObject).length ; i++){
               for(var j = 0 ; j < jsonObject[i].length ; j++){
                   value = jsonObject[i][j];
                   jQuery('#' + tileID).find(".tile-list").append('<li class="tile-list-item">' + value + '</li>');
               }
            }
        }
        tileDataModified = true;
    }
    
    //Bug 76751 End
    //Bug 75527 Start
    //Bug 76765
    function getDBLinkingEventData(event,controls,sync,index,controlId){
        var url = "action_API.jsp";
        var query="";
        /*if(isCaching){
            query = "getcachedquery="+cacheRequestString+"&syncFlag="+sync;
        }
        else{
            query="&getquery="+cacheRequestString+"&syncFlag="+sync;
        }
        */
        query="DBLinkingEvent="+event+"&DBLinkingControl="+controlId+"&Index="+index+"&syncFlag="+sync;
        //Bug 76765
        query=query+"&controls="+controls.toString();//+"&CS="+checksum;
        if(sync==false)
            var contentLoaderRef = new net.ContentLoader(url, setDataInControlsHandler, DBErrorHandler, "POST", query, true);
        else if(sync==true){
            try{
                var jsonObj = JSON.parse(iforms.ajax.processRequest(query,url));
                var json={};
                if(jsonObj[0]==null){
                    for(var i=0;i<controls.split(",").length;i++){
                        var objComp = document.getElementById(controls.split(",")[i]);
                        if(objComp==null)
                        {
                            objComp =  document.getElementsByName(controls.split(",")[i])[0];
                        }
                        if((objComp.type=='text' && objComp.classList.contains("editableCombo")) || objComp.type=='select-one' || objComp.type=='ComboBox' || objComp.type=='select-multiple'){
                            populateComboValuesfromString(controls.split(",")[i],{});
                        }
                        else{
                            json[controls.split(",")[i]] =  "";
                        }
                    }
                    setValues(json,true);                
                }
                if(controls.split(",").length==1 && Object.keys(jsonObj).length==2){
                        populateComboValuesfromString(controls.split(",")[0],jsonObj[0],jsonObj[1]);
                }
                else{
                    for(var i=0;i<controls.split(",").length;i++){
                        if(jsonObj[i]==null)
                            break;
                        var objComp = document.getElementById(controls.split(",")[i]);
                        if(objComp==null)
                        {
                            objComp =  document.getElementsByName(controls.split(",")[i])[0];
                        }
                        if((objComp.type=='text' && objComp.classList.contains("editableCombo")) || objComp.type=='select-one' || objComp.type=='ComboBox' || objComp.type=='select-multiple'){
                            populateComboValuesfromString(controls.split(",")[i],jsonObj[i]);
                        } else if ( jQuery('#'+controls.split(",")[i]).attr("type")=='ListView' || jQuery('#'+controls.split(",")[i]).attr("type")=='Table' ){
                            if(jQuery('#'+controls.split(",")[i]).find("tbody").children()!=undefined && jQuery('#'+controls.split(",")[i]).find("tbody").children().length==0)
                               renderExecuteServerEventAPIData(jsonObj);
                        } else if ( jQuery('#'+controls.split(",")[i]).attr("type")=='tile' ){
                            setTileDataFromDB(controls.split(",")[i],jsonObj);
                        } else {
                            json[controls.split(",")[i]] =  jsonObj[i][0];
                        }
                    }
                    setValues(json,true);
                }
            }
            catch(ex){}

          if( window.postHookDBLink ){ 
                        var control = document.getElementById(controlId);
                        if(useCustomIdAsControlName && (control==null || control==undefined)){
                            control = document.getElementsByName(controlId)[0];
                            if(control != null && control != undefined)
                                controlId = control.getAttribute("id");
                        }       
	                postHookDBLink(controlId , event , index ,controlId);
	            }
            }
        }

    function executeDBLinking(event,controlId,jsonData,isKeyDown){
        try{
            var jsonArray=JSON.parse(decode_utf8(jsonData));
            if(isKeyDown){
                if(event.keyCode==112){
                    for(var i=0;i<jsonArray.length;i++){
                        var jsonObj=jsonArray[i];
                        if(jsonObj.eventType=="KeyPressF1"){
                            var tempJsonArray=jsonObj.DBLinkingArray;
                            for(var j=0;j<tempJsonArray.length;j++){
                                var jsonObjtemp=tempJsonArray[j];
                                //Bug 76765
                                getDBLinkingEventData(jsonObjtemp.event,jsonObjtemp.controls,true,jsonObjtemp.index,controlId);
                            }
                            break;
                        }
                    }
                }
                else if(event.keyCode==113){
                    for(i=0;i<jsonArray.length;i++){
                        jsonObj=jsonArray[i];
                        if(jsonObj.eventType=="KeyPressF2"){
                            tempJsonArray=jsonObj.DBLinkingArray;
                            for(j=0;j<tempJsonArray.length;j++){
                                jsonObjtemp=tempJsonArray[j];
                                //Bug 76765
                                getDBLinkingEventData(jsonObjtemp.event,jsonObjtemp.controls,true,jsonObjtemp.index,controlId);
                            }
                            break;
                        }
                    }
                }
                else if(event.keyCode==114){
                    for(i=0;i<jsonArray.length;i++){
                        jsonObj=jsonArray[i];
                        if(jsonObj.eventType=="KeyPressF3"){
                            tempJsonArray=jsonObj.DBLinkingArray;
                            for(j=0;j<tempJsonArray.length;j++){
                                jsonObjtemp=tempJsonArray[j];
                                //Bug 76765
                                getDBLinkingEventData(jsonObjtemp.event,jsonObjtemp.controls,true,jsonObjtemp.index,controlId);
                            }
                            break;
                        }
                    }
                }
                else if(event.keyCode==115){
                    for(i=0;i<jsonArray.length;i++){
                        jsonObj=jsonArray[i];
                        if(jsonObj.eventType=="KeyPressF4"){
                            tempJsonArray=jsonObj.DBLinkingArray;
                            for(j=0;j<tempJsonArray.length;j++){
                                jsonObjtemp=tempJsonArray[j];
                                //Bug 76765
                                getDBLinkingEventData(jsonObjtemp.event,jsonObjtemp.controls,true,jsonObjtemp.index,controlId);
                            }
                            break;
                        }
                    }
                }
                else if(event.keyCode==116){
                    for(i=0;i<jsonArray.length;i++){
                        jsonObj=jsonArray[i];
                        if(jsonObj.eventType=="KeyPressF5"){
                            tempJsonArray=jsonObj.DBLinkingArray;
                            for(j=0;j<tempJsonArray.length;j++){
                                jsonObjtemp=tempJsonArray[j];
                                //Bug 76765
                                getDBLinkingEventData(jsonObjtemp.event,jsonObjtemp.controls,true,jsonObjtemp.index,controlId);
                            }
                            break;
                        }
                    }
                }
                else if(event.keyCode==117){
                    for(i=0;i<jsonArray.length;i++){
                        jsonObj=jsonArray[i];
                        if(jsonObj.eventType=="KeyPressF6"){
                            tempJsonArray=jsonObj.DBLinkingArray;
                            for(j=0;j<tempJsonArray.length;j++){
                                jsonObjtemp=tempJsonArray[j];
                                //Bug 76765
                                getDBLinkingEventData(jsonObjtemp.event,jsonObjtemp.controls,true,jsonObjtemp.index,controlId);
                            }
                            break;
                        }
                    }
                }
                else if(event.keyCode==118){
                    for(i=0;i<jsonArray.length;i++){
                        jsonObj=jsonArray[i];
                        if(jsonObj.eventType=="KeyPressF7"){
                            tempJsonArray=jsonObj.DBLinkingArray;
                            for(j=0;j<tempJsonArray.length;j++){
                                jsonObjtemp=tempJsonArray[j];
                                //Bug 76765
                                getDBLinkingEventData(jsonObjtemp.event,jsonObjtemp.controls,true,jsonObjtemp.index,controlId);
                            }
                            break;
                        }
                    }
                }
                else if(event.keyCode==119){
                    for(i=0;i<jsonArray.length;i++){
                        jsonObj=jsonArray[i];
                        if(jsonObj.eventType=="KeyPressF8"){
                            tempJsonArray=jsonObj.DBLinkingArray;
                            for(j=0;j<tempJsonArray.length;j++){
                                jsonObjtemp=tempJsonArray[j];
                                //Bug 76765
                                getDBLinkingEventData(jsonObjtemp.event,jsonObjtemp.controls,true,jsonObjtemp.index,controlId);
                            }
                            break;
                        }
                    }
                }
                else if(event.keyCode==120){
                    for(i=0;i<jsonArray.length;i++){
                        jsonObj=jsonArray[i];
                        if(jsonObj.eventType=="KeyPressF9"){
                            tempJsonArray=jsonObj.DBLinkingArray;
                            for(j=0;j<tempJsonArray.length;j++){
                                jsonObjtemp=tempJsonArray[j];
                                //Bug 76765
                                getDBLinkingEventData(jsonObjtemp.event,jsonObjtemp.controls,true,jsonObjtemp.index,controlId);
                            }
                            break;
                        }
                    }
                }
                else if(event.keyCode==121){
                    for(i=0;i<jsonArray.length;i++){
                        jsonObj=jsonArray[i];
                        if(jsonObj.eventType=="KeyPressF10"){
                            tempJsonArray=jsonObj.DBLinkingArray;
                            for(j=0;j<tempJsonArray.length;j++){
                                jsonObjtemp=tempJsonArray[j];
                                //Bug 76765
                                getDBLinkingEventData(jsonObjtemp.event,jsonObjtemp.controls,true,jsonObjtemp.index,controlId);
                            }
                            break;
                        }
                    }
                }
                else if(event.keyCode==122){
                    for(i=0;i<jsonArray.length;i++){
                        jsonObj=jsonArray[i];
                        if(jsonObj.eventType=="KeyPressF11"){
                            tempJsonArray=jsonObj.DBLinkingArray;
                            for(j=0;j<tempJsonArray.length;j++){
                                jsonObjtemp=tempJsonArray[j];
                                //Bug 76765
                                getDBLinkingEventData(jsonObjtemp.event,jsonObjtemp.controls,true,jsonObjtemp.index,controlId);
                            }
                            break;
                        }
                    }
                }
                else if(event.keyCode==123){
                    for(i=0;i<jsonArray.length;i++){
                        jsonObj=jsonArray[i];
                        if(jsonObj.eventType=="KeyPressF12"){
                            tempJsonArray=jsonObj.DBLinkingArray;
                            for(j=0;j<tempJsonArray.length;j++){
                                jsonObjtemp=tempJsonArray[j];
                                //Bug 76765
                                getDBLinkingEventData(jsonObjtemp.event,jsonObjtemp.controls,true,jsonObjtemp.index,controlId);
                            }
                            break;
                        }
                    }
                }
                else{
                    for(i=0;i<jsonArray.length;i++){
                        jsonObj=jsonArray[i];
                        if(jsonObj.eventType=="KeyDown"){
                            tempJsonArray=jsonObj.DBLinkingArray;
                            for(j=0;j<tempJsonArray.length;j++){
                                jsonObjtemp=tempJsonArray[j];
                                //Bug 76765
                                getDBLinkingEventData(jsonObjtemp.event,jsonObjtemp.controls,true,jsonObjtemp.index,controlId);
                            }
                            break;
                        }
                    }
                }
            }
            else{
            for(i=0;i<jsonArray.length;i++){
                jsonObj=jsonArray[i];
                //Bug 76765
                getDBLinkingEventData(jsonObj.event,jsonObj.controls,true,jsonObj.index,controlId);
            }
            }
        }
        catch(ex){}
    }

     function populateComboValuesfromString(controlName,controlLabel,controlValue, isformLoad ){
        var control = document.getElementById(controlName);
        if(useCustomIdAsControlName && (control==null || control==undefined)){
            control = document.getElementsByName(controlName)[0];
            if(control != null && control != undefined)
                controlId = control.getAttribute("id");
        }
        var isClear = true;
        var selectedValue = jQuery('#'+controlName).val(); //Bug 88930
        if((jQuery('#'+controlName).is(':visible')) && selectedValue==undefined && selectedValue==""){
            selectedValue = "";                            //Bug 88930
        }
        if(window.clearComboItems && !window.clearComboItems(controlName)){
            isClear=false;
        }
        var clearComboOnLoad = false;
        if( window.clearComboOnLoad && !window.clearComboOnLoad(controlName) ){
            clearComboOnLoad = true;
        }
        
        if( (typeof isformLoad=='undefined') || clearComboOnLoad ){
        if(isClear)
            clearValue(controlName, true);
        if(isClear){
        if(document.getElementById(controlName).type== "text"){
            var ul = document.getElementById(controlName).parentNode.childNodes[2];
            ul.innerHTML='';
        }
        else
            document.getElementById(controlName).options.length = 0;
        }
    }
        var i;
        if(isClear && !(document.getElementById(controlName).type=='select-multiple')){
            addItemInCombo(controlName,SELECT,"");
        }
        if(typeof controlValue=='undefined'){
            for(i=0;i<controlLabel.length;i++){
                addItemInCombo(controlName, controlLabel[i],controlLabel[i],controlLabel[i]);
            }
        }
        else{
            for(i=0;i<controlLabel.length;i++){
                addItemInCombo(controlName, controlLabel[i],controlValue[i],controlLabel[i]);
            }
        }
        if(isClear && document.getElementById(controlName).type!="select-multiple" && !isformLoad && selectedValue=="")
            document.getElementById(controlName).value= document.getElementById(controlName).options[0].value;
            else
            jQuery('#'+controlName).val(selectedValue);      //Bug 88930
    }
    //Bug 75527 End
    function showTotal(ref,elementClass){
        //jQuery('.'+elementClass+'_total').autoNumeric('destroy');
        var total=0;
        var isDGroup=false;
        var digitGroup="";
        var maskingPattern="";
        elementClass=elementClass.replace(/&lt;/g, '<').replace(/&gt;/g, '>').replace(/&quot;/g, '"').replace(/&amp;/g, '&');
        var precision;
        if(elementClass!=""){
            $(document.getElementsByClassName(elementClass)).each(function() {
                var val = this.value;
                if(val==undefined)
                    val = this.innerHTML;
                digitGroup = parseInt(this.className.substring(this.className.indexOf("dgroup_")).split("_")[3]);
                if(this.className.indexOf('dgroup')!=-1){
                    isDGroup=true;
                    val = val.replace (/,/g, "");
                }
                if(this.getAttribute("maskingpattern")!=undefined && this.getAttribute("maskingpattern")!='' && this.getAttribute("maskingpattern")!='nomasking' ){
                    val = jQuery(this).autoNumeric('get');
                }
                var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
            if((this.getAttribute("maskingpattern")!="nomasking" && this.getAttribute("maskingpattern")!="")
                || (typeofvalue=='Float' && this.getAttribute("maskingpattern")=="nomasking"))
                {
                val = jQuery(this).autoNumeric('get');
            }
                 if( this.parentNode.parentNode.style.display!='none'){
                    if(this.innerHTML){
                        if(parseFloat(val))
                            total=total+parseFloat(val);
                    }
                    else{
                        if(parseFloat(val))
                            total=total+parseFloat(val);
                    }
                }
                if(this.getAttribute("precision")!=null && this.getAttribute("precision")!=undefined && this.getAttribute("precision")!='')
                    precision = this.getAttribute("precision");
                maskingPattern = this.getAttribute("maskingpattern");
            });
            var totalElement = document.getElementsByClassName(elementClass+'_total')[0];
            if(precision!=undefined && (parseInt(precision) > 0) && (maskingPattern!='NZP' || isFloat(total)))
                total = total.toFixed(parseInt(precision));
            totalElement.innerHTML = total;


            if(isDGroup){
                jQuery('.'+elementClass+'_total').autoNumeric('init',{
                    dGroup: digitGroup,
                    mDec: '2'
                }); 
               jQuery('.'+elementClass+'_total').autoNumeric('destroy');

            }
            
            var typeofvalue=typeof totalElement.getAttribute("typeofvalue")=='undefined'?'':totalElement.getAttribute("typeofvalue");
            if((totalElement.getAttribute("maskingpattern")!="nomasking" && totalElement.getAttribute("maskingpattern")!="")
            || (typeofvalue=='Float' && totalElement.getAttribute("maskingpattern")=="nomasking"))
            {
               totalElement.setAttribute("maskingpattern",maskingPattern);
                maskfield(totalElement,'label');
            }


        //var num = jQuery(total).replace(/,/gi, "");
        //        if(isDGroup){
        //            var groupedVal="";
        //           if(digitGroup==2){
        //                groupedVal = total.toString().split(/(?=(?:\d{2})+$)/).join(",");
        //           }
        //           else{
        //                 groupedVal = total.toString().split(/(?=(?:\d{3})+$)/).join(",");
        //           }
        //            
        //             document.getElementsByClassName(elementClass+'_total')[0].innerHTML=groupedVal;
        //        }
        //         else{
        //              document.getElementsByClassName(elementClass+'_total')[0].innerHTML=total
        //         }


    }
    }
    
function isFloat(n){
    return Number(n) === n && n % 1 !== 0;
}

function makeComboEditable(ref)
{
    //Bug 76778
    if(isEditableComboOnLoad=="true"){
        $(ref).editableSelect({
            filter: true
        });
    }
    else{
        var onchangeAttribute = ref.getAttribute("onchange");
        $(ref).editableSelect({
            filter: true
        }).on('select.editable-select', function (e) {
            if(e.target.tagName=="SELECT"){
                eval(onchangeAttribute);
            }
        });
    }
}
 
    //Bug 76775 End

    function clearCombo(ref){
        if(ref.value==SELECT){
            $(ref).val("");
            $(ref).editableSelect('filter');
        }
    }

    function setDefaultComboValue(ref){
         if(ref.value==""){
            $(ref).val("Select");
            //$(ref).editableSelect('filter');
        }
    }

    function executeCustomEvent(event,obj,jsonData){
        try{
            var jsonArray=JSON.parse(decode_utf8(jsonData));
            if(event.keyCode==112){
                for(var i=0;i<jsonArray.length;i++){
                    var jsonObj=jsonArray[i];
                    if(jsonObj.eventType=="KeyPressF1"){
                        if(typeof jsonObj.ServerEvent !="undefined"){
                            makeAjaxCall(obj.id,jsonObj.eventType);
                        }
                        if(typeof jsonObj.customString !="undefined"){
                            if(window[jsonObj.customString]){
                                window[jsonObj.customString](obj,event);
                            }
                        }
                        break;
                    }
                }
            }
            else if(event.keyCode==113){
                for(var i=0;i<jsonArray.length;i++){
                    var jsonObj=jsonArray[i];
                    if(jsonObj.eventType=="KeyPressF2"){
                        if(typeof jsonObj.ServerEvent !="undefined"){
                            makeAjaxCall(obj.id,jsonObj.eventType);
                        }
                        if(typeof jsonObj.customString !="undefined"){
                            if(window[jsonObj.customString]){
                                window[jsonObj.customString](obj,event);
                            }
                        }
                        break;
                    }
                }
            }
            else if(event.keyCode==114){
                for(var i=0;i<jsonArray.length;i++){
                    var jsonObj=jsonArray[i];
                    if(jsonObj.eventType=="KeyPressF3"){
                        if(typeof jsonObj.ServerEvent !="undefined"){
                            makeAjaxCall(obj.id,jsonObj.eventType);
                        }
                        if(typeof jsonObj.customString !="undefined"){
                            if(window[jsonObj.customString]){
                                window[jsonObj.customString](obj,event);
                            }
                            event.preventDefault();
                        }
                        break;
                    }
                }
            }
            else if(event.keyCode==115){
                for(var i=0;i<jsonArray.length;i++){
                    var jsonObj=jsonArray[i];
                    if(jsonObj.eventType=="KeyPressF4"){
                        if(typeof jsonObj.ServerEvent !="undefined"){
                            makeAjaxCall(obj.id,jsonObj.eventType);
                        }
                        if(typeof jsonObj.customString !="undefined"){
                            if(window[jsonObj.customString]){
                                window[jsonObj.customString](obj,event);
                            }
                        }
                        break;
                    }
                }
            }
            else if(event.keyCode==116){
                for(var i=0;i<jsonArray.length;i++){
                    var jsonObj=jsonArray[i];
                    if(jsonObj.eventType=="KeyPressF5"){
                        if(typeof jsonObj.ServerEvent !="undefined"){
                            makeAjaxCall(obj.id,jsonObj.eventType);
                        }
                        if(typeof jsonObj.customString !="undefined"){
                            if(window[jsonObj.customString]){
                                window[jsonObj.customString](obj,event);
                            }
                        }
                        break;
                    }
                }
            }
            else if(event.keyCode==117){
                for(var i=0;i<jsonArray.length;i++){
                    var jsonObj=jsonArray[i];
                    if(jsonObj.eventType=="KeyPressF6"){
                        if(typeof jsonObj.ServerEvent !="undefined"){
                            makeAjaxCall(obj.id,jsonObj.eventType);
                        }
                        if(typeof jsonObj.customString !="undefined"){
                            if(window[jsonObj.customString]){
                                window[jsonObj.customString](obj,event);
                            }
                        }
                        break;
                    }
                }
            }
            else if(event.keyCode==118){
                for(var i=0;i<jsonArray.length;i++){
                    var jsonObj=jsonArray[i];
                    if(jsonObj.eventType=="KeyPressF7"){
                        if(typeof jsonObj.ServerEvent !="undefined"){
                            makeAjaxCall(obj.id,jsonObj.eventType);
                        }
                        if(typeof jsonObj.customString !="undefined"){
                            if(window[jsonObj.customString]){
                                window[jsonObj.customString](obj,event);
                            }
                        }
                        break;
                    }
                }
            }
            else if(event.keyCode==119){
                for(var i=0;i<jsonArray.length;i++){
                    var jsonObj=jsonArray[i];
                    if(jsonObj.eventType=="KeyPressF8"){
                        if(typeof jsonObj.ServerEvent !="undefined"){
                            makeAjaxCall(obj.id,jsonObj.eventType);
                        }
                        if(typeof jsonObj.customString !="undefined"){
                            if(window[jsonObj.customString]){
                                window[jsonObj.customString](obj,event);
                            }
                        }
                        break;
                    }
                }
            }
            else if(event.keyCode==120){
                for(var i=0;i<jsonArray.length;i++){
                    var jsonObj=jsonArray[i];
                    if(jsonObj.eventType=="KeyPressF9"){
                        if(typeof jsonObj.ServerEvent !="undefined"){
                            makeAjaxCall(obj.id,jsonObj.eventType);
                        }
                        if(typeof jsonObj.customString !="undefined"){
                            if(window[jsonObj.customString]){
                                window[jsonObj.customString](obj,event);
                            }
                        }
                        break;
                    }
                }
            }
            else if(event.keyCode==121){
                for(var i=0;i<jsonArray.length;i++){
                    var jsonObj=jsonArray[i];
                    if(jsonObj.eventType=="KeyPressF10"){
                        if(typeof jsonObj.ServerEvent !="undefined"){
                            makeAjaxCall(obj.id,jsonObj.eventType);
                        }
                        if(typeof jsonObj.customString !="undefined"){
                            if(window[jsonObj.customString]){
                                window[jsonObj.customString](obj,event);
                            }
                        }
                        break;
                    }
                }
            }
            else if(event.keyCode==122){
                for(var i=0;i<jsonArray.length;i++){
                    var jsonObj=jsonArray[i];
                    if(jsonObj.eventType=="KeyPressF11"){
                        if(typeof jsonObj.ServerEvent !="undefined"){
                            makeAjaxCall(obj.id,jsonObj.eventType);
                        }
                        if(typeof jsonObj.customString !="undefined"){
                            if(window[jsonObj.customString]){
                                window[jsonObj.customString](obj,event);
                            }
                        }
                        break;
                    }
                }
            }
            else if(event.keyCode==123){
                for(var i=0;i<jsonArray.length;i++){
                    var jsonObj=jsonArray[i];
                    if(jsonObj.eventType=="KeyPressF12"){
                        if(typeof jsonObj.ServerEvent !="undefined"){
                            makeAjaxCall(obj.id,jsonObj.eventType);
                        }
                        if(typeof jsonObj.customString !="undefined"){
                            if(window[jsonObj.customString]){
                                window[jsonObj.customString](obj,event);
                            }
                        }
                        break;
                    }
                }
            }
            else{
                for(var i=0;i<jsonArray.length;i++){
                    var jsonObj=jsonArray[i];
                    if(jsonObj.eventType=="KeyDown"){
                        if(typeof jsonObj.ServerEvent !="undefined"){
                            makeAjaxCall(obj.id,jsonObj.eventType);
                        }
                        if(typeof jsonObj.customString !="undefined"){
                            if(window[jsonObj.customString]){
                                window[jsonObj.customString](obj,event);
                            }
                        }
                        break;
                    }
                }
            }
        }
        catch(ex){}
    }
    //Bug 76775 End

   function onTabClick(sheetID,ref,tabId,sheetindex,eventCall)
    {
        if( eventCall === 1 && !ref.parentNode.classList.contains("active"))
		jQuery("#"+tabId).find(".tab-content").children().removeClass("active").removeClass("in");
		if(ref.getAttribute("collapsed")!=null){
            LoadTab(ref,tabId,sheetID,sheetindex,"N");
        }
        else{
        if(window.onClickTab)
            window.onClickTab(tabId,sheetindex,eventCall);
    }
    }

    function LoadTab(ref,tabID,sheetID,sheetIndex,reloadFlag){
        ref.removeAttribute("collapsed");
        var url = "action_API.jsp";
        var requestString = "tabID="+tabID+"&sheetID="+sheetID+"&sheetIndex="+sheetIndex+"&tabState=collapsed&reloadTab="+reloadFlag+"&pid="+encode_utf8(pid)+"&wid="+encode_utf8(wid)+"&tid="+encode_utf8(tid)+"&fid="+encode_utf8(fid);
        new net.ContentLoader(url, tabResponseHandler, frameErrorHandler, "POST", requestString, false);
    }
    function tabResponseHandler(){
        $(".iform-table").floatThead('reflow');
        var tabhtml = this.req.responseText.trim();
        var tabid = getQueryVariable(this.params, "tabID");
        var sheetId=getQueryVariable(this.params, "sheetID");
        var sheetIndex=getQueryVariable(this.params, "sheetIndex");
        //   HandleProgressBar(data);
        var parentNode=document.getElementById(sheetId);
        parentNode.innerHTML="";
        // Sometimes WD_RID set in HTTP Response Header  is not being returned in client response
		/*var rid = this.req.getResponseHeader("WD_RID");
		if(rid == null){
			var templateS = "<if_rid style='display:none'>";
			var templateE = "</if_rid>";
			var indexFrom = tabhtml.indexOf(templateS);
			if(indexFrom >= 0){				
				rid = tabhtml.substring(indexFrom+templateS.length, tabhtml.indexOf(templateE));
				jQuery("#rid_ActionAPI").val(rid);
			}
		}*/
		// -----------------
        jQuery(parentNode).html(tabhtml);   
        // Sometimes WD_RID set in HTTP Response Header  is not being returned in client response
		/*var templateRef = document.getElementsByTagName("if_rid");
		if(templateRef && templateRef.length > 0){
			templateRef = templateRef[0];
			if(templateRef.parentNode){
				templateRef.parentNode.removeChild(templateRef);
			}
		}*/
		// -----------------
        doInit();
        if(window.onClickTab)
            window.onClickTab(tabid,sheetIndex);
    }

    function saveSection(sectionId)
    {
        if (document.getElementById(sectionId) != null && document.getElementById(sectionId) != undefined)
        {
            var url = "action_API.jsp";
            var requestString = "frameId=" + sectionId + "&frameState=expanded&pid=" + encode_utf8(pid) + "&wid=" + encode_utf8(wid) + "&tid=" + encode_utf8(tid) + "&fid=" + encode_utf8(fid);
            saveRichTextEditorData();
            var responseData = iforms.ajax.processRequest(requestString, url).trim();
            if(responseData!="0")
                showMessage("", responseData, "error");
            return responseData;
        }
    }
       function floatLabel(ref){

           if($(ref).attr('datatype')=='date' ||$(ref).attr('datatype')=='Text'  ){

            if($(ref).val().length > 0) {
                $(ref).addClass('input-focus');
                $(ref).next('.form-label').addClass('input-focus-label');
            }
            else {
                $(ref).removeClass('input-focus');
                $(ref).next('.form-label').removeClass('input-focus-label');

            }
           }

           else if($(ref).attr('datatype')=='textarea' ){

            if($(ref).val().length > 0) {
                $(ref).addClass('textarea-focus');
                $(ref).next('.form-label').addClass('textarea-focus-label');
            }
            else {
                $(ref).removeClass('textarea-focus');
                $(ref).next('.form-label').removeClass('textarea-focus-label');

            }
           }
        }
        function formatJSONValue(value){
            try{
                return value.replace(/\\"/g,'\\"');
            }
            catch(ex){
                return value;
            }
        }


       function cancelBubbling(e) {
        if (!e) e = window.event;
        e.cancelBubble = true;
        if (e.stopPropagation) e.stopPropagation();
        }

    
	function setTableCellDataHelper(tableId,rowIndex,colIndex,cellData)
	{
                if(getValueFromTableCell(tableId, rowIndex, colIndex)!= cellData){
                     setTableModifiedFlag(tableId);
                }
		var table = document.getElementById(tableId);
		if(table==null)
		{
			table = document.getElementsByName(tableId)[0];
		}
		var row = table.tBodies[0].getElementsByTagName('tr')[rowIndex];
		
		
		var col;

		if(row.getElementsByTagName("td")[parseInt(colIndex)+1])
		{
			col = row.getElementsByTagName("td")[parseInt(colIndex)+1];
		}
		else
			return;
		
		var control = col.getElementsByClassName("control-class")[0];
                if( control == undefined ){
                    col.innerHTML = encode_ParamValue(cellData);
                }
		if(control.classList.contains('listviewlabel')){
                    if(control.getAttribute("maskingPattern")!=null && control.getAttribute("maskingPattern")!='undefined'
                                && control.getAttribute("maskingPattern").toString()!='nomasking'&&control.getAttribute("maskingPattern").toString()!=''){ //85746
                                applyMaskingValue(control,cellData);
                    }
                    else
                            control.innerHTML = encode_ParamValue(escapeStringForHTML(cellData));
		}
		else{
			if(control.getAttribute("type")=="checkbox" || control.getAttribute("type")=="radio"){
				control.checked = cellData;
			}
			else if(control.tagName=="LABEL" || control.tagName=="A" || control.tagName=="TEXTAREA"){//Bug 83906 
				control.innerHTML = encode_ParamValue(escapeStringForHTML(cellData));
			}
                        else if(control.tagName=="IMG"){
                           control.src= "/iforms/GetImage?imagePath="+encode_utf8("IFormDirectory/Images/"+cellData);
                        }
                        else if(control.getAttribute("maskingPattern")!=null && control.getAttribute("maskingPattern")!='undefined'
                                && control.getAttribute("maskingPattern").toString()!='nomasking'&&control.getAttribute("maskingPattern").toString()!=''){ //85746
                                applyMaskingValue(control,cellData);
                        }
			else{
				control.value = cellData;
                        }
		}
		var totalValueElements = document.getElementById('totallabel_'+tableId).innerHTML.split(",!,");
		for(var i=0;i<totalValueElements.length;i++)
		{

			showTotal('',totalValueElements[i]);
		}

	}


    function setTableCellData(tableId,rowIndex,colIndex,cellData,sync)
    {
        // var table = document.getElementById(tableId);
        if (document.getElementById(tableId) != null && document.getElementById(tableId) != undefined)
        {
            if(colIndex >= 0 )
            { 
                var url = "action_API.jsp";
                var requestString = "setTableCellDataFlag=yes&tableId=" + tableId + "&rowIndex=" + rowIndex + "&colIndex=" + colIndex + "&cellData=" + encode_utf8(cellData)+"&pid="+encode_utf8(pid)+"&wid="+encode_utf8(wid)+"&tid="+encode_utf8(tid)+"&fid="+encode_utf8(fid);//Bug 84470

                if (sync == false) {
                    new net.ContentLoader(url, setTableCellDataHandler, setTableCellDataErroHandler, "POST", requestString, true);
                } else if (sync == true) {
                    iforms.ajax.processRequest(requestString, url);
                    setTableCellDataHelper(tableId, rowIndex, colIndex, cellData);
                }
            }
        }
    }

    function setTableCellDataHandler(){
         var rowIndex = getQueryVariable(this.params, "rowIndex");//Bug 81231
        var colIndex = getQueryVariable(this.params, "colIndex");//Bug 81231
        var cellData = getQueryVariable(this.params, "cellData");//Bug 81231
        var tableId = getQueryVariable(this.params, "tableId");
        setTableCellDataHelper(tableId,rowIndex,colIndex,cellData);

    }


    function setTableCellDataErroHandler(){

    }

    function setCustomMandatoryMsg(controlId,customMsg){
        var controlMsgRef = document.getElementById(controlId+"_msg");
        if(controlMsgRef!=null && controlMsgRef!=undefined){
            controlMsgRef.innerHTML = customMsg;
        }
    }
    function clearComboOptions(controlName,isClear){
        var control=document.getElementById(controlName);
        if(useCustomIdAsControlName && (control==null || control==undefined )){
            control = document.getElementsByName(controlName)[0];
            controlName = control.getAttribute("id");
        }
        if(control.tagName!="SELECT"){
            var fieldElements = document.getElementsByName(controlName);
            for(var i=0;i<fieldElements.length;i++)
            {
                if(fieldElements[i].tagName == "SELECT")
                    control=document.getElementsByName(controlName)[i];
            }
        } 
        if(control!=null && control !=undefined)
        {
            if(control.type=='select-one' || control.type=='ComboBox' || control.type=='select-multiple' || control.getAttribute("datatype") == "combobox"){
                if(isClear==null || isClear==undefined || isClear==true)
                    clearValue(controlName, true);
              //  control.options.length = 0;
                if(control.type== "text"){
                     var ul = control.parentNode.childNodes[2];
                     ul.innerHTML='';
                }else
                     control.options.length = 0;
                if(control.type!="select-multiple")
                    addItemInCombo(controlName,"Select","");
                else{
                    reloadListBoxLayout(controlName);
                   
                }
                if(control.type!="select-multiple" && control.type!="text")
                    control.value= control.options[0].value;
                 if(control.type== "text"){
                     control.title=ul.childNodes[0].innerHTML;
                     control.value=ul.childNodes[0].innerHTML;
                 }            
            }
        }
    }

    function openSubForms(buttonId){
        if(window.subFormPreHook){
            if(!subFormPreHook(buttonId)){
                return;
            }
        }
        
        if(mobileMode=="ios"||mobileMode=="android"){
        var url = "subFormViewer.jsp";
        var requestString = "buttonId="+buttonId +"&pid="+encode_utf8(pid)+"&wid="+encode_utf8(wid)+"&tid="+encode_utf8(tid)+"&fid="+encode_utf8(fid);
        var contentLoaderRef = new net.ContentLoader(url, subformResponseHandler, subformErrorHandler, "POST", requestString, false);
        var subformModalDiv =document.getElementById("iFrameSubFormModal");
        jQuery(subformModalDiv).html(contentLoaderRef.req.responseText);
        }
        else{
        var ScreenHeight=screen.height;
        var ScreenWidth=screen.width;
        var windowH=450;
        var windowW=950;
        var WindowHeight=windowH-100;
        var WindowWidth=windowW;
        var WindowLeft=parseInt(ScreenWidth/2)-parseInt(WindowWidth/2);
        var WindowTop=parseInt(ScreenHeight/2)-parseInt(WindowHeight/2)-50;
        var sid = jQuery("#sid").val();   //Bug 89303 - Clicking on button, Subform functionality is not working.
        var context = '/' + window.location.pathname.split("/")[1];
        var url = context + "/components/viewer/subFormViewer.jsp";
        var reqTok = iforms.ajax.processRequest("formuri="+encode_utf8(url), context+"/GetReqToken");
        var wiWindowRef = window.open("../viewer/subFormViewer.jsp?buttonId="+buttonId+"&pid="+encode_utf8(pid)+"&wid="+encode_utf8(wid)+"&tid="+encode_utf8(tid)+"&fid="+encode_utf8(fid)+"&WD_SID=" + sid + "&WD_RID="+reqTok, 'SubFormPreview', 'scrollbars=yes,left='+WindowLeft+',top='+WindowTop+',height='+windowH+',width='+windowW+',resizable=yes')
    //    wiWindowRef.document.write('<title>'+buttonId+'</title>');
        wiWindowRef.document.title = buttonId;
        if(wiWindowRef!=null){
             addWindowObject(wiWindowRef);             
             wiWindowRef.focus();
         }
        }
    }
	
//Bug 82663 starts	
function addWindowObject(win){
    allWindows[totalSubWindows] = win;
    totalSubWindows += 1; 
}
//Bug 82663 edns


function closeSubForm(){
    while(totalSubWindows>0){
        allWindows[--totalSubWindows].close();
    }
}

    function subformResponseHandler(){}
    function subformErrorHandler(){}

    function checkTableHeight(controlId){
        if(document.getElementById(controlId+"div_pad")!=null){
            var tableControl=document.getElementById(controlId);
            var tablePadDiv=document.getElementById(controlId+"div_pad");
    //        if(tableControl.getElementsByTagName("tbody")[0].getElementsByTagName("tr").length>2){
    //            tablePadDiv.style.display="none";
    //        }
    //        else if(tableControl.getElementsByTagName("tbody")[0].getElementsByTagName("tr").length>1){
    //            tablePadDiv.style.display="";
    //            if(tablePadDiv.getAttribute("type")=="ListView")
    //                tablePadDiv.style.height="30px";
    //            else
    //                tablePadDiv.style.height="35px";
    //            tablePadDiv.firstChild.style.display="none";
    //        }
            if(tableControl.getElementsByTagName("tbody")[0].getElementsByTagName("tr").length>0){
                tablePadDiv.style.display="none";
    //            if(tablePadDiv.getAttribute("type")=="ListView")
    //                tablePadDiv.style.height="60px";
    //            else
    //                tablePadDiv.style.height="70px";
    //            tablePadDiv.firstChild.style.display="none";
            }    
            else{
                tablePadDiv.style.display="";
    //            if(tablePadDiv.getAttribute("type")=="ListView")
    //                tablePadDiv.style.height="90px";
    //            else
    //                tablePadDiv.style.height="105px";
    //            tablePadDiv.firstChild.style.display="";
            }
            checkPadDivWidth(controlId);
        }
    }
    function checkPadDivWidth(controlId){
        if(document.getElementById(controlId+"div_pad")!=null){
            var tablePadDiv=document.getElementById(controlId+"div_pad");
            tablePadDiv.style.minWidth=tablePadDiv.previousSibling.previousSibling.style.minWidth;
        }
    }

    function addBlankRowToTable(tableId){
        if(document.getElementById(tableId)!=null){
            if(document.getElementById(tableId).getAttribute("type")==="Table"){
                executeListView(tableId,"click","");
            }
            else{
                var json={};
                executeListView(tableId,"click",JSON.stringify(json));
            }
        }
    }

    function getSelectedRowsIndexes(tableName){
        var rowIndices = new Array();
        var rowChecks = document.getElementById(tableName).getElementsByClassName("selectRow");
        for(var i=0;i<rowChecks.length;i++){
            if(rowChecks[i].checked){
                rowIndices.push(i);
            }
        }
        return rowIndices;
    }    

    function getSelectedRowsDataFromTable(tableId){
        var table = document.getElementById(tableId);
        var selectedRows = getSelectedRowsIndexes(tableId);
        var dataArray =new Array(selectedRows.length);
        if (table !== null && table !== undefined)
        {
            var tablerows = table.getElementsByTagName("tr");

            for (i = 0; i < selectedRows.length; i++) {            
                 var row = tablerows[parseInt(selectedRows[i])+1];
                var controls = row.getElementsByClassName("control-class");
                dataArray[i] = new Array(controls.length);
                for (var j = 1; j <= controls.length; j++) {
                    var control = controls[j - 1];
                    var value = "";
                    if (control.type == 'text' || control.type == 'select-one' || control.type == 'ComboBox' || control.type == 'textarea') {
                        value = control.value;

                    } else if (control.tagName == 'LABEL') {
                        value = control.innerText;
                    } else if (control.type == "radio" || control.id.indexOf('radio') != -1)
                    {
                        value = control.checked;
                    } else if (control.type == 'checkbox')
                    {
                        value = control.checked;
                    }

                    dataArray[i][j-1]= value;
                }
            }
        }
        return dataArray;
    }

    function addDataToGrid(tableId,jsonData){
        var dateicons = document.getElementById(tableId).getElementsByClassName("glyphicon-calendar");
        if(Object.keys(jsonData).length > 0){
            var gridType;
            if(document.getElementById(tableId).getAttribute("type")==="Table")
                gridType = "table";
            else
                gridType = "listview";
            var isDisabled=document.getElementById(tableId).classList.contains("disabledTable");
            var url = "action_API.jsp";
            var requestString=  "tableId="+tableId +"&addgriddata=yes"+"&pid="+encode_utf8(pid)+"&wid="+encode_utf8(wid)+"&tid="+encode_utf8(tid)+"&fid="+encode_utf8(fid)+"&RowId="+rowId+"&jsonData="+encode_utf8(JSON.stringify(jsonData))+"&gridType="+gridType+"&isDisabled="+isDisabled;
            var contentLoaderRef = new net.ContentLoader(url, addGridDataResponseHandler, ajaxFormErrorHandler, "POST", requestString, false);
            if(isDatePicker=="N")
            {
                for (var i = 0; i < dateicons.length; i++) {
                    dateicons[i].style.visibility = "hidden";
                }
            }
            setTableModifiedFlag(tableId);
            attachDatePicker();
        }
    }   

    function addGridDataResponseHandler(){
        var controlId = getQueryVariable(this.params, "tableId");
         $("#"+controlId+ " tbody").append(this.req.responseText);
        $("#"+controlId).floatThead('reflow');
        
        var dgroupColumns = this.req.getResponseHeader("dgroupColumns");
        var maskedLabels = this.req.getResponseHeader("maskedLabels");
        checkTableHeight(controlId);
//        for(var i=0;i<dgroupColumns.split(",").length;i++){
//            var className = "dgroup_"+controlId+"_"+dgroupColumns.split(",")[i];
//            //var dgroupCells = document.getElementsByClassName("dgroup_"+controlId+"_"+dgroupColumns.split(",")[i]);
//
//            $('.'+className).each(function() {
//                var digitGroup = parseInt(dgroupColumns.split(",")[i].split("_")[1]);
//                var dec = '0';
//                if(jQuery(this).attr('typeofvalue')=='Float')
//                    dec = jQuery(this).attr('Precision');
//                jQuery(this).autoNumeric('init',{
//                    dGroup: digitGroup,
//                    mDec: dec
//                }); 
//            });
//        }
        $('.listviewlabel').each(function() {
            
            var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
            if((this.getAttribute("maskingpattern")!="nomasking" && this.getAttribute("maskingpattern")!="")
            || (typeofvalue=='Float' && this.getAttribute("maskingpattern")=="nomasking"))
            {
                maskfield(this,'savedlabel');
            }

        });
            //Bug 82476 Start
        $('.tabletextbox').each(function() {
            
            var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
            if((this.getAttribute("maskingpattern")!="nomasking" && this.getAttribute("maskingpattern")!="")
            || (typeofvalue=='Float' && this.getAttribute("maskingpattern")=="nomasking"))
            {
                maskfield(this,'input');
            }

        });
            //Bug 82476 End
         var totalValueElements=document.getElementById('totallabel_'+controlId).innerHTML.split(",!,");
            for(var i=0;i<totalValueElements.length;i++){
             //var controlRef = document.getElementById('label'+'_'+controlId+'_'+maskedLabels.split(",")[i]);
             if(totalValueElements[i]!=''){
             $(document.getElementsByClassName(totalValueElements[i].replace(/&lt;/g, '<').replace(/&gt;/g, '>').replace(/&quot;/g, '"').replace(/&amp;/g, '&'))).each(function() {
                var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
            if((this.getAttribute("maskingpattern")!="nomasking" && this.getAttribute("maskingpattern")!="")
            || (typeofvalue=='Float' && this.getAttribute("maskingpattern")=="nomasking"))
            {
                    maskfield(this,'label');
            }
         });
             }
                showTotal('',totalValueElements[i]);
            }
            initFloatingMessagesForTableCells();
        reshuffleIndices(controlId);
       if(window.addRowPostHook)
       {
                addRowPostHook(controlId);
       }
    }

    function deleteRowsFromGrid(tableId,rowIndices){
        deleteTableRows("", tableId, rowIndices);
    }

    function setSelectedRow()
    {
        var myTrArray =  getContentWindow('iFrameSearchModal').getElementsByClassName("info");
        var textBoxValue = "";
        if(typeof myTrArray[0] != "undefined" && typeof myTrArray[0] != null){
            if($(myTrArray[0]).find("td:first").get(0) != null || $(myTrArray[0]).find("td:first") != null)
                textBoxValue = $(myTrArray[0]).find("td:first").get(0).innerText.trim();
        }

       //Bug 80094 Start
       var ctrlId = encode_ParamValue(getContentWindow('iFrameSearchModal').getElementById("controlId").value);
       var rowId = getContentWindow('iFrameSearchModal').getElementById("rowId").value;
       var colId = getContentWindow('iFrameSearchModal').getElementById("colId").value;
        if( typeof myTrArray[0] != "undefined"&&!pickListOkClicked(myTrArray[0],ctrlId,rowId,colId)){
            var ref= getContentWindow('iFrameSearchModal').getElementById("controlId").value;
            if(document.getElementById(ctrlId).type=="text"){
                document.getElementById(ref).value=textBoxValue;
                jQuery(document.getElementById(ref)).trigger("change");
                if(textBoxValue!="")
                    document.getElementById(ref).focus();
            }
            else if(document.getElementById(ctrlId).getAttribute("type")=="Table"){
                setTableCellData(ctrlId, parseInt(rowId), parseInt(colId), textBoxValue, true);
            }
        }
        //Bug 80094 End
        document.getElementById("picklistNext").disabled= false;
        document.getElementById("picklistPrevious").disabled = true;
    }

    //Bug 80094 Start
     function pickListOkClicked(rowArray,controlId,rowId,colId){
        var cells = rowArray.cells;
        var i=0;
        var columns = [];
        for(i=0;i<cells.length;i++){
            columns[i] = cells[i].innerText;
        }
        if(window.postHookPickListOk ){
            var control = document.getElementById(controlId);
	        if(useCustomIdAsControlName && (control==null || control==undefined)){
	            control = document.getElementsByName(controlId)[0];
                    if(control != null && control != undefined)
                        controlId = control.getAttribute("id");
	        }
            return postHookPickListOk(columns,controlId,rowId,colId);
        }
        return false;
    }
    //Bug 80094 End


    function executeServerEvent(controlName, eventType , stringifyData , sync ){        
            var url = "action_API.jsp";
            var requestString = "pid="+encode_utf8(pid)+"&wid="+encode_utf8(wid)+"&tid="+encode_utf8(tid)+"&fid="+encode_utf8(fid)+"&fromEvent=executeServerEvent&controlName="+encode_utf8(controlName)+"&eventType="+encode_utf8(eventType)+"&eventData=" + encode_utf8(stringifyData);

            if (!sync) {
                new net.ContentLoader(url, serverEventHandler, serverEventErrorHandler, "POST", requestString, true);
            } else{
                var responseData = iforms.ajax.processRequest(requestString, url);
            var serverEventResponseData="";
            try{
                var responseObject=JSON.parse(responseData);
                serverEventResponseData=responseObject.responseData.trim();
                if(responseObject.APIData!=null)//Bug 84292
                    renderExecuteServerEventAPIData(responseObject.APIData);//Bug 84292
            }
            catch(ex){}
                if( window.postServerEventHandler )
                postServerEventHandler(controlName, eventType , serverEventResponseData);
            return serverEventResponseData;
            }
    }

function setControlsInControlsFromSetValue(dataArray){//Bug 84292
    var controlId=dataArray.id;
    var type=dataArray.type;

    if(type=="textarea"||type=="textbox"||type=="label"||type=="combo"||type=="checkbox"
        ||type=="radio"||type=="datepick"){
        var dataValue=dataArray.value;
        setValue(controlId, dataValue);
    }
    else if(type=="table"||type=="ListView"){
        if(dataArray.operation=="addDataToGrid"){
             //$("#"+controlId+ " tbody").append(dataArray.value);
            var tableRef = document.getElementById(controlId).tBodies[0];
            $(tableRef).append(dataArray.value);
            checkTableHeight(controlId);//Bug 89195 start
            attachDatePicker(); //Bug 89195 end
        }
        else if(dataArray.operation=="setTableCellValue"){
            setTableCellDataHelper(controlId,dataArray.rowIndex,dataArray.colIndex,dataArray.value);
        }
        else if(dataArray.operation=="clearTable"){
            $("#"+controlId+ " tbody").html("");
            checkTableHeight(controlId);
        }
        $("#"+controlId).floatThead('reflow');
        $('.listviewlabel').each(function() {
                var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
        if((this.getAttribute("maskingpattern")!="nomasking" && this.getAttribute("maskingpattern")!="")
        || (typeofvalue=='Float' && this.getAttribute("maskingpattern")=="nomasking"))
        {
                maskfield(this,'savedlabel');
            }
        });
        $('.tabletextbox').each(function() {
            var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
        if((this.getAttribute("maskingpattern")!="nomasking" && this.getAttribute("maskingpattern")!="")
        || (typeofvalue=='Float' && this.getAttribute("maskingpattern")=="nomasking"))
        {
                maskfield(this,'input');
            }
        });
        var totalValueElements=document.getElementById('totallabel_'+controlId).innerHTML.split(",!,");
        for(var j=0;j<totalValueElements.length;j++){
            if(totalValueElements[j]!=''){
                $(document.getElementsByClassName(totalValueElements[j].replace(/&lt;/g, '<').replace(/&gt;/g, '>').replace(/&quot;/g, '"').replace(/&amp;/g, '&'))).each(function() {
                    var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
                    if((this.getAttribute("maskingpattern")!="nomasking" && this.getAttribute("maskingpattern")!="")
                        || (typeofvalue=='Float' && this.getAttribute("maskingpattern")=="nomasking"))
                        {
                        maskfield(this,'label');
                    }
                });
            }
            showTotal('',totalValueElements[j]);
        }
        initFloatingMessagesForTableCells();
        reshuffleIndices(controlId);
        if(dataArray.operation=="addDataToGrid"){
            if(window.addRowPostHook)
            {
                addRowPostHook(controlId);
            }
        }
    }
}

function setStyleInControlsFromServer(dataArray){//Bug 84292
        var controlId = dataArray.controlid;
        var attributeName = dataArray.attributename;
        var attributeValue = dataArray.attributevalue;
        var showHideAddDelete = dataArray.ShowHideAddDelete;
        try{
        setStyle(controlId,attributeName,attributeValue,showHideAddDelete);
        }
        catch(ex){}
}
function setTabStyleInControlsFromServer(dataArray){//Bug 84292
        var tabId = dataArray.controlid;
        var sheetIndex=dataArray.sheetindex;
        var attributeName = dataArray.attributename;
        var attributeValue = dataArray.attributevalue;
        var showHideAddDelete = dataArray.ShowHideAddDelete; 
        try{
           setTabStyle(tabId,sheetIndex,attributeName,attributeValue,showHideAddDelete);
        }
        catch(ex){}
}
//Bug 84292 Start
function renderExecuteServerEventAPIData(outputArray){
    for (var i = 0; i < outputArray.length; i++){
        try{
        var apiObj=outputArray[i];
        if(apiObj.API==="setData"){
            if(apiObj.id!=null && apiObj.id!=undefined){
                setControlsInControlsFromSetValue(apiObj);
            }
        }
        else if(apiObj.API==="setStyle"){
            setStyleInControlsFromServer(apiObj);
        }
        else if(apiObj.API==="addItemInCombo"){
            addItemInCombo(apiObj.id, apiObj.label, apiObj.value, apiObj.tooltip, apiObj.optionId);
        }
        else if(apiObj.API==="removeItemFromCombo"){
            removeItemFromCombo(apiObj.id, apiObj.index);
        }
        else if(apiObj.API==="clearCombo"){
            clearComboOptions(apiObj.id,false);
        }
        else if(apiObj.API==="addItemInTableCellCombo"){
            addItemInTableCellCombo(apiObj.id, apiObj.rowIndex, apiObj.colIndex, apiObj.label, apiObj.value, apiObj.tooltip, apiObj.optionId);
        }
        else if(apiObj.API==="removeItemFromTableCellCombo"){
            removeItemFromTableCellCombo(apiObj.id, apiObj.rowIndex, apiObj.colIndex, apiObj.index);
        }
        else if(apiObj.API==="clearTableCellCombo"){
            clearTableCellCombo(apiObj.id, apiObj.rowIndex, apiObj.colIndex);
        }
        else if(apiObj.API==="setTabStyle"){
           setTabStyleInControlsFromServer(apiObj);
        }
        else if(apiObj.API==="addZone"){//Bug 85226 Start
           addZone(apiObj.zoneName,apiObj.top,apiObj.left,apiObj.width,apiObj.height,apiObj.id);
        }//Bug 85226 End
        else if(apiObj.API==="deleteRowsFromGrid"){//Bug 85784 Start
            deleteRowsFromGridAction(apiObj.id,apiObj.rowIndices,apiObj.altrowcolor);
            calculateTotalForGrid(apiObj.id);
            setTableModifiedFlag(apiObj.id);
        }//Bug 85784 End
        else if(apiObj.API==="openPickList"){
            openModal(apiObj.controlId,apiObj.header,apiObj.batchSize,apiObj.isListViewModal,apiObj.rowId,apiObj.colId);
        }
    }
    catch(ex){

    }
    }
}
//Bug 84292 End
    function serverEventHandler(){
            var controlName = getQueryVariable(this.params, "controlName");
            var eventType = getQueryVariable(this.params, "eventType");
        var responseData = this.req.responseText;    
        var serverEventResponseData="";
        try{
            var responseObject=JSON.parse(responseData);
            serverEventResponseData=responseObject.responseData;
            if(responseObject.APIData!=null)//Bug 84292
                renderExecuteServerEventAPIData(responseObject.APIData);//Bug 84292
        }
        catch(ex){}
        if( window.postServerEventHandler ){
            postServerEventHandler(controlName, eventType , serverEventResponseData );
        }
}


    function serverEventErrorHandler(){

    }
    function callCustomRowLinkMethod(ref,functionName,controlId){
        //84526 start
        var trs = $("#"+controlId).find("tbody>tr");
        var row=ref.parentNode.parentNode;
        var rowIndex=$(trs).index(row);
        //84526 end
        window[functionName](controlId,rowIndex);
    }

    function searchPicklistData(){
        var contrlid,batchsize,isModal,searchString,columnName;
         document.getElementById("rid_Action").value = window.parent.document.getElementById("rid_Action").value;
        try
        {
            contrlid = document.getElementById("controlId").value;
            batchsize= document.getElementById("batchSize").value;
            isModal=document.getElementById("isModal").value;
            searchString=document.getElementById("searchBox").value;
            columnName=document.getElementById("selectedColumn").options[document.getElementById("selectedColumn").selectedIndex].value;
        }
        catch(ex){
            contrlid = window.frames["iFrameSearchModal"].document.getElementById("controlId").value;
            batchsize= window.frames["iFrameSearchModal"].document.getElementById("batchSize").value;
            isModal= window.frames["iFrameSearchModal"].document.getElementById("isModal").value;
            searchString=window.frames["iFrameSearchModal"].document.getElementById("searchBox").value;
            columnName=window.frames["iFrameSearchModal"].document.getElementById("selectedColumn").options[window.frames["iFrameSearchModal"].document.getElementById("selectedColumn").selectedIndex].value;
        }
        var url = "action.jsp";
        requestString=  "controlId="+contrlid +"&from=search"+"&isListModal="+isModal+"&searchString="+encodeURIComponent(searchString)+"&columnName="+encodeURIComponent(columnName);               
        var contentLoaderRef = new net.ContentLoader(url, searchPicklistHandler, picklisterrorHandler, "POST", requestString, true);
    }

    function searchPicklistHandler(){
        try
        {
            if(this.req.getResponseHeader("Next")=="false"){
                window.parent.document.getElementById("picklistNext").disabled= true;
            }
            else if(this.req.getResponseHeader("Next")=="true"){
                window.parent.document.getElementById("picklistNext").disabled= false;
            }
            if(this.req.getResponseHeader("Previous")=="false"){
                window.parent.document.getElementById("picklistPrevious").disabled = true;
            }else if(this.req.getResponseHeader("Previous")=="true"){
                window.parent.document.getElementById("picklistPrevious").disabled= false;
            }
            //Bug 83107 Start
            $("#myTable tbody").html(this.req.responseText);
            $("#myTable").floatThead('reflow');
            window.parent.document.getElementById("rid_Action").value= document.getElementById("rid_Action").value;
            //Bug 83107 End
            //document.getElementById("fetchedData").innerHTML = this.req.responseText;
        }
        catch(ex){
            //document.getElementById("fetchedData").innerHTML = this.req.responseText;
            //Bug 83107 Start
            $("#myTable tbody").html(this.req.responseText);
            $("#myTable").floatThead('reflow');
            //Bug 83107 End
        }
        
        showSelectedRow();
    }

    function openAdvancedListViewModel(controlId,eventType,reqString){
        if(window.openOverLay)
        {   
            if(!window.openOverLay(controlId)){
                cancelBubble(); 
                return;
            }
        }
        document.getElementById('advancedListview_id').value=controlId;
        var url = "advancedListViewModal.jsp";
        var requestString = "&controlId="+controlId +"&EventType="+eventType+"&tabledata=yes&pid="+encode_utf8(pid)+"&wid="+encode_utf8(wid)+"&tid="+encode_utf8(tid)+"&fid="+encode_utf8(fid)+"&RowId="+rowId+"&Operation=add";
        if(reqString && reqString!=='' && reqString!==null)
            requestString=reqString;
        var contentLoaderRef = new net.ContentLoader(url, openAdvancedListviewhandler, ajaxFormErrorHandler, "POST", requestString, false);
        var tableModalDiv =document.getElementById("iFrameAdvancedListViewModal");
        var tableAddModify =document.getElementById("advancedListViewModal");
        var crossIcon=document.getElementById("closeButton");
        crossIcon.removeAttribute("state");
        jQuery(tableModalDiv).html(contentLoaderRef.req.responseText);
        //tableModalDiv.innerHTML=contentLoaderRef.req.responseText;
        if(!reqString){
            document.getElementById("AdvancedListviewlistPrevious").disabled = true;
            document.getElementById("AdvancedListviewlistNext").disabled= true;
        }
        if(typeof reqString=="undefined")
        {
            tableAddModify.setAttribute("action","A");
            advancedListviewInit(controlId,'A');
        }
        else
        {
            tableAddModify.setAttribute("action","M");
            advancedListviewInit(controlId,'M');
        }
    }
    
    function clearAdvancedListviewMap(action,crossState){
        var url = "action.jsp";
        var requestString="&clearListviewMap=yes"+"&tableId="+document.getElementById("advancedListview_id").value;
        if(crossState=="close")
        {
            var contentLoaderRef = new net.ContentLoader(url,openAdvancedListviewhandler , ajaxFormErrorHandler, "POST", requestString, false);
        }
        else{
            if(action=="A" && CleanMapOnCloseModal !="Y"){        
			//if(action=="A" ){        
                var contentLoaderRef = new net.ContentLoader(url,clearAdvancedListviewMaphandler , ajaxFormErrorHandler, "POST", requestString, false);           
            }
            else
                var contentLoaderRef = new net.ContentLoader(url,modifyAdvancedListviewhandler , ajaxFormErrorHandler, "POST", requestString, false);
        }       
    }
    
    function clearAdvancedListviewMaphandler(){
        var controlId =getQueryVariable(this.params, "tableId");
        if(window.addRowPostHook)
        {
            addRowPostHook(controlId);
        }
    }
    function openAdvancedListviewhandler()
    {
      
    }
    function modifyAdvancedListviewhandler()
    {
        var controlId =getQueryVariable(this.params, "tableId");
        if(window.modifyRowPostHook)
        {
            modifyRowPostHook(controlId);
        }       
    }
    function advancedListviewResponseHandler(){
        $("#"+this.req.getResponseHeader("TableId")+ " tbody").append(this.req.responseText);
        $("#"+this.req.getResponseHeader("TableId")).floatThead('reflow');
    }

    function addRowToAdvancedListview(controlId,copyRowFlag){
        copyRowFlag=typeof copyRowFlag =='undefined'?false:copyRowFlag;//issue with copy row in advanced listview
        var valid = validateMandatoryFields();
        if(valid)
            valid = fetchCollapsedFrameHTML(controlId);
        if(!valid){
            if(document.getElementById("duplicateAdvancedListviewchanges_"+controlId)!=null)
               document.getElementById("duplicateAdvancedListviewchanges_"+controlId).removeAttribute("data-dismiss");
            
            if(document.getElementById("addAdvancedListviewrow_"+controlId)!=null)//Bug 84293
                document.getElementById("addAdvancedListviewrow_"+controlId).removeAttribute("data-dismiss");
            return false;
        }
        var customListViewValid ;
        if(window.customListViewValidation){
            customListViewValid = customListViewValidation(controlId,"A");
            if(!customListViewValid){
                if(document.getElementById("addAdvancedListviewrow_"+controlId)!=null)//Bug 84293
                    document.getElementById("addAdvancedListviewrow_"+controlId).removeAttribute("data-dismiss");
                return false;
            }
            else{
                if(document.getElementById("addAdvancedListviewrow_"+controlId)!=null)//Bug 84293
                    document.getElementById("addAdvancedListviewrow_"+controlId).setAttribute("data-dismiss","modal");
            }
        }

        var dataValue={};
        var elementsArray=document.getElementsByClassName('advancedListviewControl');
        var invalidControls=[];
        var nullElements=[];
        $(elementsArray).each(function(i) {
            if(this.tagName=='TABLE')
                return true;
            if((this.className.indexOf("denyNull")!=-1)&&(this.value==""||this.value==null)){
                nullElements.push(this.className.split("_")[1]);
            }

            if(this.getAttribute("typeofvalue") && (this.getAttribute("typeofvalue")==='Boolean' || this.getAttribute("typeofvalue")==='Integer' || this.getAttribute("typeofvalue")==='Float' || this.getAttribute("typeofvalue")==='Long')){
                if(!validateTypeOfValue(this))
                {
                    invalidControls.push(this);
                }
            }
            else{
                var type=jQuery(this).attr("datatype");
                if(!validateValue(this,type))
                {
                    invalidControls.push(this);
                }
            }

    //        var value=this.value?this.value:this.innerHTML;
    //        if(this.getAttribute("maskingPattern") && (this.getAttribute("maskingPattern").toString()==='currency_rupees' || this.getAttribute("maskingPattern").toString()==='currency_dollar' || this.getAttribute("maskingPattern").toString()==='currency_yen' || this.getAttribute("maskingPattern").toString()==='currency_euro' || this.getAttribute("maskingPattern").toString()==='percentage'|| this.getAttribute("maskingPattern").toString()==='dgroup2'|| this.getAttribute("maskingPattern").toString()==='dgroup3'))
    //        {
    //            value =  getControlValue(this);
    //        }
    //        if(this.type==='select-one')
    //            value=this.value===''?'':this.value;
    //        if(this.type && (this.type==="checkbox" || this.type==="radio"))
    //            value=this.checked;
    //        dataValue[formatJSONValue(this.getAttribute("labelName"))]=formatJSONValue(value);

        });
        var invalidControl;
        for(var j=0;j<elementsArray.length;j++){
            if(elementsArray[j].tagName=="TABLE")
                continue;
            if(!validateColumnValue(elementsArray[j],controlId,false)){
                invalidControl=elementsArray[j];
                break;

            }
        }
        if(invalidControls.length>0){
            if(document.getElementById("duplicateAdvancedListviewchanges_"+controlId)!=null)
               document.getElementById("duplicateAdvancedListviewchanges_"+controlId).removeAttribute("data-dismiss");
             
             if(document.getElementById("addAdvancedListviewrow_"+controlId)!=null)//Bug 84293
                document.getElementById("addAdvancedListviewrow_"+controlId).removeAttribute("data-dismiss");
             return false;
        }
    //    if(nullElements.length>0){
    //        document.getElementById("addrow_"+controlId).removeAttribute("data-dismiss");
    //        showMessage("","Null values not allowed in "+nullElements,"error");
    //        return false;
    //    }

    //    if(invalidControl!=undefined || invalidControl!=null){
    //        document.getElementById("addrow_"+controlId).removeAttribute("data-dismiss");
    //        var validationmsg = document.getElementById(controlId+"_"+invalidControl.getAttribute("labelName")+"_msg").innerHTML;
    //        showMessage(invalidControl,validationmsg +":"+'<strong>'+invalidControl.getAttribute("labelName")+'</strong>',"error");
    //      
    //        return false;
    //    }
            if(document.getElementById("duplicateAdvancedListviewchanges_"+controlId)!=null)
               document.getElementById("duplicateAdvancedListviewchanges_"+controlId).setAttribute("data-dismiss","modal");
            
            if(document.getElementById("addAdvancedListviewrow_"+controlId)!=null)//Bug 84293
                document.getElementById("addAdvancedListviewrow_"+controlId).setAttribute("data-dismiss","modal");
  
            dataValue = saveRichTextEditorData('iFrameAdvancedListViewModal',dataValue);
            executeListView(document.getElementById('advancedListview_id').value,'click',JSON.stringify(dataValue),copyRowFlag);//issue with copy row in advanced listview

            var totalValueElements=document.getElementById('totallabel_'+controlId).innerHTML.split(",!,");
            for(var i=0;i<totalValueElements.length;i++){
             //var controlRef = document.getElementById('label'+'_'+controlId+'_'+maskedLabels.split(",")[i]);
             if(totalValueElements[i]!=''){
             $(document.getElementsByClassName(totalValueElements[i].replace(/&lt;/g, '<').replace(/&gt;/g, '>').replace(/&quot;/g, '"').replace(/&amp;/g, '&'))).each(function() {
                 var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
            if((this.getAttribute("maskingpattern")!="nomasking" && this.getAttribute("maskingpattern")!="")
            || (typeofvalue=='Float' && this.getAttribute("maskingpattern")=="nomasking"))
            {
                    maskfield(this,'label');
            }
         });
             }
                showTotal('',totalValueElements[i]);
            }        
            setTableModifiedFlag(controlId);
    }
    function setListBoxStyle()
    {
      
        $( "select[multiple='']").each(function() {          
              $(this).siblings().find('.multiselect-container .checkbox').css("text-align",$(this).css("text-align"));
              $(this).siblings().find('.multiselect-container .checkbox').css("font-size",$(this).css("font-size"));
              $(this).siblings().find('.multiselect-container .checkbox').css("font-weight",$(this).css("font-weight"));
              $(this).siblings().find('.multiselect-container .checkbox').css("font-style",$(this).css("font-style"));
              $(this).siblings().find('.multiselect-container .checkbox').css("font-family",$(this).css("font-family"));
              $(this).siblings().find('.multiselect-container .checkbox').css("background-color",$(this).css("background-color"));
              $(this).siblings().find('.multiselect-container .checkbox').css("color",$(this).css("color"));   
              $(this).siblings().find('.dropdown-toggle').css("text-align",$(this).css("text-align"));
              $(this).siblings().find('.dropdown-toggle').css("font-size",$(this).css("font-size"));
              $(this).siblings().find('.dropdown-toggle').css("font-weight",$(this).css("font-weight"));
              $(this).siblings().find('.dropdown-toggle').css("font-style",$(this).css("font-style"));
              $(this).siblings().find('.dropdown-toggle').css("font-family",$(this).css("font-family"));
              $(this).siblings().find('.dropdown-toggle').css("background-color",$(this).css("background-color"));
              $(this).siblings().find('.dropdown-toggle').css("color",$(this).css("color"));    
              //Bug 82077 - CSS of Multiselect should be same as Combo Box in iForms
              if($(this).hasClass('Style2')){
                  $(this).siblings().find('.dropdown-toggle').css("border-left","0px");
                  $(this).siblings().find('.dropdown-toggle').css("border-right","0px");
                  $(this).siblings().find('.dropdown-toggle').css("border-top","0px");
                  $(this).siblings().find('.dropdown-toggle').css("border-radius","0px");
                  $(this).siblings().find('.dropdown-toggle').css("padding-left","0px");
                  $(this).siblings().find('.dropdown-toggle').css("padding-right","0px");
                  $(this).siblings().find('.dropdown-toggle').addClass('form-control');
                  $(this).siblings().find('.dropdown-toggle').css("overflow","hidden"); //Bug 84710 
                  $(this).siblings().find('.dropdown-toggle').css("white-space","nowrap");
                  $(this).siblings().find('.dropdown-toggle').css("text-overflow","ellipsis");
              }else if($(this).hasClass('Style3')){
                   $(this).siblings().find('.dropdown-toggle').addClass('form-control1');
                   $(this).siblings().find('.dropdown-toggle').css("height","30px");
              }else{
                  $(this).siblings().find('.dropdown-toggle').addClass('form-control1');
              }
            });
            $('.dropdown-toggle').removeClass('btn');
            $('.dropdown-toggle').removeClass('btn-default');
            $('.multiselect-container').css("border-color","#66afe9");        
            $('.multiselect-container .checkbox').addClass('inputStyle');
            $('.multiselect-container .checkbox').css("border","0px");
            $('.dropdown-toggle').addClass('inputStyle');     
            //Bug 82173
            $('.dropdown-toggle').addClass('control-class');  
            $('.dropdown-toggle').css('padding','2px 8px');       
            $('.dropdown-toggle .caret').addClass("pull-right"); 
            
    }
    function advancedListviewInit(controlId,action){

     $('.tabletextbox').each(function() {
            var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
            if((this.getAttribute("maskingpattern")!="nomasking" && this.getAttribute("maskingpattern")!="")
            || (typeofvalue=='Float' && this.getAttribute("maskingpattern")=="nomasking"))
            {
                maskfield(this,'input');
            }

        });	
        
        $('.openPickerClass').each(function()
        {
            if(this.getAttribute("maskingPattern")!=null && this.getAttribute("maskingPattern")!=undefined && this.getAttribute("maskingPattern")!="" )
            {
                maskfield(this,'input');
            }
        });

    $('.advancedListviewControl.textbox').each(function() {
            var max=this.getAttribute("rangemax");
            var min=this.getAttribute("rangemin");
            var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
            var precision=typeof this.getAttribute("Precision")=='undefined'?'2':this.getAttribute("Precision");
            var decimal='2';
            if(typeofvalue =="Float")
                decimal=precision;
            if(typeofvalue =="Integer")
                decimal='0';
            if(typeofvalue =="Long")
                decimal='0';

            if(this.getAttribute("maskingPattern").toString()!='nomasking'){
            if(this.getAttribute("maskingPattern").toString()!='currency_rupees' && this.getAttribute("maskingPattern").toString()!=='currency_dollar' && this.getAttribute("maskingPattern").toString()!=='currency_yen' && this.getAttribute("maskingPattern").toString()!=='currency_euro' && this.getAttribute("maskingPattern").toString()!=='currency_french' && this.getAttribute("maskingPattern").toString()!=='currency_greek' && this.getAttribute("maskingPattern").toString()!=='' && this.getAttribute("maskingPattern").toString()!=='percentage'){
                    var placeholder;
                    if(this.getAttribute("maskingPattern").toString().charAt(this.getAttribute("maskingPattern").toString().length-1)!='$'){
                        if(this.getAttribute("maskingPattern").toString()=='dgroup3' || this.getAttribute("maskingPattern").toString()=='dgroup2'){
                            var digitGroup = parseInt(this.getAttribute("maskingPattern").charAt(this.getAttribute("maskingPattern").length-1));
                            jQuery(this).autoNumeric('init',{
                                dGroup: digitGroup,
                                mDec: decimal                                

                            });
                        }
                        else{
                        if(typeofvalue=='Float'&&this.getAttribute("maskingPattern").toString()=='NZP'){
                            jQuery(this).autoNumeric('init',{
                                aSep : '',  
                                aDec: '.', 
                                mDec: decimal,
                                aPad: false
                            });
                        }
                        else{
                            placeholder=this.getAttribute("maskingPattern").replace(/[A-Za-z0-9*#]/mg , "_");
                            jQuery(this).mask(this.getAttribute("maskingPattern"), {
                                placeholder: placeholder
                            }, {
                                clearIfNotMatch: true
                            });
                            return true;//Bug 79052
                        }
                    }
                    }
                }

                else{
                    var asign='';
                    var dgroup='';
                    var psign='p';
                var adec='.';
                var asep=',';
                    if(this.getAttribute("maskingPattern").toString()==='currency_rupees'){
                        asign='Rs ';
                        dgroup=2;
                    }
                    else if(this.getAttribute("maskingPattern").toString()==='currency_dollar'){
                        asign='$ ';
                        dgroup=3;
                    }
                    else if(this.getAttribute("maskingPattern").toString()==='currency_yen'){
                        asign='¥ ';
                        dgroup=3;
                    }
                    else if(this.getAttribute("maskingPattern").toString()==='currency_euro'){
                        asign='€ ';
                        dgroup=3;
                    }
                else if(this.getAttribute("maskingPattern").toString()==='currency_french'){
//                    asign=' CHF';
                    dgroup=3;
                    adec = ',';
                    asep = ' ';
                    psign= 's';
                }
                else if(this.getAttribute("maskingPattern").toString()==='currency_greek'){
                    dgroup=3;
                    adec = ',';
                    asep = '.';
                    psign= 's';
                }
                    if(this.getAttribute("maskingPattern").toString()!=='percentage' && this.getAttribute("maskingPattern").toString() !=='currency_yen' ){
                        if(max===null)
                            jQuery(this).autoNumeric('init',{
                                aSign: asign, 
                                dGroup: dgroup,
                                pSign:psign,
                                mDec: decimal,
                            aNeg:true,
                            aDec: adec,
                            aSep: asep
                            });
                        else{
                            jQuery(this).autoNumeric('init',{
                                aSign: asign, 
                                dGroup: dgroup,
                                pSign:psign, 
                            mDec: decimal,
                            aDec: adec,
                            aSep: asep
                            });

                        }
                    }
                    else if(this.getAttribute("maskingPattern").toString() =='currency_yen'){
                            if(max===null)
                                jQuery(this).autoNumeric('init',{
                                    aSign: asign, 
                                    dGroup: dgroup,
                                    pSign:psign,
                                    mDec: "0",
                                aNeg:true,
                                aDec: adec,
                                aSep: asep
                                });
                            else{
                                jQuery(this).autoNumeric('init',{
                                    aSign: asign, 
                                    dGroup: dgroup,
                                    pSign:psign, 
                                mDec: "0",
                                aDec: adec,
                                aSep: asep
                                });
                            }
                        }
                    else
                        jQuery(this).autoNumeric('init',{
                            aSign: " %", 
                            pSign:'s',
                            mDec: decimal
                        });
                }

            }
            if(typeofvalue=='Float' && this.getAttribute("maskingPattern") && this.getAttribute("maskingPattern").toString()=='nomasking'){
            jQuery(this).autoNumeric('init',{
                aSep : '',  
                aDec: '.', 
                mDec: decimal
            });
         
        }

            //if(this.value!=='')
              //  jQuery(this).autoNumeric('set', this.value)
        });
        $('.advancedListviewControl.maskedText').each(function(){
            var digitGroup  = parseInt(this.getAttribute("dgroup"));
            var dec = '0';
            if(jQuery(this).attr('typeofvalue')=='Float')
                dec = jQuery(this).attr('Precision');
            jQuery(this).autoNumeric('init',{
                dGroup: digitGroup,
                mDec: dec
            });
        });
         $('.listviewlabel').each(function() {
                
        var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
        if((this.getAttribute("maskingpattern")!="nomasking" && this.getAttribute("maskingpattern")!="")
            || (typeofvalue=='Float' && this.getAttribute("maskingpattern")=="nomasking"))
            {
            maskfield(this,'label');
        }

        });
        $('.totalLabel').each(function() {
            
            var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
            if((this.getAttribute("maskingpattern")!="nomasking" && this.getAttribute("maskingpattern")!="")
            || (typeofvalue=='Float' && this.getAttribute("maskingpattern")=="nomasking"))
            {
                maskfield(this,'label');
            }

        });
        initFloatingMessagesForPrimitiveFields('.errorMessageHoverDiv.advancedListviewControlDiv');
        initFloatingMessagesForTableCells();
        setWidthForTabStyle4();
        $('.listviewTab.tabtheme4.iformTabUL.scrollingTabCSS').each(function(){
            $(this).removeClass("scrollingTabCSS");
            $(this).scrollingTabs({
                disableScrollArrowsOnFullyScrolled :true,
                enableRtlSupport :true,
                enableSwiping:true
      
            });
        });
        
       
        doInit();
        attachDatePicker();
        executeLoadEvents('3',controlId);
        clearComponentMap("advancedlistview");
        disableAdvancedListViewControls(controlId);
        listViewLoad(controlId,action);
        makeStickyTabs(true);
        setListBoxStyle();
    }

    function setButtonDropDown(tabId,jsonObj){
        var isSaveOptionsEnabled=false;
        var tabControl = document.getElementById(tabId);
        var oldButton = tabControl.getElementsByTagName("ul")[0].getElementsByClassName("tabbuttonClass")[0];
        if(oldButton!=null && oldButton!=undefined)
            //oldButton.remove();
            tabControl.getElementsByTagName("ul")[0].removeChild(oldButton);
//        if(!$(tabControl.getElementsByTagName("ul")[0].parentNode).hasClass("iformTabControl")&&$(tabControl.getElementsByTagName("ul")[0]).hasClass("tabtheme4"))
//            isSaveOptionsEnabled=true;
        if($(tabControl.getElementsByTagName("ul")[0]).hasClass("tabtheme4") && jQuery(".tabButtonsDiv").length==0 ){
            var fixVar=jQuery("#"+tabId).find(".scrtabs-tabs-fixed-container");
            var st=fixVar.attr("style")+";overflow:visible;";
            fixVar.attr("style",st);
            
             var liElem =  document.createElement("li");
        liElem.classList.add("tabbuttonClass");
            liElem.style.maxWidth = "100%";
            liElem.style.cssFloat = "right";
            liElem.style.zIndex = 201;

            var imgElem = document.createElement("img");
            imgElem.src = "./resources/images/hamburger.png";
            imgElem.style.height = "20px"
            imgElem.style.width = "30px"
            imgElem.style.marginTop="5px";

            var buttonElem = document.createElement("button");
            buttonElem.style.border="0px";
            buttonElem.style.background="inherit";
            buttonElem.id=tabId+"_tabButton";

            buttonElem.appendChild(imgElem);
            liElem.appendChild(buttonElem);

            tabControl.getElementsByTagName("ul")[0].appendChild(liElem);
        }
        else if( $(tabControl.getElementsByTagName("ul")[0]).hasClass("tabtheme4")){
            
            var fixVar=jQuery("#"+tabId).find(".tabButtonsDiv");
            var st=fixVar.attr("style")+";overflow:visible;"+";width:210px;";
            fixVar.attr("style",st);
            
  
            var imgElem = document.createElement("img");
            imgElem.src = "./resources/images/hamburger.png";
            imgElem.style.height = "20px"
            imgElem.style.width = "30px"
            imgElem.style.marginTop="5px";

            var buttonElem = document.createElement("button");
            buttonElem.style.border="0px";
            buttonElem.style.background="inherit";
            buttonElem.id=tabId+"_tabButton";
        
            buttonElem.appendChild(imgElem);
            fixVar.get(0).appendChild(buttonElem);
            setWidthForTabStyle4();
        }        
       else{
            var liElem =  document.createElement("li");
            liElem.classList.add("tabbuttonClass");
            liElem.style.maxWidth = "100%";
            liElem.style.cssFloat = "right";
            liElem.style.zIndex = 201;

            var imgElem = document.createElement("img");
            imgElem.src = "./resources/images/hamburger.png";
            imgElem.style.height = "20px"
            imgElem.style.width = "30px"
            imgElem.style.marginTop="5px";

            var buttonElem = document.createElement("button");
            buttonElem.style.border="0px";
            buttonElem.style.background="inherit";
            buttonElem.id=tabId+"_tabButton";
        
            buttonElem.appendChild(imgElem);
            liElem.appendChild(buttonElem);

            tabControl.getElementsByTagName("ul")[0].appendChild(liElem);
        }
        
        var dropDownDiv = document.createElement("div");
        dropDownDiv.classList.add("dropdown");
        dropDownDiv.classList.add("pull-right");

        var button = document.getElementById(tabId+"_tabButton");
        if(!isSaveOptionsEnabled)
            button.parentNode.appendChild(dropDownDiv);
        else{
            tabControl.getElementsByTagName("ul")[0].parentNode.nextSibling.appendChild(dropDownDiv);
        }
        dropDownDiv.appendChild(button);

        var contentDiv = document.createElement("div");
        contentDiv.classList.add("dropdown-content");
        contentDiv.style.cssFloat = "right";
        contentDiv.style.right = 0;
        contentDiv.style.zIndex = 99999;
        for(key in jsonObj){
            var anchor = document.createElement('a');
            anchor.innerHTML = key;
            anchor.setAttribute("onclick",jsonObj[key]+"(this,"+"'"+key+"'"+")");
            contentDiv.appendChild(anchor);
        }
        button.parentNode.appendChild(contentDiv);
    }

    function onCustomLinkClick(ref,controlId){
        if(window.onClickCustomLink){
            var control = document.getElementById(controlId);
	        if(useCustomIdAsControlName && (control==null || control==undefined)){
	            control = document.getElementsByName(controlId)[0];
                    if(control != null && control != undefined)
                        controlId = control.getAttribute("id");
	        }
            onClickCustomLink(ref,controlId);
        }
    }

    function filterTableData(ref, filterType , colIndex, controlId , controlType ){

        //sortingHandler(colIndex,controlId,controlType );
        var searchString ='';
        if( document.getElementById(controlId+"_searchBox")!=null)
             searchString=document.getElementById(controlId+"_searchBox").value;
        if( filterType == 'Search'){
            colIndex = document.getElementById(controlId+"_selectedColumn").options[document.getElementById(controlId+"_selectedColumn").selectedIndex].value;

        }
        try{
            var thRef = $($('#'+controlId).get(0).parentNode.parentNode).find('th.tableStyle').get(parseInt(colIndex)+1);
            var isDisabled=document.getElementById(controlId).classList.contains("disabledTable");
            var sortOrder = thRef.getAttribute("SortOrder");  
            if( !sortOrder ){
                sortOrder = "A";
            }

            if(filterType == "Search"){
                sortOrder = "";
            }
        }
        catch(ex){

        }
        var url = "action.jsp";
        var requestString=  "controlId="+controlId + "&FilterType="+filterType+ "&SearchCriterion="+searchString + "&SortCriterion="+ sortOrder +"&ColumnIndex="+ colIndex+"&pid="+encode_utf8(pid)+"&wid="+encode_utf8(wid)+"&tid="+encode_utf8(tid)+"&fid="+encode_utf8(fid)+"&controlType="+controlType+"&isDisabled="+isDisabled;  
        if(isGridBatchingEnabled=="true" && filterType=="Search"){
            var tableDataChangeFlag=isTableDataChanged(controlId);
            
            if(!tableDataChangeFlag)
            {
                new net.ContentLoader(url, filterHandler, ajaxFormErrorHandler, "POST", requestString, false);  
                return;
            }

            var strMSg = BATCH_MSG;

            var buttons = {
                confirm: {
                    label: YES,
                    className: 'btn-success'

                },
                cancel: {
                    label: NO,
                    className: 'btn-danger'

                }
            }

            var callback = function(result){
                if(result == true){
                    requestString=requestString+"&SaveCurrentBatch=Y";
                    new net.ContentLoader(url, filterHandler, ajaxFormErrorHandler, "POST", requestString, false); 
                // jQuery(this).dialog("close");
                }
                else if(result == false){
                    new net.ContentLoader(url, filterHandler, ajaxFormErrorHandler, "POST", requestString, false); 
                    // jQuery(this).dialog("close");
                }
            }
            showConfirmDialog(strMSg,buttons,callback);
        }
        else{
            if(isGridBatchingEnabled=="false" && colIndex==-1){
                var contentLoaderRef = new net.ContentLoader(url, filterHandler, ajaxFormErrorHandler, "POST", requestString, false);
            }
        else{
        if(filterType=="Search"){
                
            if(isTableDataChanged(controlId)){
                var strMSg = BATCH_MSG;
                var buttons = {
                    confirm: {
                        label: YES,
                        className: 'btn-success'

                    },
                    cancel: {
                        label: NO,
                        className: 'btn-danger'

                    }
                }

                var callback = function(result){
                    if(result == true){
                        requestString=requestString+"&SaveCurrentBatch=Y";
                        var contentLoaderRef = new net.ContentLoader(url, filterHandler, ajaxFormErrorHandler, "POST", requestString, false);
                    }
                    else{
                        var contentLoaderRef = new net.ContentLoader(url, filterHandler, ajaxFormErrorHandler, "POST", requestString, false);
                    }
                }
                showConfirmDialog(strMSg,buttons,callback);
            }
            else{
                var contentLoaderRef = new net.ContentLoader(url, filterHandler, ajaxFormErrorHandler, "POST", requestString, false);
            }
        }
        else{
            var contentLoaderRef = new net.ContentLoader(url, filterHandler, ajaxFormErrorHandler, "POST", requestString, false);
        }
      }   
    } 

 }

function isTableDataChanged(tableId){
        var tableDataChangeFlag=false;
        for(var i=0;i<tableDataChangeArray.length;i++){
            var jsonObject=tableDataChangeArray[i];
            if(jsonObject.controlId==tableId){
                tableDataChangeFlag=true;
                tableDataChangeArray.splice(i, 1);
                break;
            }
        }
        return tableDataChangeFlag;
    }
    
    function filterHandler(){
        if(this.req.responseText.trim()!="" && !c_isNaN(this.req.responseText.trim())){   ////Bug 90101
        var code = parseInt(this.req.responseText.trim());
            if( code !== 0){
                showMessage("", "Error in Saving Data.", "error");
                return;
            }
        }
        var tableId=getQueryVariable(this.params, "controlId");
      $("#"+tableId+" tbody").empty();
      $("#"+tableId+ " tbody").append(this.req.responseText);
      $("#"+tableId).floatThead('reflow');
      var colIndex = getQueryVariable(this.params, "ColumnIndex");
      var sortOrder = this.req.getResponseHeader("SortOrder");  
      var batchCounter=this.req.getResponseHeader("batchCounter");  
      var thRef = null;

        try{ 
            $($('#'+tableId).get(0).parentNode.parentNode).find('th.tableStyle').removeAttr("SortOrder");    
            $($('#'+tableId).get(0).parentNode.parentNode).find('th.tableStyle').css({"background-repeat":"","background-position":"","background-image":""});
            thRef = $($('#'+tableId).get(0).parentNode.parentNode).find('th.tableStyle').get(parseInt(colIndex)+1);
            thRef.style.backgroundRepeat = "no-repeat";
            thRef.style.backgroundPosition = "center right";

              var imageName = "";
              if( sortOrder == "D"){
                  thRef.setAttribute("SortOrder" , "A");
                  imageName = "lvwUp.png";
              }
              else if( sortOrder == "A"){
                  thRef.setAttribute("SortOrder" , "D");
                  imageName = "lvwDown.png";
              }
              else if( sortOrder == "N"){
                  thRef.removeAttribute("SortOrder");      
              }
            thRef.style.backgroundImage = ( imageName != "") ? "url('resources/images/" + imageName + "')" : "";
            reshuffleIndices(tableId,sortOrder,batchCounter);
        }catch(ex){}


      checkTableHeight(tableId);
      initFloatingMessagesForTableCells();
      var preEnabled=this.req.getResponseHeader("preEnabled");
      var nextEnabled=this.req.getResponseHeader("nextEnabled");
      if(preEnabled=="true")
        $("#pre_"+tableId).prop("disabled", false);
      else
        $("#pre_"+tableId).prop("disabled", true);
      if(nextEnabled=="true")
        $("#next_"+tableId).prop("disabled", false);
      else
        $("#next_"+tableId).prop("disabled", true);
    $("#"+tableId+ " .listviewlabel").each(function() {
        var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
        if((this.getAttribute("maskingpattern")!="nomasking" && this.getAttribute("maskingpattern")!="")
            || (typeofvalue=='Float' && this.getAttribute("maskingpattern")=="nomasking"))
            {
            maskfield(this,'savedlabel');
        }

    });
    $("#"+tableId+ " .tabletextbox").each(function() {
        var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
        if((this.getAttribute("maskingpattern")!="nomasking" && this.getAttribute("maskingpattern")!="")
            || (typeofvalue=='Float' && this.getAttribute("maskingpattern")=="nomasking"))
            {
            maskfield(this,'input');
        }

    });
      var totalValueElements=document.getElementById('totallabel_'+tableId).innerHTML.split(",!,");
      for(var i=0;i<totalValueElements.length;i++){
        if(totalValueElements[i]!=''){
         $(document.getElementsByClassName(totalValueElements[i].replace(/&lt;/g, '<').replace(/&gt;/g, '>').replace(/&quot;/g, '"').replace(/&amp;/g, '&'))).each(function() {
        var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
            if((this.getAttribute("maskingpattern")!="nomasking" && this.getAttribute("maskingpattern")!="")
            || (typeofvalue=='Float' && this.getAttribute("maskingpattern")=="nomasking"))
            {
            maskfield(this,'label');
            }
        });
        }
        showTotal('',totalValueElements[i]);
     }

     var dgroupColumns = this.req.getResponseHeader("dgroupColumns");
     if(dgroupColumns!=null && dgroupColumns!=undefined){
     for(var i=0;i<dgroupColumns.split(",").length;i++){
        var className = "dgroup_"+tableId+"_"+dgroupColumns.split(",")[i];
        //var dgroupCells = document.getElementsByClassName("dgroup_"+controlId+"_"+dgroupColumns.split(",")[i]);

        $('.'+className).each(function() {
            var digitGroup = parseInt(dgroupColumns.split(",")[i].split("_")[1]);
            jQuery(this).autoNumeric('init',{
                dGroup: digitGroup,
                mDec: '0'
            }); 
        });
     }
    }
    if(window.searchGridPostHook)
    {
        searchGridPostHook(tableId);
    }
    }
    function getGridRowCount(tableId){
        var control = document.getElementById(tableId);
        var selectRowChecks = control.getElementsByClassName("selectRow");
        return selectRowChecks.length;
    }
    function isSectionCompleted(frameId){
        var frame=document.getElementById(frameId);
        if(frame!=null){
            if(frame.children[1]!=null&&frame.children[1].children[0]!=null){
                if(frame.children[1].children[0].innerHTML!=""){
                   return isSectionMandatoryLeft(frameId);
                }
                else
                    return false;
            }
            else if(frame.children[0]!="undefined"){
                return isSectionMandatoryLeft(frameId);
            }
        }
        return false;
    }
    function isSectionMandatoryLeft(frameId){
         var mandatoryFields=$("#"+frameId+" [required=''] ");
        for(var i=0;i<mandatoryFields.length;i++){
            var value;
            var control=jQuery(mandatoryFields[i]);
            var ctrlType=control.attr("type");
            if(!(document.getElementById(control.attr("id")).style.display==="none")){
                if(ctrlType=="text" || ctrlType=="textarea"|| typeof ctrlType=="undefined")
                {
                    value=getControlValue(document.getElementById(control.attr("id")));
                    if(typeof ctrlType=="undefined")
                        value=jQuery(control).val();
                    if(value=="" || value==null)
                    {
                        return false;
                    }
                }
                else if(ctrlType=="radio")
                {
                    if(document.querySelector('input[name="'+control.prop("name")+'"]:checked') == null)
                    {
                        return false;
                    }
                }
                else if(ctrlType=="checkbox")
                {
                    value=control.prop("checked");
                    if(!value)
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    //Bug 81232 Start
    function applyMaskingValue(ref,value){
        if(ref.getAttribute("maskingPattern").toString()!='nomasking'&&ref.getAttribute("maskingPattern").toString()!=''&&ref.getAttribute("maskingPattern").toString()!='email'){
        if(ref.getAttribute("maskingPattern").toString()!='currency_rupees' && ref.getAttribute("maskingPattern").toString()!=='currency_dollar' && ref.getAttribute("maskingPattern").toString()!=='currency_yen' && ref.getAttribute("maskingPattern").toString()!=='currency_euro' && ref.getAttribute("maskingPattern").toString()!=='currency_french' && ref.getAttribute("maskingPattern").toString()!=='currency_greek' && ref.getAttribute("maskingPattern").toString()!=='' && ref.getAttribute("maskingPattern").toString()!=='percentage'&& ref.getAttribute("maskingPattern").toString()!=='NZP'){
                var placeholder;
                if(ref.getAttribute("maskingPattern").toString().charAt(ref.getAttribute("maskingPattern").toString().length-1)!='$'){
                    if(ref.getAttribute("maskingPattern").toString()=='dgroup3' || ref.getAttribute("maskingPattern").toString()=='dgroup2'){
                        if(value!=='')
                            jQuery(ref).autoNumeric('set', value);
                        return jQuery(ref).autoNumeric('get');
                    }
                    else{  
                    jQuery(ref).val(value).trigger("keyup");
                    if(ref.getAttribute("datatype") == "date")
                    {
                        value = ref.value;
                    }
                    else
                        return jQuery(ref).cleanVal();//Bug 79052
                    }
                }
            }
            else{
                if(value!=='')
                    jQuery(ref).autoNumeric('set', value);
                return jQuery(ref).autoNumeric('get');
            }
        }
        return value;
    }
    //Bug 81232 End
    function executeLoadEvents(type,controlId){
        if($(".formEvent").length>0 || type==='3' || type==='4'){
            var url = "action_API.jsp";
            var requestString="executeFormLoadEvent=yes&type="+type;
            if(typeof controlId!="undefined"){    
                requestString += "&FormLoadEventControlId="+controlId;
            }
            requestString+="&pid="+encode_utf8(pid)+"&wid="+encode_utf8(wid)+"&tid="+encode_utf8(tid);
            new net.ContentLoader(url, executeLoadEventHandler, frameErrorHandler, "POST", requestString, true);
        }
    }
    function executeLoadEventHandler(){
        try{
            var jsonObj = JSON.parse(this.req.responseText);
            var customAction=jsonObj.customAction;
            var dbLinkingArray=jsonObj.dbLinking;
            if(dbLinkingArray!=null&&dbLinkingArray!=undefined&&dbLinkingArray[0]!=null){//Bug 84017
                for(var j=0;j<dbLinkingArray.length;j++){
                    var dbLinkingObject=dbLinkingArray[j];
                    var controls=dbLinkingObject.controls;
                    var data=dbLinkingObject.data;
                    if(data[0]==null){
                        for(var i=0;i<controls.split(",").length;i++){
                            var controlId=controls.split(",")[i].trim();
                            var objComp = document.getElementById(controlId);
                            if(objComp==null)
                            {
                                objComp =  document.getElementsByName(controlId)[0];
                            }
                            if(objComp!=null){
                            if((objComp.type=='text' && objComp.classList.contains("editableCombo")) || objComp.type=='select-one' || objComp.type=='ComboBox' || objComp.type=='select-multiple'){
                                populateComboValuesfromString(controls.split(",")[i],{}, {} , true);
                            }
                            else{
                                 setValue(controls.split(",")[i], "");
                                //json[controls.split(",")[i]] =  "";
                            }
                        }
                        }
                        //setValues(json,true);
                        continue;//Bug 84017
                    }
                    if(controls.split(",").length==1 && Object.keys(data).length==2){
                            populateComboValuesfromString(controls.split(",")[0],data[0],data[1] , true);
                    } 
                    else{
                        for(var i=0;i<controls.split(",").length;i++){
                            if(data[i]==null)
                                break;
                            var objComp = document.getElementById(controls.split(",")[i]);
                            if(objComp==null)
                            {
                                objComp =  document.getElementsByName(controls.split(",")[i])[0];
                            }
                            if(jQuery('#'+ controls.split(",")[i]).attr("type")=='tile'){
                                setTileDataFromDB(controls.split(",")[i],data);
                            } 
                            else if((objComp.type=='text' && objComp.classList.contains("editableCombo")) || objComp.type=='select-one' || objComp.type=='ComboBox' || objComp.type=='select-multiple'){
                                populateComboValuesfromString(controls.split(",")[i],data[i] ,data[i], true);
                            }
                            else{
                                setValue(controls.split(",")[i], data[i][0]);
                                //json[controls.split(",")[i]] =  data[i][0];
                            }
                        }
                        //setValues(json,true);
                    }
                }
            } else if ( jsonObj != null ){
                renderExecuteServerEventAPIData(jsonObj);
            }
            if(window[customAction]){
                window[customAction]();
            }
        }catch(ex){}
    }
    //Bug 81232 End


    function clearNGHTMLViewMap(){
        if(window.closeWorkitemHook){
        closeWorkitemHook();
    }
        closeSubForm();
        var sid = jQuery("#sid").val();
        var context = '/' + window.location.pathname.split("/")[1];
        var url = context + "/components/viewer/cleanSession.jsp";
        var reqTok = iforms.ajax.processRequest("formuri="+encode_utf8(url), context+"/GetReqToken");
        var url="cleanSession.jsp";
        var requestString="pid="+pid+"&wid="+wid+"&taskid="+tid+"&fid="+fid+"&WD_SID=" + sid + "&WD_RID="+reqTok;
        
    if(typeof isProcessSpecific !="undefined"){
        requestString+="&ps=Y";
    }
    
    new net.ContentLoader(url, formHandler, formErrorHandler, "POST", requestString, false);
}

    function saveAndNextTab(tabId){
        saveWorkItem();
        var tabLinks=jQuery("#"+tabId).find("li");
        for(var i=0;i<tabLinks.length;i++){          
            if(tabLinks[i].classList.contains("tablink")&&tabLinks[i].classList.contains("active")&&i!=tabLinks.length-1 ){
                for(var j=i+1;j<tabLinks.length;j++)
                {
                    if(tabLinks[j].style.display != 'none')
                    {
                        $(tabLinks[j].firstChild).trigger("click");
                        jQuery("#" + tabId + " .iformTabUL").each(function () {
                            $(this).scrollingTabs('refresh');
                        });
                        break;
                    }
                }
                break;
            }
        }
    }
    function executeCustomWebService(obj,event,eventType){
        if(window.customWebServicePreHook){
            if(!customWebServicePreHook(obj.id)){
                return;
            }
        }
        var listviewOpened="N";//Bug 82812 Start
        var advancedListviewOpened="N";
        if(document.getElementById("listViewModal")!=null&&document.getElementById("listViewModal").className==="modal in")
            listviewOpened="NG";
        if(document.getElementById("advancedListViewModal")!=null&&document.getElementById("advancedListViewModal").className==="modal in")
            advancedListviewOpened="AG";//Bug 82812 End
        if(eventType!=""){
            var url = "webservice.jsp";
            var requestString = "pid="+encode_utf8(pid)+"&wid="+encode_utf8(wid)+"&tid="+encode_utf8(tid)+"&fid="+encode_utf8(fid)+"&controlId="+encode_utf8(obj.id)+"&eventType="+encode_utf8(eventType)+"&webServiceType=custom";//Bug 75527, Bug 75529
            if(listviewOpened!="N")//Bug 82812 Start
                requestString+="&listviewOpened="+listviewOpened;
            if(advancedListviewOpened!="N")
                requestString+="&advancedListviewOpened="+advancedListviewOpened;//Bug 82812 End
            var contentLoaderRef = new net.ContentLoader(url, customWSResponseHandler, formErrorHandler, "POST", requestString, true);
        }
    }

    function customWSResponseHandler(){
        var output=this.req.responseText;
        var message=this.req.getResponseHeader("message");
        var WSControlId=getQueryVariable(this.params, "controlId");
        if(typeof message !="undefined"&&message !="")//Bug 82907
            showMessage("", message, "error");
        try{
        var responseJSON=JSON.parse(output);
        var outputArray = responseJSON.responseData;
        if(responseJSON.APIData!=null)
            renderExecuteServerEventAPIData(responseJSON.APIData);
        for (var i = 0; i < outputArray.length; i++) 
        {
            for(var j=0;j<outputArray[i].length;j++){
                try{
                var dataArray=outputArray[i][j];
                var controlId=dataArray.id;
                var type=dataArray.type;
                var dataValue=dataArray.value.value;
                if(type=="textarea"||type=="textbox"||type=="label"||type=="combo"||type=="checkbox"
                    ||type=="radio"||type=="datepick"){
                    setValue(controlId, dataValue);
                }
                else if(type=="table"){
                    if(dataArray.isAppendData){
                        $("#"+controlId+ " tbody").html($("#"+controlId+ " tbody").html()+encode_ParamValue(dataValue));
                    }
                    else{
                        $("#"+controlId+ " tbody").html(encode_ParamValue(dataValue));
                    }
                    //$("#"+controlId+ " tbody").appendChild(dataValue);
                    $("#"+controlId).floatThead('reflow');
                    //var dgroupColumns = this.req.getResponseHeader("dgroupColumns");
                    //var maskedLabels = this.req.getResponseHeader("maskedLabels");
                    checkTableHeight(controlId);
                    /*
                    for(var i=0;i<dgroupColumns.split(",").length;i++){
                        var className = "dgroup_"+controlId+"_"+dgroupColumns.split(",")[i];
                        //var dgroupCells = document.getElementsByClassName("dgroup_"+controlId+"_"+dgroupColumns.split(",")[i]);

                        $('.'+className).each(function() {
                            var digitGroup = parseInt(dgroupColumns.split(",")[i].split("_")[1]);
                            var dec = '0';
                            if(jQuery(this).attr('typeofvalue')=='Float')
                                dec = jQuery(this).attr('Precision');
                            jQuery(this).autoNumeric('init',{
                                dGroup: digitGroup,
                                mDec: dec
                            }); 
                        });
                    }
                    */
                    $('.listviewlabel').each(function() {
                        var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
                        if((this.getAttribute("maskingpattern")!="nomasking" && this.getAttribute("maskingpattern")!="")
                            || (typeofvalue=='Float' && this.getAttribute("maskingpattern")=="nomasking"))
                            {
                            maskfield(this,'savedlabel');
                        }

                    });
                $('.tabletextbox').each(function() {
                        var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
                        if((this.getAttribute("maskingpattern")!="nomasking" && this.getAttribute("maskingpattern")!="")
                            || (typeofvalue=='Float' && this.getAttribute("maskingpattern")=="nomasking"))
                            {
                        maskfield(this,'input');
                    }

                });
                    var totalValueElements=document.getElementById('totallabel_'+controlId).innerHTML.split(",!,");
                        for(var k=0;k<totalValueElements.length;k++){
                        //var controlRef = document.getElementById('label'+'_'+controlId+'_'+maskedLabels.split(",")[i]);
                        if(totalValueElements[k]!=''){
                        $(document.getElementsByClassName(totalValueElements[k].replace(/&lt;/g, '<').replace(/&gt;/g, '>').replace(/&quot;/g, '"').replace(/&amp;/g, '&'))).each(function() {
                            var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
                                if((this.getAttribute("maskingpattern")!="nomasking" && this.getAttribute("maskingpattern")!="")
                                    || (typeofvalue=='Float' && this.getAttribute("maskingpattern")=="nomasking"))
                                    {
                                maskfield(this,'label');
                                }
                    });
                        }
                            showTotal('',totalValueElements[k]);
                        }

                if(window.addRowPostHook)
                {
                            addRowPostHook(controlId);
                }
                }
            }
              catch(ex){
                    
                }
            }
        }
        if(window.customWebServicePostHook){
            customWebServicePostHook(WSControlId);
        }
        }
        catch(ex){}
    }

    function openLinkModal(ref){
        $("#iFrameLinkModal").attr('src', $(ref).attr("linkurl"));
        $("#LinkModal").dialog({
           width: $(window).width(),
            height: $(window).height(),
            modal: true,
            zIndex: 9999,
            resizeable: true,
            draggable: false,
            resize: "auto",
            close: function () {
                $("#iFrameLinkModal").attr('src', "about:blank");
            }
        });
        return false;
    }



function subformDone(buttonId){
    var valid = validateMandatoryFields();
    if(!valid){
        if(mobileMode=="ios"||mobileMode=="android")
            document.getElementById("SubFormDone").removeAttribute("data-dismiss");
        return false;
    }
    if(mobileMode=="ios"||mobileMode=="android")
        document.getElementById("SubFormDone").setAttribute("data-dismiss","modal");
    saveRichTextEditorData();
    var bool;
    if(window.subformDoneClick) {
        bool =  subformDoneClick(buttonId);
    }
    if(bool || bool == undefined) {
         if(mobileMode=="ios"||mobileMode=="android"){
             document.getElementById("SubFormDone").setAttribute("data-dismiss","modal");
         }
         else{
            window.close();
         }
    }
    else if(bool==false &&(mobileMode=="ios"||mobileMode=="android")) {
        document.getElementById("SubFormDone").removeAttribute("data-dismiss");
    }
}
//Bug 82814 Start
function bodykeyDown(event){
    if(window.handleCustomKeyEvent)
        handleCustomKeyEvent(event);
    /*
     * var keyCode = event.which || event.keyCode;// to get event key code
     * to check for if key is pressed with ctrl or shift or alt you can check by using given check
     * event.altKey for alt key check
     * event.ctrlKey for ctrl key check
     * event.shiftKey for shift key check
     * 
     * Ex for CTRL+S
     * var keyCode = event.which || event.keyCode;
     * if(keyCode==83&&event.ctrlKey){
     * 
     * }
     */
}//Bug 82814 End

function addDataToAdvancedGrid(tableId,jsonData){
    if(Object.keys(jsonData).length > 0){
        var url = "action_API.jsp";
        var requestString=  "tableId="+tableId +"&addAdvancedGridData=yes"+"&pid="+encode_utf8(pid)+"&wid="+encode_utf8(wid)+"&tid="+encode_utf8(tid)+"&fid="+encode_utf8(fid)+"&RowId="+rowId+"&jsonData="+encode_utf8(JSON.stringify(jsonData));
        var contentLoaderRef = new net.ContentLoader(url, addAdvancedGridDataResponseHandler, ajaxFormErrorHandler, "POST", requestString, false);
        setTableModifiedFlag(tableId);
        attachDatePicker();
    }
    
}

function addAdvancedGridDataResponseHandler(){
    var controlId=getQueryVariable(this.params, "tableId");
    $("#"+controlId+ " tbody").append(this.req.responseText);
    $("#"+controlId).floatThead('reflow');
    $('.listviewlabel').each(function() {
        var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
            if((this.getAttribute("maskingpattern")!="nomasking" && this.getAttribute("maskingpattern")!="")
            || (typeofvalue=='Float' && this.getAttribute("maskingpattern")=="nomasking"))
            {
            maskfield(this,'savedlabel');
        }

    });
    $('.tabletextbox').each(function() {
        var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
            if((this.getAttribute("maskingpattern")!="nomasking" && this.getAttribute("maskingpattern")!="")
            || (typeofvalue=='Float' && this.getAttribute("maskingpattern")=="nomasking"))
            {
            maskfield(this,'input');
        }

    });
    
    $('.openPickerClass').each(function()
        {
            if(this.getAttribute("maskingPattern")!=null && this.getAttribute("maskingPattern")!=undefined && this.getAttribute("maskingPattern")!="" )
            {
                maskfield(this,'input');
            }
        });

    checkTableHeight(controlId);
}
//Bug 83311 Start

function titleMaskingValidation(e,controlId)
{
    control=document.getElementById(controlId);
    var evtObj = window.event || e;
    var keycode = evtObj.keyCode || evtObj.which;
    var max = "";
    if(control !=null){
        if(control.getAttribute("typeofvalue") == "Float" && control.getAttribute("FloatLength") != null 
            && control.getAttribute("FloatLength")!= undefined){
            var dotIndex =control.value.indexOf(".");
//            var decimalValLength = control.getAttribute("floatlength")- control.getAttribute("precision");
            if( dotIndex<0 && keycode != 110 && keycode != 190 ){
                max=control.getAttribute("floatlength")- control.getAttribute("precision");
            }
            else
                max=control.getAttribute("floatlength");
        }
        else if(control.getAttribute("maxlength") != null && control.getAttribute("maxlength")!= undefined){
            max=control.getAttribute("maxlength");
        }
        if(max != null && max !='')
        {
           var ctrlDown = e.ctrlKey||e.metaKey;
        if( (keycode==37 || keycode==39 || keycode==8||keycode==9) || ctrlDown && (keycode==86 ||keycode==67 || keycode==88|| keycode==65))
           return true;
            var value = jQuery("#"+controlId).val();
            var len = value.replace(/[^0-9]/g, "").length;
            if (len >= max ) {
                e.preventDefault();
                return false;
            }
        }
    }
    return true;
}

function TitleCharacterValidation(e,option,textBoxId){
    var ctrlDown = e.ctrlKey||e.metaKey;
    var evtObj = window.event || e;
    var key = evtObj.key;
    var language = (typeof iformLocale == "undefined")? 'en_us': iformLocale;
    var patternStringRef=document.getElementById(textBoxId+"_patternString");
    var validString="";
    if(document.getElementById(textBoxId+"_validationString")!=undefined && document.getElementById(textBoxId+"_validationString")!=null)
        validString=document.getElementById(textBoxId+"_validationString").innerHTML;
    var dataType=document.getElementById(textBoxId).getAttribute("datatype");
    language=language.toLowerCase();
    var keycode = evtObj.keyCode || evtObj.which;
    if(keycode==13 && jQuery(".form-group").find(":password").length==1 ){
       jQuery(".form-group").find(":button").click(); 
    }
    if(ctrlDown && (keycode==86 ||keycode==67 || keycode==88|| keycode==65))
        return true;
    if(option=="2" && (language===""||language.startsWith("en")))
    {
        
            var alpha =patternStringRef.getAttribute("allowAlphabets");
            var space =patternStringRef.getAttribute("allowSpaces");
            var control =document.getElementById(textBoxId);
            var min=control.getAttribute("minvalue");
            var max=control.getAttribute("maxvalue");
            if(alpha==='false'&&space==='false')
            {
                //Bug 91919
                var alphaspaceregex = new RegExp("^[a-zA-Z ]*$");
                if (keycode!=8 && (alphaspaceregex.test(key))) {
                    e.preventDefault();
                    return false;
                }
                //Bug 91919
                if(patternStringRef.getAttribute("specialcharacters").indexOf(key)!==-1)
                {
                    //showMessage(control,key+IS_NOT_ALLOWED,"error"); //Bug 91919
                    return false;
                }
                else if(validString.indexOf(key)===-1)
                {   
                    if(control.value!=""&&key==='-')
                    {
                        showMessage(control,INVALID_POSITION+key,"error");
                        return false; 
                    }    
                    else
                    {   
                        if(control.value.indexOf(key)!==-1&&isNaN(key))
                        {
                            showMessage(control,CANNOT_USE+key+" again","error");
                            return false; 
                        }     
                        var value=control.value+""+key;    
                        if(!isNaN(value))
                        {
                            if(parseFloat(value)<parseFloat(min)&&min!==null)
                            {
                                showMessage(control,MIN_VALUE_ERROR+min,"error");
                                return false;
                            }
                            if(parseFloat(value)>parseFloat(max)&&max!==null)
                            {
                                showMessage(control,MAX_VALUE_ERROR+max,"error");
                                return false;
                            }
                        }
                    }
                } 
                return true;       
            }
        $('#'+textBoxId)[0].onkeypress = function (e) {
            var regex = new RegExp("^[a-zA-Z0-9 ]+$");
            var key = String.fromCharCode(!e.charCode ? e.which : e.charCode);
            if(e.charCode == 8 || e.which==8 || e.charCode == 9 || e.which==9 || e.charCode == 127 || e.which==127 ){  //Bug 88287 
                return true;
            }
            try {
                var allowedSpecialChar = document.getElementById((e.currentTarget.id + '_validationString')).innerHTML;
				if(allowedSpecialChar != undefined && allowedSpecialChar != null) {
					var allowedSelectedSpecialChar = allowedSpecialChar.substring(allowedSpecialChar.indexOf('_') + 1, allowedSpecialChar.length);
					var allowedChar = allowedSelectedSpecialChar.split(',');
					if (allowedChar.includes(key)) {
						return true;
					}
				}
            } catch (ex) {
            }
            if (!regex.test(key)) {
                e.preventDefault();
                return false;
            }
        }
    }
    if(language===""||language.startsWith("en")){
        if(patternStringRef!=null && patternStringRef!=undefined && (dataType.toLowerCase() == 'text' || dataType == 'textarea')){
            if(patternStringRef!=null && patternStringRef!=undefined && (patternStringRef.getAttribute("allowSpaces")==='false' || patternStringRef.getAttribute("allowNumbers")==='false' || patternStringRef.getAttribute("allowAlphabets")==="false")){
                var KeyID = evtObj.keyCode || evtObj.which;
                if(patternStringRef.getAttribute("allowSpaces")==='false'){
                    if(KeyID==32)
                        return false;
                }
                else{
                    if(KeyID==32)
                        return true;
                }
                
                if(patternStringRef.getAttribute("allowNumbers")==='false'){
                    if(KeyID>=48&&KeyID<=57&&!e.shiftKey)
                        return false;
                    if(KeyID>=96&&KeyID<=105&&!e.shiftKey)
                        return false;
                }
                else{
                    if(KeyID>=48&&KeyID<=57)
                        return true;
                }
                if(patternStringRef.getAttribute("allowAlphabets")==='false'){
                    if(KeyID>=65&&KeyID<=90)
                        return false;
                }
            }
        }
    }
    return true;
}

if (!String.prototype.startsWith) {
    String.prototype.startsWith = function(searchString, position){
      position = position || 0;
      return this.substr(position, searchString.length) === searchString;
  };
}

//Bug 83311 End

function setCustomPattern(controlId,pattern)
{
    var control=document.getElementById(controlId);
    if(useCustomIdAsControlName && (control==null || control==undefined)){
            control = document.getElementsByName(controlId)[0];
            if(control != null && control != undefined)
                controlId = control.getAttribute("id");
        }
    if(control !=null)
    {
//        control.setAttribute("custompattern",pattern);
        document.getElementById(controlId+"_patternString").setAttribute("custompattern",pattern);
        document.getElementById(controlId+"_patternString").innerHTML = pattern;
    }
}
function setCustomMasking(controlId,dgroup,adec,asep,asign,psign,decimal)
{
    var control = document.getElementById(controlId);
    if(useCustomIdAsControlName && (control==null || control==undefined)){
            control = document.getElementsByName(controlId)[0];
            if(control != null && control != undefined)
                controlId = control.getAttribute("id");
        }
    try{
        $(control).autoNumeric('destroy');
    }
    catch(ex){}
    jQuery(control).autoNumeric('init',{
        aSign: asign, 
        dGroup: dgroup,
        pSign:psign, 
        mDec: decimal,
        aDec: adec,
        aSep: asep
    });
}

function setMaskingPattern(controlId,pattern){
    var control=document.getElementById(controlId);
     if(useCustomIdAsControlName && (control==null || control==undefined)){
            control = document.getElementsByName(controlId)[0];
            if(control != null && control != undefined)
                controlId = control.getAttribute("id");
        }
    if(control!=null){
        var newPattern=pattern;
        if(pattern==="Pincode"){
            newPattern="000-000";
        }
        else if(pattern==="Email"){
            newPattern="email";
        }
        else if(pattern==="Dollar"){
            newPattern="currency_dollar";
        }
        else if(pattern==="Rupees"){
            newPattern="currency_rupees";
        }
        else if(pattern==="Yen"){
            newPattern="currency_yen";
        }
        else if(pattern==="Euro"){
            newPattern="currency_euro";
        }
        else if(pattern==="French"){
            newPattern="currency_french";
        }
        else if(pattern==="Greek"){
            newPattern="currency_greek";
        }
        else if(pattern==="Percentage"){
            newPattern="percentage";
        }
        else if(pattern==="USFormat"){
            newPattern="dgroup3";
        }
        else if(pattern==="IndianFormat"){
            newPattern="dgroup2";
        }
        else if(pattern==="Mobile"){
            newPattern="(00) 0000000000";
        }
        else if(pattern==="No Zero Padding"){
            newPattern="NZP";
        }
        else if(pattern===""||pattern==="Clear"){
            newPattern="nomasking";
        }
        var cleanValue=getValue(controlId);
        control.setAttribute("maskingPattern", newPattern);
        try{
            $(control).autoNumeric('destroy');
        }
        catch(ex){}
        try{
            $(control).unmask();
        }
        catch(ex){}
        $(control).each(function() {
            var max=this.getAttribute("rangemax");
            var min=this.getAttribute("rangemin");
            var typeofvalue=typeof this.getAttribute("typeofvalue")=='undefined'?'':this.getAttribute("typeofvalue");
            var precision=typeof this.getAttribute("Precision")=='undefined'?'2':this.getAttribute("Precision");
            var decimal='2';
            if(typeofvalue =="Float")
                decimal=precision;
            if(typeofvalue =="Integer")
                decimal='0';
            if(typeofvalue =="Long")
                decimal='0';

            if(this.getAttribute("maskingPattern").toString()!='nomasking'&&this.getAttribute("maskingPattern").toString()!=''){
            if(this.getAttribute("maskingPattern").toString()!='currency_rupees' && this.getAttribute("maskingPattern").toString()!=='currency_dollar' && this.getAttribute("maskingPattern").toString()!=='currency_yen' && this.getAttribute("maskingPattern").toString()!=='currency_euro' && this.getAttribute("maskingPattern").toString()!=='currency_french' && this.getAttribute("maskingPattern").toString()!=='currency_greek' && this.getAttribute("maskingPattern").toString()!=='' && this.getAttribute("maskingPattern").toString()!=='percentage'){
                    var placeholder;
                    if(this.getAttribute("maskingPattern").toString().charAt(this.getAttribute("maskingPattern").toString().length-1)!='$'){
                        if(this.getAttribute("maskingPattern").toString()=='dgroup3' || this.getAttribute("maskingPattern").toString()=='dgroup2'){
                            var digitGroup = parseInt(this.getAttribute("maskingPattern").charAt(this.getAttribute("maskingPattern").length-1));
                            jQuery(this).autoNumeric('init',{
                                dGroup: digitGroup,
                                mDec: decimal                                

                            });
                            if(cleanValue!=='')
                                jQuery(this).autoNumeric('set', cleanValue);
                        }
                        else{
                            if(typeofvalue=='Float' && this.getAttribute("maskingPattern").toString()=='NZP'){
                                jQuery(this).autoNumeric('init',{
                                    aSep : '',  
                                    aDec: '.', 
                                    mDec: decimal,
                                    aPad: false
                                });
                                if(cleanValue!=='')
                                    jQuery(this).autoNumeric('set', cleanValue);
                            }
                            else{
                                placeholder=this.getAttribute("maskingPattern").replace(/[A-Za-z0-9*#]/mg , "_");
                                jQuery(this).mask(this.getAttribute("maskingPattern"), {
                                    placeholder: placeholder
                                }, {
                                    clearIfNotMatch: true
                                });
                                setValue(controlId, cleanValue);
                                ctrOnchangeHandler(control,1);
                                return true;//Bug 79052
                            }
                        }
                    }
                }

                else{
                    var asign='';
                    var dgroup='';
                    var psign='p';
                var adec='.';
                var asep=',';
                    if(this.getAttribute("maskingPattern").toString()==='currency_rupees'){
                        asign='Rs ';
                        dgroup=2;
                    //                    jQuery(this).autoNumeric('init',{aSign: 'Rs ', dGroup: 2 , vMax: max, vMin: min});
                    }
                    else if(this.getAttribute("maskingPattern").toString()==='currency_dollar'){
                        asign='$ ';
                        dgroup=3;
                    //                        psign='s';
                    //                    jQuery(this).autoNumeric('init',{aSign: ' $', dGroup: 3,pSign: 's' ,vMax: max, vMin: min});
                    }
                    else if(this.getAttribute("maskingPattern").toString()==='currency_yen'){
                        asign='¥ ';
                        dgroup=3;
                    //                    jQuery(this).autoNumeric('init',{aSign: '¥ ', dGroup: 3, vMax: max, vMin: min});
                    }
                    else if(this.getAttribute("maskingPattern").toString()==='currency_euro'){
                        asign='€ ';
                        dgroup=3;
                    //                    jQuery(this).autoNumeric('init',{aSign: '€ ', dGroup: 3, vMax: max, vMin: min});
                    }
                else if(this.getAttribute("maskingPattern").toString()==='currency_french'){
                    asign='';
                    dgroup=3;
                    adec = ',';
                    asep = ' ';
                    psign= 's';
                //                    jQuery(this).autoNumeric('init',{aSign: '€ ', dGroup: 3, vMax: max, vMin: min});
                }
                else if(this.getAttribute("maskingPattern").toString()==='currency_greek'){
                    dgroup=3;
                    adec = ',';
                    asep = '.';
                    psign= 's';
                //                    jQuery(this).autoNumeric('init',{aSign: '€ ', dGroup: 3, vMax: max, vMin: min});
                }
                    if(this.getAttribute("maskingPattern").toString()!=='percentage' && this.getAttribute("maskingPattern").toString() !=='currency_yen' ){
                        if(max===null)
                            jQuery(this).autoNumeric('init',{
                                aSign: asign, 
                                dGroup: dgroup,
                                pSign:psign,
                                mDec: decimal,
                            aNeg:true,
                            aDec: adec,
                            aSep: asep
                            });
                        else{
                            jQuery(this).autoNumeric('init',{
                                aSign: asign, 
                                dGroup: dgroup,
                                pSign:psign, 
                            mDec: decimal,
                            aDec: adec,
                            aSep: asep
                            });
                        }
                    }
                    else if(this.getAttribute("maskingPattern").toString() =='currency_yen'){
                            if(max===null)
                                jQuery(this).autoNumeric('init',{
                                    aSign: asign, 
                                    dGroup: dgroup,
                                    pSign:psign,
                                    mDec: "0",
                                aNeg:true,
                                aDec: adec,
                                aSep: asep
                                });
                            else{
                                jQuery(this).autoNumeric('init',{
                                    aSign: asign, 
                                    dGroup: dgroup,
                                    pSign:psign, 
                                mDec: "0",
                                aDec: adec,
                                aSep: asep
                                });
                            }
                        }

                    else{
                        jQuery(this).autoNumeric('init',{
                            aSign: " %", 
                            pSign:'s',
                            mDec: decimal
                        });//Bug 81106
                    }
                    if(cleanValue!=='')
                        jQuery(this).autoNumeric('set', cleanValue);
                }

            }
            
            setValue(controlId, cleanValue);
            ctrOnchangeHandler(control,1);
        });
    }
}
function attachZoneBehaviour(ref ,zName,zLeft, zoneTop, zWidth, zHeight){
    var final_width = parseInt(zLeft) + parseInt(zWidth);
    var final_height = parseInt(zoneTop) + parseInt(zHeight);
    if( window.preHookZoneGotFocus){
        var arr = preHookZoneGotFocus(zName,zLeft, zoneTop, final_width, final_height,ref.id);
        zLeft = arr[0];
        zoneTop = arr[1];
        final_width = arr[2];
        final_height = arr[3];
    }
    window.parent.ZoneGotFocus(zLeft, zoneTop, final_width, final_height,zName); 
}
 
 function deAttachZone()
{
    window.parent.ZoneLostFocus();
}

function removeFeatureFromRichTextEditor(){
    var selListJson = selectFeatureToBeIncludedInRichText();
    var commaSeparatedList = "";
    for( var key in selListJson ){
        if(!selListJson[key] ){
            commaSeparatedList += key +",";
        }
    }    
    commaSeparatedList = commaSeparatedList.substring(0,commaSeparatedList.length-1);   
    return commaSeparatedList;
}

function displayTableCells(controlId,rowIndex,colIndices,displayFlag){
    var tableRef = document.getElementById(controlId);
    var row = tableRef.tBodies[0].getElementsByTagName("tr")[rowIndex];
    var cells = row.getElementsByTagName("td");
    for(var i=1;i<=cells.length;i++){
        for(var j=0;j<colIndices.length;j++){
            if((i-1)==colIndices[j])
                cells[i].style.display=displayFlag?"":"none";
        }
    }
    $("#"+controlId).floatThead('reflow');
}
//Bug 83424 Start
function getCellControl(tableId,rowIndex,colIndex){
    var tableRef = document.getElementById(tableId);
    var row = tableRef.tBodies[0].getElementsByTagName("tr")[rowIndex];
    if(row != null && row != undefined)
    { 
        var cell = row.getElementsByTagName("td")[colIndex + 1];
        if (cell != null && cell != undefined){
            return cell.getElementsByClassName("control-class")[0];
        }
    }
}

function addItemInTableCellCombo(tableId,rowIndex,colIndex,label,value,tooltip,optionControlId){
    var combo=getCellControl(tableId,rowIndex,colIndex);
    if(combo!=null&&combo!=undefined&&combo.type=='select-one' || combo.type=='ComboBox')
    {
        var option;
        var selectedValue=combo.value;
        if (combo.tagName == 'SELECT') {
            for( var len = combo.options.length-1 ; len >= 0 ; len-- ){
                if( combo.options[len].text === label ){
                    combo.remove(len);
            }   
            }
        }
        else{//Bug 83222 Start
            var ul = combo.parentNode.childNodes[2];
            for(var i=ul.childNodes.length-1;i>=0;i--){
                if(ul.childNodes[i].innerHTML==label)
                    ul.removeChild(ul.childNodes[i]);
            }
        }//Bug 83222 End 
        option = document.createElement('option');        
        if (combo.tagName == 'SELECT') {
            if( typeof optionControlId != "undefined" ){
                option.id = optionControlId;
            }
            if (typeof label != "undefined" && typeof value == "undefined" && typeof tooltip == "undefined") {
                option.text = label;
                combo.add(option);
            }
            if (typeof label != "undefined" && typeof value != "undefined" && typeof tooltip == "undefined") {
                option.text = label;
                option.value = value;
                combo.add(option);
            }

            if (typeof label != "undefined" && typeof value != "undefined" && typeof tooltip !== "undefined") {
                option.text = label;
                option.value = value;
                option.setAttribute("data-toggle", "tooltip");
                option.title = tooltip;
                combo.add(option);                              
            }
            /*if(combo.multiple){
                reloadListBoxLayout(comboId);
            }*/
        } else {
            var liElem = document.createElement('li');
            if( typeof optionControlId != "undefined" ){
                liElem.id = optionControlId;
            }
            if (typeof label != "undefined" && typeof value == "undefined" && typeof tooltip == "undefined") {
                liElem.appendChild(document.createTextNode(label));
            }
            if (typeof label != "undefined" && typeof value != "undefined" && typeof tooltip == "undefined") {
                liElem.appendChild(document.createTextNode(label));
                liElem.setAttribute("value", value);
            }

            if (typeof label != "undefined" && typeof value != "undefined" && typeof tooltip !== "undefined") {
                liElem.appendChild(document.createTextNode(label));
                liElem.setAttribute("value", value);
                liElem.title = tooltip;
            }
            var ul = combo.parentNode.childNodes[2];
            liElem.style.display = "block";
            ul.appendChild(liElem);
        }
        //Bug 81099 If a field is mapped , the mapped field is coming twice in a dropdown
        combo.value=selectedValue;
    }
}
function clearTableCellCombo(tableId,rowIndex,colIndex){
    var combo=getCellControl(tableId,rowIndex,colIndex);
    if(combo!=null&&combo!=undefined&&combo.type=='select-one' || combo.type=='ComboBox')
    {
       // setTableCellData(tableId,rowIndex,colIndex,"",false);
        if(combo.type== "text"){
            var ul = combo.parentNode.childNodes[2];
            ul.innerHTML='';
        }else
            combo.options.length = 0;
        addItemInTableCellCombo(tableId,rowIndex,colIndex,"Select","");
        if(combo.type!="select-multiple" && combo.type!="text")
            combo.value= combo.options[0].value;
        else if(combo.type== "text"){
            combo.title=ul.childNodes[0].innerHTML;
            combo.value=ul.childNodes[0].innerHTML;
        }
    }
}

function removeItemFromTableCellCombo(tableId,rowIndex,colIndex,itemIndex){
    var combo=getCellControl(tableId,rowIndex,colIndex);
    if (combo != null && combo != undefined)
    {
        combo.remove(itemIndex);
    }
    /*if(combo.multiple){
        reloadListBoxLayout(comboId);
    }*/
}
//Bug 83424 End
function getBrowserScrollSize(){

    var css = {
        "border":  "none",
        "height":  "200px",
        "margin":  "0",
        "padding": "0",
        "width":   "200px"
    };

    var inner = $("<div>").css($.extend({}, css));
    var outer = $("<div>").css($.extend({
        "left":       "-1000px",
        "overflow":   "scroll",
        "position":   "absolute",
        "top":        "-1000px"
    }, css)).append(inner).appendTo("body")
    .scrollLeft(1000)
    .scrollTop(1000);

    var scrollSize = {
        "height": (outer.offset().top - inner.offset().top) || 0,
        "width": (outer.offset().left - inner.offset().left) || 0
    };

    outer.remove();
    return scrollSize;
}
function setWidthForTabStyle4(){
    $(".iformTabControl").each(function(){
        var buttonsWidth=0;
        var buttonsDiv=$(this).find('.tabButtonsDiv');
        if(buttonsDiv[0]!=undefined){
            var child=buttonsDiv[0].children;
            for(var j=0;j<child.length;j++){
                buttonsWidth+=child[j].clientWidth+5;
            }
            buttonsDiv[0].style.width=buttonsWidth+"px";
            var tabDiv=$(this).find('.tabDiv');
            tabDiv[0].style.width="calc(100% - "+buttonsWidth+"px)";
        }
    });
}

function multiSelectListView(ref,controlId)
    {
        var rowIndex = $(ref).closest('tr').index();
        var table = document.getElementById(controlId);
        if (table != null && table != undefined)
        {
            if(table.rows[rowIndex+1].classList.contains("highlightedRow"))
                table.rows[rowIndex+1].classList.remove("highlightedRow");
            else
                table.rows[rowIndex+1].classList.add("highlightedRow");
//            if (document.getElementById(controlId).getAttribute("ismultiselect") == "no")
            if(document.getElementById("select_"+controlId).style.display == "none")
            {
                var checks = document.getElementById(controlId).getElementsByClassName('selectRow');
                for(var i=0;i<checks.length;i++)
                {
                    if(i!=parseInt(rowIndex) && checks[i].checked){
                        checks[i].checked = false;
                    }
                }
                
            }
        }
}

function initFloatingMessagesForPrimitiveFields(controlClass){
    $(controlClass).tooltipster({
        repositionOnScroll:true,
        debug:false,
        functionBefore:function(instance,helper){
            if(($(helper.origin).find('.mndErrorMsgDiv')[0]!=null&&$(helper.origin).find('.mndErrorMsgDiv')[0].hasAttribute("showMessage"))
            ||($(helper.origin).find('.ptrnErrorMsgDiv')[0]!=null&&$(helper.origin).find('.ptrnErrorMsgDiv')[0].hasAttribute("showMessage"))){
                var newContent="";
                if($(helper.origin).find('.mndErrorMsgDiv')[0]!=null&&$(helper.origin).find('.mndErrorMsgDiv')[0].hasAttribute("showMessage"))
                    newContent=$(helper.origin).find('.mndErrorMsgDiv')[0].innerHTML;
                else if($(helper.origin).find('.ptrnErrorMsgDiv')[0]!=null&&$(helper.origin).find('.ptrnErrorMsgDiv')[0].hasAttribute("showMessage"))
                    newContent=$(helper.origin).find('.ptrnErrorMsgDiv')[0].innerHTML;
                instance.content(newContent);
            }
            else{
                return false;
            }
        },
        functionAfter:function(instance, helper){
            if(controlClass == ".controlCustomCss"){
            jQuery(".tooltipster-content").removeClass("customControlTitle");
            jQuery(".tooltipster-arrow").removeClass("customControl-arrow");
            }
        },
        functionReady:function(instance,helper){
            if(jQuery(helper.origin).find("select") != undefined && jQuery(helper.origin).find("select").attr("combotype")=="listbox" 
                && controlClass == ".errorMessageHoverDiv"){
                jQuery(".tooltipster-content").addClass("customControlTitle");
                jQuery(".tooltipster-arrow").addClass("customControl-arrow");
            }
            if (instance._$tooltip) {
                var boundingRect = helper.origin.getBoundingClientRect();
                var tTop = instance.__lastPosition.coord.top;
                var tHeight = instance._$tooltip[0].clientHeight;
                var tBottom = tTop + tHeight;
                var topDiff = tBottom - boundingRect.top;
                if (topDiff > 0) {
                    instance._$tooltip[0].style.top = tTop - topDiff + "px";
                }
            }
        },
        functionPosition:function(instance,helper,position){
            var boundingRect=helper.origin.getBoundingClientRect();
            position.coord.left=boundingRect.left+10;
            position.target=boundingRect.left+10;
            if(boundingRect.width-10<position.size.width)
                position.size.width=boundingRect.width-10;
            if(position.coord.top>boundingRect.bottom-1)
                position.coord.top=boundingRect.bottom-1;
            position.size.height="";
            return position;
        }
    });
}
function initFloatingMessagesForTableCells(){
    $(".tabletextbox").each(function() {
        $(this).closest("td").tooltipster({
            repositionOnScroll:true,
            debug:false,
        functionBefore:function(instance,helper){
            if($(helper.origin).find('.icon-errorMessageIconClass')[0]==null){
                return false;
            }
        },
        functionReady:function(instance,helper){
            if (instance._$tooltip) {
                var boundingRect = helper.origin.getBoundingClientRect();
                var tTop = instance.__lastPosition.coord.top;
                var tHeight = instance._$tooltip[0].clientHeight;
                var tBottom = tTop + tHeight;
                var topDiff = tBottom - boundingRect.top;
                if (topDiff > 0) {
                    instance._$tooltip[0].style.top = tTop - topDiff + "px";
                }
            }
        },
        functionPosition:function(instance,helper,position){
            var boundingRect=helper.origin.getBoundingClientRect();
            position.coord.left=boundingRect.left+10;
            position.target=boundingRect.left+10;
            if(boundingRect.width-10<position.size.width)
                position.size.width=boundingRect.width-10;
            if(position.coord.top>boundingRect.bottom-1)
                position.coord.top=boundingRect.bottom-1;
            position.size.height="";
            return position;
        }
        });
    });
}

function getFeatureForRichTextEditor(){
    var selListJson = selectFeatureToBeIncludedInRichText();
    var commaSeparatedList = [];
    for( var key in selListJson ){
        if(selListJson[key] ){
            //commaSeparatedList +="'"+ key +"',";
            commaSeparatedList.push(key);
        }
    }    
    //commaSeparatedList = '['+commaSeparatedList.substring(0,commaSeparatedList.length-1)+']';   
    
    return commaSeparatedList;
}

function clearComponentMap(listViewType){
     var listViewControls = document.getElementsByClassName('tableControl');
     var advancedListviewControls=document.getElementsByClassName('advancedListviewControl');
     var componentmap=Object.keys(ComponentValidatedMap);
        if(componentmap.length!=0){
             if(listViewType=="listview"){
                for(var j=0;j<listViewControls.length;j++){
                    for(var k=0;k<componentmap.length;k++){
                     if(componentmap[k]==listViewControls[j].id){                  
                         delete ComponentValidatedMap[componentmap[k]];
                     }
                     }                   
                }
             }
            else if(listViewType=="advancedlistview"){
                for(var j=0;j<advancedListviewControls.length;j++){
                    for(var k=0;k<componentmap.length;k++){
                     if(componentmap[k]==advancedListviewControls[j].id){                    
                         delete ComponentValidatedMap[componentmap[k]];
                     }
                     }                     
                }        
            }        
        }
}
function constraintOnPaste(ref,evt)
{
    var max = ref.getAttribute("maxlength");
    if(max == null)
        max = ref.getAttribute("floatlength");
	var typeofvalue = ref.getAttribute("typeofvalue");
	if(typeofvalue != null)
    typeofvalue = typeofvalue.toUpperCase();	
    setTimeout(function () {
        var validation=0;
        var patternStringRef=document.getElementById(ref.id+"_patternString");
        var letters = /^[A-Za-z]+$/;
        for(var i=0;i<ref.value.length&&validation!=1;i++)
        {
            var character=ref.value[i];
            if(patternStringRef.getAttribute("allowSpaces")==='false')
            {
                if(character==" ")
                {
                    validation=1;
                    showMessage(ref,SPACE_NOT_ALLOWED, "error");
                }
            }    
            if(patternStringRef.getAttribute("allowNumbers")==='false')
            {
                if(!c_isNaN(character)) 
                {
                    validation=1;
                    showMessage(ref,NUMBER_NOT_ALLOWED, "error");
                }         
            } 
            if(patternStringRef.getAttribute("allowAlphabets")==='false')
            {
                if(character.match(letters)) 
                {
                    validation=1;
                    showMessage(ref,ALPHABET_NOT_ALLOWED, "error");
                }      
            }
            if(patternStringRef.getAttribute("specialcharacters")!='')
            {
                if(!character.match(letters)&&isNaN(character)&&character!=" ")
                {
                    if(patternStringRef.getAttribute("specialcharacters").indexOf(character)>=0) 
                    {
                        validation=1;
                        showMessage(ref,character +NOT_ALLOWED, "error");
                    }      
                } 
            }
        } 
        if(validation==1)
        {
            ref.value="";
        }

    }, 100);
    if (max != null)
    {
        if (evt.clipboardData && ref.getAttribute("precision").length > 0 && typeofvalue ==='FLOAT') 
        {

            var strClipBoardData = removeLeadingAndTrailingZero(evt.clipboardData.getData('text/plain'));
            if (strClipBoardData.indexOf('.') != -1)
            {
                var clipboardprecis_len = strClipBoardData.substring(strClipBoardData.indexOf('.') + 1).length;
                var clipboardfloat_len = strClipBoardData.substring(0, strClipBoardData.indexOf('.')).length;
            } else
            {
                clipboardfloat_len = strClipBoardData.length;
                clipboardprecis_len = 0;
            }
            var floatprecision = ref.getAttribute("precision");

            if (clipboardprecis_len > floatprecision || (clipboardfloat_len > max - floatprecision))
            {
                showMessage(ref, CORRECT_VALUE + ' > ' + strClipBoardData, "error");
                cancelBubble();
                ref.value = "";
            }
        } else if (window.clipboardData && ref.getAttribute("precision").length > 0 && typeofvalue ==='FLOAT')
        {

            var strClipBoardData = removeLeadingAndTrailingZero(window.clipboardData.getData('text'));
            if (strClipBoardData.indexOf('.') != -1)
            {
                var clipboardprecis_len = strClipBoardData.substring(strClipBoardData.indexOf('.') + 1).length;
                var clipboardfloat_len = strClipBoardData.substring(0, strClipBoardData.indexOf('.')).length;
            } else
            {
                clipboardfloat_len = strClipBoardData.length;
                clipboardprecis_len = 0;
            }

            var floatprecision = ref.getAttribute("precision");

            if (clipboardprecis_len > floatprecision || (clipboardfloat_len > max - floatprecision))
            {
                showMessage(ref, CORRECT_VALUE + ' > ' + strClipBoardData, "error");
                cancelBubble();
                ref.value = "";
            }
        } else if (evt.clipboardData && (evt.clipboardData.getData('text/plain').length > max))
        {
            showMessage(ref, ONLY_FIRST + max + ONPASTE_MSG + max, "error");
        } else if (window.clipboardData && (window.clipboardData.getData('text').length > max))
        {
            showMessage(ref, ONLY_FIRST + max + ONPASTE_MSG + max, "error");
        }
    }
}

function removeLeadingAndTrailingZero(floatVal) // this function removes leading and trailing 0s in float
{
    var regEx1 = /^[0]+/;
    var regEx2 = /[0]+$/;
    var regEx3 = /[.]$/;
    var after = '';
    after = floatVal.replace(regEx1,'');  // Remove leading 0's
    if (after.indexOf('.')>-1){
        after = after.replace(regEx2,'');  // Remove trailing 0's
    }
    after = after.replace(regEx3,''); 
    return after;
}

function TableCellCharacterValidation(ref,event){
    var evtObj = window.event || event;
    var language = (typeof iformLocale == "undefined")? 'en_us': iformLocale;
    var allowAlphabets = ref.getAttribute("alphanum").split("-")[0];
    var allowSpaces = ref.getAttribute("alphanum").split("-")[1];
    var allowNumbers = ref.getAttribute("alphanum").split("-")[2];
    var allowSpecialchars = ref.getAttribute("alphanum").split("-")[3];
    language=language.toLowerCase();
    if(allowSpecialchars=='N')
    {
        $(ref).on('keypress', function (e) {
            var regex = new RegExp("^[a-zA-Z0-9 ]+$");
            var key = String.fromCharCode(!e.charCode ? e.which : e.charCode);
            if (!regex.test(key)) {
                e.preventDefault();
                return false;
            }
        });
    }
    if(language===""||language.startsWith("en")){
        
        if(allowAlphabets==='N' || allowSpaces==='N' || allowNumbers==="N"){
            var KeyID = evtObj.keyCode || evtObj.which;
            if(allowSpaces==='N'){
                if(KeyID==32)
                    return false;
            }
            else{
                if(KeyID==32)
                    return true;
            }
                
            if(allowNumbers==='N'){
                if(KeyID>=48&&KeyID<=57&&!event.shiftKey)
                    return false;
                if(KeyID>=96&&KeyID<=105&&!event.shiftKey)
                        return false;
            }
            else{
                if(KeyID>=48&&KeyID<=57)
                    return true;
            }
            if(allowAlphabets==='N'){
                if(KeyID>=65&&KeyID<=90)
                    return false;
            }
            else{
                if(KeyID>=65&&KeyID<=90)
                    return true;
            }
           
        }
       
    }
    return true;
}

function getSectionList()
{
    var sectionList=document.getElementsByClassName("FrameControl");
    var jsonobj={};
    for(var i=0;i<sectionList.length;i++)
        jsonobj[sectionList[i].id]=sectionList[i].childNodes[0].getAttribute("state");
    return jsonobj;
}
//Bug 84965 
function stopFormRefreshing(e){
        var kc = (e.charCode) ? e.charCode : ((e.which) ? e.which : e.keyCode);
        if(kc==123){
            cancelBubble(e);
        }
        if(kc==8 )
        {   
            var ele = e.srcElement;
            if( ele == null )
                ele = e.target;
            if( ( ele.tagName != "INPUT" &&  ele.tagName != "TEXTAREA" ) || ele.readOnly || ele.getAttribute("disabled") == "disabled" )
               cancelBubble(e);
        }
}
function cancelBubble(e) 
{
        var evt = e ? e:window.event;
        if (evt.stopPropagation)
        {
            evt.stopPropagation();
            evt.preventDefault();
        }
        if (evt.cancelBubble!=null || evt.cancelBubble!=true)
        {
            evt.cancelBubble = true;
            evt.returnValue = false;
        }
}

function showFullScreen(iFrameId){
    var iframe = document.getElementById(iFrameId);
    iframe.style.position = "fixed";
    iframe.style.bottom = "0px";
    iframe.style.right = "0px";
    iframe.style.border = "none";
    iframe.style.margin = "0";
    iframe.style.padding = "0";
    iframe.style.overflow = "hidden";
    iframe.style.zIndex = "5999";
    iframe.style.height = "100%";
    iframe.style.top = "25px";
    
    var fsImage = document.getElementById("fullScreenImage_"+iFrameId);
    var fsDiv = document.getElementById("fullScreenDiv_"+iFrameId);
    fsImage.classList.remove("glyphicon-fullscreen");
    fsImage.classList.add("glyphicon-resize-small");
    fsImage.style.border="1px solid";
    fsImage.style.fontSize="20px";
    
    fsImage.onclick = function() {escapeFullScreen(iFrameId);}
    

    fsDiv.style.left="0px";
    fsDiv.style.top="0px";
    fsDiv.style.width="100%";
    fsDiv.style.position="fixed";
    fsDiv.style.zIndex="6000";
    fsDiv.style.background="white";
}
function escapeFullScreen(iFrameId){
    var iframe = document.getElementById(iFrameId);
    iframe.style.position = "";
    iframe.style.bottom = "";
    iframe.style.right = "";
    iframe.style.margin = "";
    iframe.style.padding = "";
    iframe.style.overflow = "";
    iframe.style.zIndex = "";
    iframe.style.height = "";
    iframe.style.top = "";
     
    var fsImage = document.getElementById("fullScreenImage_"+iFrameId);
    var fsDiv = document.getElementById("fullScreenDiv_"+iFrameId);
    fsImage.classList.remove("glyphicon-resize-small");
    fsImage.classList.add("glyphicon-fullscreen");
    fsImage.style.border="";
    fsImage.style.fontSize="";
    fsImage.onclick = function() {showFullScreen(iFrameId);}
    
    fsDiv.style.width="";
    fsDiv.style.top="";
    fsDiv.style.left="";
    fsDiv.style.position="";
    fsDiv.style.zIndex="";
    fsDiv.style.background="";
}

function c_isNaN(character){
    if(character==' ' || character==" " || character==""||character=='')
        return true;
    return isNaN(character);
}

function authorizePortalLogin(ref,evt){
    var requestString = "pid="+encode_utf8(pid)+"&wid="+encode_utf8(wid)+"&tid="+encode_utf8(tid)+"&fid="+encode_utf8(fid);       
    var url="auth.jsp";
    var contentLoaderRef = new net.ContentLoader(url, formHandler, formErrorHandler, "POST", requestString, false);
}

function highlightSel(ref)
{
    if(ref.closest('td').classList.contains("highlightedCell"))
        ref.closest('td').classList.remove("highlightedCell");
    else
        ref.closest('td').classList.add("highlightedCell");
}

function highlightAddDelRow(ref)
{
    if(ref.classList.contains("hightlightAddDeleteRow"))
        ref.classList.remove("hightlightAddDeleteRow");
    else
        ref.classList.add("hightlightAddDeleteRow");
}
//Bug 91554 
function showCustomCtrlToolTip(ref){
    var id=ref.firstElementChild.id;
    var str="";
    var controls=jQuery(ref).find(".active");
    jQuery(ref).find("button").removeAttr("title");
    if(controls.length=== 0)
        return;
    for(var i=0;i<controls.length;i++){
        var option=controls[i];
        var value=jQuery(option).find("label").text();
        
        if(i=== controls.length-1){
            str +=value;
        }
        else{
           if(value.trim()!="Select all")
            str +=value+", ";
        }
    }
    
    document.getElementById(id+"_msg").innerHTML=str;
    document.getElementById(id +"_msg").setAttribute("showMessage","true");
    jQuery(".tooltipster-box").addClass("customControlTitle");
}
function removeControlTooltip(ref){
    var id=ref.firstElementChild.id;
    if(id != undefined && id != null && document.getElementById(id +"_msg")!= undefined && document.getElementById(id +"_msg")!= null){
        document.getElementById(id +"_msg").removeAttribute("showMessage");
        document.getElementById(id+"_msg").innerHTML="";
        jQuery(".tooltipster-box").removeClass("customControlTitle");
    }
}