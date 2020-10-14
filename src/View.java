
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.Color;






public class View extends JFrame {
	private JTextField textFieldStudentSSN;
	private JTextField textFieldStudentName;
	private JTextField textFieldStudentPhoneNumber;
	private JTextField textFieldStudentAddress;
	private JButton btnStudentAdd;
	private JTextField textFieldStudentSearch;
	private JButton btnStudentSearch;
	private JButton btnStudentClearSearch;
	private JScrollPane scrollPaneStudent;
	private JTable tableStudent;
	private JButton btnStudentDelete;
	private JLabel labelResponsStudent;

	private JTextField textFieldCourseCode;
	private JTextField textFieldCourseName;
	private JComboBox comboBoxCourseCredit;
	private JButton btnCourseAdd;
	private JTextField textFieldCourseSearch;
	private JButton btnCourseClearSearch;
	private JButton btnCourseSearch;
	private JScrollPane scrollPaneCourse;
	private JTable tableCourse;
	private JButton btnCourseDelete;
	private JLabel labelResponsCourse;
	
	private JComboBox comboBoxRegisterStudent;
	private JComboBox comboBoxRegisterCourse;
	private JButton btnRegister;
	private JComboBox comboBoxRegisterGrade;
	private JButton btnRegisterCompletedCourse;
	private JScrollPane scrollPaneRegister;
	private JTable tableRegister;
	private JButton btnRegisterUnregister;
	private JLabel labelResponsRegister;

	private JTable tableRegistry;
	private JButton btnRegistryFilter;
	private JScrollPane scrollPaneRegistry;
	private JComboBox comboBoxRegistryCourse;
	private JComboBox comboBoxRegistryStudent;
	private JLabel labelResponsRegistry;

	private JButton btnStatisticThroughput;
	private JScrollPane scrollPaneThroughput;
	private JTable tableStatisticThroughput;
	private JComboBox comboBoxStatisticCourse;
	private JScrollPane scrollPaneStatisticA;
	private JButton btnStatisticShowResult;
	private JTable tableStatisticA;
	private JLabel labelResponsStatistic;
	


	 // Create the frame.

	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1026, 557);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1009, 517);
		getContentPane().add(tabbedPane);
		
		JPanel studentPanel = new JPanel();
		tabbedPane.addTab("Student", null, studentPanel, null);
		studentPanel.setLayout(null);
		
		JLabel lblAddStudent = new JLabel("ADD STUDENT");
		lblAddStudent.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddStudent.setBounds(30, 24, 146, 22);
		studentPanel.add(lblAddStudent);
		
		JLabel lblStudent1 = new JLabel("Please fill in the following \r\n");
		lblStudent1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStudent1.setBounds(30, 100, 362, 20);
		studentPanel.add(lblStudent1);
		
		JLabel lblStudent2 = new JLabel("information about the student");
		lblStudent2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStudent2.setBounds(30, 118, 362, 20);
		studentPanel.add(lblStudent2);
		
		JLabel lblStudent3 = new JLabel("then press add student");
		lblStudent3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStudent3.setBounds(30, 136, 362, 20);
		studentPanel.add(lblStudent3);
		
		JLabel lblStudentSSN = new JLabel("Social security number * (YYMMDDXXXX)");
		lblStudentSSN.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStudentSSN.setBounds(30, 180, 250, 14);
		studentPanel.add(lblStudentSSN);
		
		textFieldStudentSSN = new JTextField();
		textFieldStudentSSN.setBounds(30, 205, 147, 20);
		studentPanel.add(textFieldStudentSSN);
		textFieldStudentSSN.setColumns(10);
		
		JLabel lblStudentName = new JLabel("Name *");
		lblStudentName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStudentName.setBounds(30, 236, 49, 14);
		studentPanel.add(lblStudentName);
		
		textFieldStudentName = new JTextField();
		textFieldStudentName.setBounds(30, 261, 220, 20);
		studentPanel.add(textFieldStudentName);
		textFieldStudentName.setColumns(10);
		
		JLabel lblStudentPhoneNumber = new JLabel("Phone number *");
		lblStudentPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStudentPhoneNumber.setBounds(30, 292, 92, 14);
		studentPanel.add(lblStudentPhoneNumber);
		
		textFieldStudentPhoneNumber = new JTextField();
		textFieldStudentPhoneNumber.setBounds(30, 317, 147, 20);
		studentPanel.add(textFieldStudentPhoneNumber);
		textFieldStudentPhoneNumber.setColumns(10);
		
		JLabel lblStudentAddress = new JLabel("Address *");
		lblStudentAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStudentAddress.setBounds(30, 348, 66, 14);
		studentPanel.add(lblStudentAddress);
		
		textFieldStudentAddress = new JTextField();
		textFieldStudentAddress.setBounds(30, 373, 220, 20);
		studentPanel.add(textFieldStudentAddress);
		textFieldStudentAddress.setColumns(10);
		
		btnStudentAdd = new JButton("Add student");
		btnStudentAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnStudentAdd.setBounds(30, 423, 120, 23);
		studentPanel.add(btnStudentAdd);
		
		JLabel lblAllStudents = new JLabel("ALL STUDENTS");
		lblAllStudents.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAllStudents.setBounds(325, 24, 250, 22);
		studentPanel.add(lblAllStudents);
		
		JLabel lblSearchStudent = new JLabel("Enter social security number");
		lblSearchStudent.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSearchStudent.setBounds(469, 60, 180, 14);
		studentPanel.add(lblSearchStudent);
		
		JLabel lblSearchStudent2 = new JLabel("(YYMMDDXXXX)");
		lblSearchStudent2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSearchStudent2.setBounds(500, 75, 112, 14);
		studentPanel.add(lblSearchStudent2);
		
		textFieldStudentSearch = new JTextField();
		textFieldStudentSearch.setBounds(640, 64, 80, 20);
		studentPanel.add(textFieldStudentSearch);
		textFieldStudentSearch.setColumns(10);
		
		btnStudentSearch = new JButton("Search");
		btnStudentSearch.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnStudentSearch.setBounds(735, 64, 89, 23);
		studentPanel.add(btnStudentSearch);
		
		btnStudentClearSearch = new JButton("Clear search");
		btnStudentClearSearch.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnStudentClearSearch.setBounds(833, 64, 120, 23);
		studentPanel.add(btnStudentClearSearch);
		
		scrollPaneStudent = new JScrollPane();
		scrollPaneStudent.setBounds(325, 97, 628, 301);
		studentPanel.add(scrollPaneStudent);
		
		tableStudent = new JTable();
		scrollPaneStudent.setViewportView(tableStudent);
		
		JLabel lblSelectStudent = new JLabel("Select the student in the table above ");
		lblSelectStudent.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSelectStudent.setBounds(620, 427, 220, 14);
		studentPanel.add(lblSelectStudent);
		
		btnStudentDelete = new JButton("Delete student");
		btnStudentDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnStudentDelete.setBounds(833, 423, 120, 23);
		studentPanel.add(btnStudentDelete);
		
		labelResponsStudent = new JLabel("");
		labelResponsStudent.setForeground(new Color(178, 34, 34));
		labelResponsStudent.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelResponsStudent.setBounds(180, 423, 420, 22);
		studentPanel.add(labelResponsStudent);
		
		JPanel coursePanel = new JPanel();
		tabbedPane.addTab("Course", null, coursePanel, null);
		coursePanel.setLayout(null);
		
		JLabel lblAddCourse = new JLabel("ADD COURSE");
		lblAddCourse.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddCourse.setBounds(30, 24, 250, 22);
		coursePanel.add(lblAddCourse);
		
		JLabel lblCourse1 = new JLabel("Please fill in the following \r\n");
		lblCourse1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCourse1.setBounds(30, 100, 362, 20);
		coursePanel.add(lblCourse1);
		
		JLabel lblCourse2 = new JLabel("information about the course");
		lblCourse2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCourse2.setBounds(30, 118, 362, 20);
		coursePanel.add(lblCourse2);
		
		JLabel lblCourse3 = new JLabel("then press add student");
		lblCourse3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCourse3.setBounds(30, 136, 362, 20);
		coursePanel.add(lblCourse3);
		
		JLabel lblCourseCode = new JLabel("Course code * (CXXX)");
		lblCourseCode.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCourseCode.setBounds(30, 180, 250, 14);
		coursePanel.add(lblCourseCode);
		
		textFieldCourseCode = new JTextField();
		textFieldCourseCode.setBounds(30, 205, 147, 20);
		coursePanel.add(textFieldCourseCode);
		textFieldCourseCode.setColumns(10);
		
		JLabel lblCourseName = new JLabel("Course name *");
		lblCourseName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCourseName.setBounds(30, 236, 102, 14);
		coursePanel.add(lblCourseName);
		
		textFieldCourseName = new JTextField();
		textFieldCourseName.setBounds(30, 261, 220, 20);
		coursePanel.add(textFieldCourseName);
		textFieldCourseName.setColumns(10);
		
		JLabel lblCourseCredit = new JLabel("Course credit *");
		lblCourseCredit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCourseCredit.setBounds(30, 292, 92, 14);
		coursePanel.add(lblCourseCredit);
		
		comboBoxCourseCredit = new JComboBox();
		comboBoxCourseCredit.setBounds(30, 317, 147, 22);
		coursePanel.add(comboBoxCourseCredit);
		
		btnCourseAdd = new JButton("Add course");
		btnCourseAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCourseAdd.setBounds(30, 423, 120, 23);
		coursePanel.add(btnCourseAdd);
		
		JLabel lblAllCourses = new JLabel("ALL COURSES");
		lblAllCourses.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAllCourses.setBounds(325, 24, 250, 22);
		coursePanel.add(lblAllCourses);
		
		JLabel lblSearchCourseCode = new JLabel("Enter course code");
		lblSearchCourseCode.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSearchCourseCode.setBounds(530, 60, 120, 14);
		coursePanel.add(lblSearchCourseCode);
		
		JLabel lblSearchCourse2 = new JLabel("(CXXX)");
		lblSearchCourse2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSearchCourse2.setBounds(555, 75, 80, 14);
		coursePanel.add(lblSearchCourse2);
		
		textFieldCourseSearch = new JTextField();
		textFieldCourseSearch.setColumns(10);
		textFieldCourseSearch.setBounds(640, 64, 80, 20);
		coursePanel.add(textFieldCourseSearch);
		
		btnCourseSearch = new JButton("Search");
		btnCourseSearch.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCourseSearch.setBounds(735, 64, 89, 23);
		coursePanel.add(btnCourseSearch);
		
		btnCourseClearSearch = new JButton("Clear search");
		btnCourseClearSearch.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCourseClearSearch.setBounds(833, 64, 120, 23);
		coursePanel.add(btnCourseClearSearch);
		
		scrollPaneCourse = new JScrollPane();
		scrollPaneCourse.setBounds(325, 97, 628, 301);
		coursePanel.add(scrollPaneCourse);
		
		tableCourse = new JTable();
		scrollPaneCourse.setViewportView(tableCourse);
		
		JLabel lblSelectCourse = new JLabel("Select the course in the table above");
		lblSelectCourse.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSelectCourse.setBounds(620, 427, 213, 14);
		coursePanel.add(lblSelectCourse);
		
		btnCourseDelete = new JButton("Delete course");
		
		btnCourseDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCourseDelete.setBounds(833, 423, 120, 23);
		coursePanel.add(btnCourseDelete);
		
		labelResponsCourse = new JLabel("");
		labelResponsCourse.setForeground(new Color(178, 34, 34));
		labelResponsCourse.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelResponsCourse.setBounds(180, 423, 420, 22);
		coursePanel.add(labelResponsCourse);
		
		JPanel RegisterPanel = new JPanel();
		tabbedPane.addTab("Register", null, RegisterPanel, null);
		RegisterPanel.setLayout(null);
		
		JLabel lblRegister = new JLabel("REGISTER A STUDENT ON A COURSE");
		lblRegister.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRegister.setBounds(30, 24, 320, 22);
		RegisterPanel.add(lblRegister);
		
		JLabel lblRegister1 = new JLabel("Please select a student\r\n\r\n");
		lblRegister1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRegister1.setBounds(30, 100, 362, 20);
		RegisterPanel.add(lblRegister1);
		
		JLabel lblRegister2 = new JLabel("and a course");
		lblRegister2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRegister2.setBounds(30, 118, 362, 20);
		RegisterPanel.add(lblRegister2);
		
		JLabel lblRegister3 = new JLabel("then press register");
		lblRegister3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRegister3.setBounds(30, 136, 362, 20);
		RegisterPanel.add(lblRegister3);
		
		JLabel lblRegisterStudent = new JLabel("Student *");
		lblRegisterStudent.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRegisterStudent.setBounds(30, 180, 133, 14);
		RegisterPanel.add(lblRegisterStudent);
		
		comboBoxRegisterStudent = new JComboBox();
		comboBoxRegisterStudent.setToolTipText("");
		comboBoxRegisterStudent.setBounds(30, 205, 275, 22);
		RegisterPanel.add(comboBoxRegisterStudent);
		
		JLabel lblRegisterCourse = new JLabel("Course *");
		lblRegisterCourse.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRegisterCourse.setBounds(30, 236, 133, 14);
		RegisterPanel.add(lblRegisterCourse);
		
		comboBoxRegisterCourse = new JComboBox();
		comboBoxRegisterCourse.setBounds(30, 261, 275, 22);
		RegisterPanel.add(comboBoxRegisterCourse);
		
		btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegister.setBounds(30, 423, 120, 23);
		RegisterPanel.add(btnRegister);
		
		JLabel lblAllRegister = new JLabel("ALL REGISTERED STUDENTS AND COURSES");
		lblAllRegister.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAllRegister.setBounds(325, 24, 400, 22);
		RegisterPanel.add(lblAllRegister);
		
		JLabel lblRegisterGrade1 = new JLabel("Select the row where you want to add a grade and\r\n");
		lblRegisterGrade1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRegisterGrade1.setBounds(420, 60, 305, 14);
		RegisterPanel.add(lblRegisterGrade1);
		
		JLabel lblRegisterGrade2 = new JLabel("select a grade in the box then press complete course ");
		lblRegisterGrade2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRegisterGrade2.setBounds(420, 75, 305, 14);
		RegisterPanel.add(lblRegisterGrade2);
		
		comboBoxRegisterGrade = new JComboBox();
		comboBoxRegisterGrade.setBounds(735, 64, 50, 22);
		RegisterPanel.add(comboBoxRegisterGrade);
		
		btnRegisterCompletedCourse = new JButton("Completed course");
		btnRegisterCompletedCourse.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegisterCompletedCourse.setBounds(813, 64, 140, 23);
		RegisterPanel.add(btnRegisterCompletedCourse);
		
		scrollPaneRegister = new JScrollPane();
		scrollPaneRegister.setBounds(325, 97, 628, 301);
		RegisterPanel.add(scrollPaneRegister);
		
		tableRegister = new JTable();
		scrollPaneRegister.setViewportView(tableRegister);
		
		JLabel lblUnRegister = new JLabel("Select the row you want to unregister");
		lblUnRegister.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUnRegister.setBounds(620, 427, 220, 14);
		RegisterPanel.add(lblUnRegister);
		
		btnRegisterUnregister = new JButton("Unregister");
		btnRegisterUnregister.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegisterUnregister.setForeground(new Color(0, 0, 0));
		btnRegisterUnregister.setBounds(833, 423, 120, 23);
		RegisterPanel.add(btnRegisterUnregister);
		
		labelResponsRegister = new JLabel("");
		labelResponsRegister.setForeground(new Color(178, 34, 34));
		labelResponsRegister.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelResponsRegister.setBounds(180, 423, 420, 22);
		RegisterPanel.add(labelResponsRegister);
		
		JPanel panelRegistry = new JPanel();
		panelRegistry.setToolTipText("");
		tabbedPane.addTab("Registry", null, panelRegistry, null);
		panelRegistry.setLayout(null);
		
		JLabel lblRegistry = new JLabel("FILTER RESULTS");
		lblRegistry.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRegistry.setBounds(30, 24, 320, 22);
		panelRegistry.add(lblRegistry);
		
		JLabel lblRegistry1 = new JLabel("If you want to filter the result");
		lblRegistry1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRegistry1.setBounds(30, 100, 362, 20);
		panelRegistry.add(lblRegistry1);
		
		JLabel lblRegistry2 = new JLabel("choose student and/or course");
		lblRegistry2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRegistry2.setBounds(30, 118, 362, 20);
		panelRegistry.add(lblRegistry2);
		
		JLabel lblRegistry3 = new JLabel("then press filter");
		lblRegistry3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRegistry3.setBounds(30, 136, 362, 20);
		panelRegistry.add(lblRegistry3);
		
		JLabel lblRegistryStudent = new JLabel("Student");
		lblRegistryStudent.setBounds(30, 180, 133, 14);
		panelRegistry.add(lblRegistryStudent);
		
		comboBoxRegistryStudent = new JComboBox();
		comboBoxRegistryStudent.setBounds(30, 205, 275, 22);
		panelRegistry.add(comboBoxRegistryStudent);
		
		JLabel lblRegistryCourse = new JLabel("Course");
		lblRegistryCourse.setBounds(30, 236, 133, 14);
		panelRegistry.add(lblRegistryCourse);
		
		comboBoxRegistryCourse = new JComboBox();
		comboBoxRegistryCourse.setBounds(30, 261, 275, 22);
		panelRegistry.add(comboBoxRegistryCourse);
		
		btnRegistryFilter = new JButton("Filter");
		btnRegistryFilter.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegistryFilter.setBounds(30, 427, 120, 23);
		panelRegistry.add(btnRegistryFilter);
		
		JLabel lblRegistryResult = new JLabel("RESULTS FOR STUDENTS AND COURSES");
		lblRegistryResult.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRegistryResult.setBounds(325, 24, 320, 22);
		panelRegistry.add(lblRegistryResult);
		
		scrollPaneRegistry = new JScrollPane();
		scrollPaneRegistry.setBounds(325, 97, 628, 301);
		panelRegistry.add(scrollPaneRegistry);
		
		tableRegistry = new JTable();
		scrollPaneRegistry.setViewportView(tableRegistry);
		
		labelResponsRegistry = new JLabel("");
		labelResponsRegistry.setForeground(new Color(178, 34, 34));
		labelResponsRegistry.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelResponsRegistry.setBounds(180, 423, 420, 22);
		panelRegistry.add(labelResponsRegistry);
		
		JPanel statisticPanel = new JPanel();
		statisticPanel.setToolTipText("");
		tabbedPane.addTab("Statistic", null, statisticPanel, null);
		statisticPanel.setLayout(null);
		
		JLabel lblStatisticThroughput = new JLabel("COURSE THROUGHPUT");
		lblStatisticThroughput.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStatisticThroughput.setBounds(30, 27, 200, 22);
		statisticPanel.add(lblStatisticThroughput);
		
		JLabel lblSatistic1 = new JLabel("Press throughput to see the current");
		lblSatistic1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSatistic1.setBounds(30, 100, 362, 20);
		statisticPanel.add(lblSatistic1);
		
		JLabel lblStatistic2 = new JLabel("course with the highest throughput");
		lblStatistic2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStatistic2.setBounds(30, 118, 362, 20);
		statisticPanel.add(lblStatistic2);
		
		btnStatisticThroughput = new JButton("Throughput");
		btnStatisticThroughput.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnStatisticThroughput.setBounds(30, 149, 140, 23);
		statisticPanel.add(btnStatisticThroughput);
		
		JLabel lblStatisticA = new JLabel("PERCENTAGE OF STUDENTS WHO HAVE RECEIVED THE GRADE A ON COURSES");
		lblStatisticA.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStatisticA.setBounds(325, 24, 628, 22);
		statisticPanel.add(lblStatisticA);
		
		JLabel lblASelect = new JLabel("Select a course in the box then press show result ");
		lblASelect.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblASelect.setBounds(325, 100, 441, 20);
		statisticPanel.add(lblASelect);
		
		comboBoxStatisticCourse = new JComboBox();
		comboBoxStatisticCourse.setBounds(325, 149, 275, 22);
		statisticPanel.add(comboBoxStatisticCourse);
		
		labelResponsStatistic = new JLabel("");
		labelResponsStatistic.setForeground(new Color(178, 34, 34));
		labelResponsStatistic.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelResponsStatistic.setBounds(325, 292, 420, 22);
		statisticPanel.add(labelResponsStatistic);
		
		scrollPaneThroughput = new JScrollPane();
		scrollPaneThroughput.setBounds(30, 200, 250, 70);
		statisticPanel.add(scrollPaneThroughput);
		
		tableStatisticThroughput = new JTable();
		scrollPaneThroughput.setViewportView(tableStatisticThroughput);
		
		scrollPaneStatisticA = new JScrollPane();
		scrollPaneStatisticA.setBounds(325, 200, 450, 70);
		statisticPanel.add(scrollPaneStatisticA);
		
		tableStatisticA = new JTable();
		scrollPaneStatisticA.setViewportView(tableStatisticA);
		
		btnStatisticShowResult = new JButton("Show result");
		btnStatisticShowResult.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnStatisticShowResult.setBounds(635, 149, 140, 23);
		statisticPanel.add(btnStatisticShowResult);
	}


	public JTextField getTextFieldStudentSSN() {
		return textFieldStudentSSN;
	}


	public void setTextFieldStudentSSN(JTextField textFieldStudentSSN) {
		this.textFieldStudentSSN = textFieldStudentSSN;
	}


	public JTextField getTextFieldStudentName() {
		return textFieldStudentName;
	}


	public void setTextFieldStudentName(JTextField textFieldStudentName) {
		this.textFieldStudentName = textFieldStudentName;
	}


	public JTextField getTextFieldStudentPhoneNumber() {
		return textFieldStudentPhoneNumber;
	}


	public void setTextFieldStudentPhoneNumber(JTextField textFieldStudentPhoneNumber) {
		this.textFieldStudentPhoneNumber = textFieldStudentPhoneNumber;
	}


	public JTextField getTextFieldStudentAddress() {
		return textFieldStudentAddress;
	}


	public void setTextFieldStudentAddress(JTextField textFieldStudentAddress) {
		this.textFieldStudentAddress = textFieldStudentAddress;
	}


	public JButton getBtnAddStudent() {
		return btnStudentAdd;
	}


	public void setBtnAddStudent(JButton btnAddStudent) {
		this.btnStudentAdd = btnAddStudent;
	}


	public JTextField getTextFieldSearchStudent() {
		return textFieldStudentSearch;
	}


	public void setTextFieldSearchStudent(JTextField textFieldSearchStudent) {
		this.textFieldStudentSearch = textFieldSearchStudent;
	}


	public JButton getBtnSearchStudent() {
		return btnStudentSearch;
	}


	public void setBtnSearchStudent(JButton btnSearchStudent) {
		this.btnStudentSearch = btnSearchStudent;
	}


	public JButton getBtnClearSearchStudent() {
		return btnStudentClearSearch;
	}


	public void setBtnClearSearchStudent(JButton btnClearSearchStudent) {
		this.btnStudentClearSearch = btnClearSearchStudent;
	}


	public JScrollPane getScrollPaneStudent() {
		return scrollPaneStudent;
	}


	public void setScrollPaneStudent(JScrollPane scrollPaneStudent) {
		this.scrollPaneStudent = scrollPaneStudent;
	}


	public JTable getTableStudent() {
		return tableStudent;
	}


	public void setTableStudent(JTable tableStudent) {
		this.tableStudent = tableStudent;
	}


	public JButton getBtnDeleteStudent() {
		return btnStudentDelete;
	}


	public void setBtnDeleteStudent(JButton btnDeleteStudent) {
		this.btnStudentDelete = btnDeleteStudent;
	}


	public JLabel getLabelResponsStudent() {
		return labelResponsStudent;
	}


	public void setLabelResponsStudent(JLabel labelResponsStudent) {
		this.labelResponsStudent = labelResponsStudent;
	}


	public JTextField getTextFieldCourseCode() {
		return textFieldCourseCode;
	}


	public void setTextFieldCourseCode(JTextField textFieldCourseCode) {
		this.textFieldCourseCode = textFieldCourseCode;
	}


	public JTextField getTextFieldCourseName() {
		return textFieldCourseName;
	}


	public void setTextFieldCourseName(JTextField textFieldCourseName) {
		this.textFieldCourseName = textFieldCourseName;
	}


	public JComboBox getComboBoxCourseCredit() {
		return comboBoxCourseCredit;
	}


	public void setComboBoxCourseCredit(JComboBox comboBoxCourseCredit) {
		this.comboBoxCourseCredit = comboBoxCourseCredit;
	}


	public JButton getBtnAddCourse() {
		return btnCourseAdd;
	}


	public void setBtnAddCourse(JButton btnAddCourse) {
		this.btnCourseAdd = btnAddCourse;
	}


	public JTextField getTextFieldSearchCourse() {
		return textFieldCourseSearch;
	}


	public void setTextFieldSearchCourse(JTextField textFieldSearchCourse) {
		this.textFieldCourseSearch = textFieldSearchCourse;
	}


	public JButton getBtnClearSearchCourse() {
		return btnCourseClearSearch;
	}


	public void setBtnClearSearchCourse(JButton btnClearSearchCourse) {
		this.btnCourseClearSearch = btnClearSearchCourse;
	}


	public JButton getBtnSearchCourse() {
		return btnCourseSearch;
	}


	public void setBtnSearchCourse(JButton btnSearchCourse) {
		this.btnCourseSearch = btnSearchCourse;
	}


	public JScrollPane getScrollPaneCourse() {
		return scrollPaneCourse;
	}


	public void setScrollPaneCourse(JScrollPane scrollPaneCourse) {
		this.scrollPaneCourse = scrollPaneCourse;
	}


	public JTable getTableCourse() {
		return tableCourse;
	}


	public void setTableCourse(JTable tableCourse) {
		this.tableCourse = tableCourse;
	}


	public JButton getBtnDeleteCourse() {
		return btnCourseDelete;
	}


	public void setBtnDeleteCourse(JButton btnDeleteCourse) {
		this.btnCourseDelete = btnDeleteCourse;
	}


	public JLabel getLabelResponsCourse() {
		return labelResponsCourse;
	}


	public void setLabelResponsCourse(JLabel labelResponsCourse) {
		this.labelResponsCourse = labelResponsCourse;
	}


	public JComboBox getComboBoxRegisterStudent() {
		return comboBoxRegisterStudent;
	}


	public void setComboBoxRegisterStudent(JComboBox comboBoxRegisterStudent) {
		this.comboBoxRegisterStudent = comboBoxRegisterStudent;
	}


	public JComboBox getComboBoxRegisterCourse() {
		return comboBoxRegisterCourse;
	}


	public void setComboBoxRegisterCourse(JComboBox comboBoxRegisterCourse) {
		this.comboBoxRegisterCourse = comboBoxRegisterCourse;
	}


	public JButton getBtnRegister() {
		return btnRegister;
	}


	public void setBtnRegister(JButton btnRegister) {
		this.btnRegister = btnRegister;
	}


	public JComboBox getComboBoxGrade() {
		return comboBoxRegisterGrade;
	}


	public void setComboBoxGrade(JComboBox comboBoxGrade) {
		this.comboBoxRegisterGrade = comboBoxGrade;
	}


	public JButton getBtnCompletedCourse() {
		return btnRegisterCompletedCourse;
	}


	public void setBtnCompletedCourse(JButton btnCompletedCourse) {
		this.btnRegisterCompletedCourse = btnCompletedCourse;
	}


	public JScrollPane getScrollPaneRegister() {
		return scrollPaneRegister;
	}


	public void setScrollPaneRegister(JScrollPane scrollPaneRegister) {
		this.scrollPaneRegister = scrollPaneRegister;
	}


	public JTable getTableRegister() {
		return tableRegister;
	}


	public void setTableRegister(JTable tableRegister) {
		this.tableRegister = tableRegister;
	}


	public JButton getBtnUnregister() {
		return btnRegisterUnregister;
	}


	public void setBtnUnregister(JButton btnUnregister) {
		this.btnRegisterUnregister = btnUnregister;
	}


	public JLabel getLabelResponsRegister() {
		return labelResponsRegister;
	}


	public void setLabelResponsRegister(JLabel labelResponsRegister) {
		this.labelResponsRegister = labelResponsRegister;
	}


	public JTable getTableRegistry() {
		return tableRegistry;
	}


	public void setTableRegistry(JTable tableRegistry) {
		this.tableRegistry = tableRegistry;
	}


	public JButton getBtnRegistryFilter() {
		return btnRegistryFilter;
	}


	public void setBtnRegistryFilter(JButton btnRegistryFilter) {
		this.btnRegistryFilter = btnRegistryFilter;
	}


	public JScrollPane getScrollPaneRegistry() {
		return scrollPaneRegistry;
	}


	public void setScrollPaneRegistry(JScrollPane scrollPaneRegistry) {
		this.scrollPaneRegistry = scrollPaneRegistry;
	}


	public JComboBox getComboBoxRegistryCourse() {
		return comboBoxRegistryCourse;
	}


	public void setComboBoxRegistryCourse(JComboBox comboBoxRegistryCourse) {
		this.comboBoxRegistryCourse = comboBoxRegistryCourse;
	}


	public JComboBox getComboBoxRegistryStudent() {
		return comboBoxRegistryStudent;
	}


	public void setComboBoxRegistryStudent(JComboBox comboBoxRegistryStudent) {
		this.comboBoxRegistryStudent = comboBoxRegistryStudent;
	}


	public JLabel getLabelResponsRegistry() {
		return labelResponsRegistry;
	}


	public void setLabelResponsRegistry(JLabel labelResponsRegistry) {
		this.labelResponsRegistry = labelResponsRegistry;
	}
	
	

	public JButton getBtnThroughput() {
		return btnStatisticThroughput;
	}


	public void setBtnThroughput(JButton btnThroughput) {
		this.btnStatisticThroughput = btnThroughput;
	}


	public JTable getTableStatisticThroughput() {
		return tableStatisticThroughput;
	}


	public void setTableStatisticThroughput(JTable tableStatisticThroughput) {
		this.tableStatisticThroughput = tableStatisticThroughput;
	}


	public JLabel getLabelResponsStatistic() {
		return labelResponsStatistic;
	}


	public void setLabelResponsStatistic(JLabel labelResponsStatistic) {
		this.labelResponsStatistic = labelResponsStatistic;
	}



	public JTable getTableStatisticA() {
		return tableStatisticA;
	}


	public void setTableStatisticA(JTable tableStatisticA) {
		this.tableStatisticA = tableStatisticA;
	}


	public JComboBox getComboBoxStatisticCourse() {
		return comboBoxStatisticCourse;
	}


	public void setComboBoxStatisticCourse(JComboBox comboBoxStatisticCourse) {
		this.comboBoxStatisticCourse = comboBoxStatisticCourse;
	}


	public JScrollPane getScrollPaneThroughput() {
		return scrollPaneThroughput;
	}


	public void setScrollPaneThroughput(JScrollPane scrollPaneThroughput) {
		this.scrollPaneThroughput = scrollPaneThroughput;
	}


	public JScrollPane getScrollPaneStatisticA() {
		return scrollPaneStatisticA;
	}


	public void setScrollPaneStatisticA(JScrollPane scrollPaneStatisticA) {
		this.scrollPaneStatisticA = scrollPaneStatisticA;
	}


	public JButton getBtnStatisticShowResult() {
		return btnStatisticShowResult;
	}


	public void setBtnStatisticShowResult(JButton btnStatisticShowResult) {
		this.btnStatisticShowResult = btnStatisticShowResult;
	}
}
