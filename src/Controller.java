

import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Controller {
	private ResultSet resultSet;
	private DefaultTableModel modelCourse = new DefaultTableModel();
	private DefaultTableModel modelStudent = new DefaultTableModel();
	private DefaultTableModel modelRegister = new DefaultTableModel();
	private DefaultTableModel modelHasStudied = new DefaultTableModel();
	private DefaultTableModel modelStatistics = new DefaultTableModel();
	private DefaultTableModel modelThroughputStatistics = new DefaultTableModel();
	private String selectedCourseCode;
	private String selectedSSN;
	private String selectedCourseCodeRegister;
	private String selectedSSNRegister;
	private String ssnSearch;
	private String courseCodeSearch;
	private String ssnFilter;
	private String courseCodeFilter;
	private String selectedCourseCodeStatistics;
	private final int MAXCREDITS = 45;

	View view = new View();
	DAL dal = new DAL();

	public Controller(View view, DAL dal) { 
		this.dal = dal;
		this.view = view;
		fillTables();
		fillComboBoxes();
		actionListners();
	}

	public void sqlExceptions(SQLException exception) {
		if (exception.getErrorCode() == 0) {
			JOptionPane.showMessageDialog(view, "Connection problems! Check your internet connection.");
		} else {
			JOptionPane.showMessageDialog(view, "Unknown error, please try again or contact Service Desk");
		}

	}

	public void closeResultSet(ResultSet resultSet) {
		try {
			resultSet.close();
			dal.close();
		} catch (SQLException sqlException) {
			sqlExceptions(sqlException);
		}
	}

	public void resultSetIteratorCourse(ResultSet rs, int arrayLenght) {
		try {
			while (rs.next()) {
				Object[] objects = new Object[arrayLenght];
				for (int i = 0; i < objects.length; i++) {
					objects[i] = rs.getObject(i + 1);
				}
				modelCourse.addRow(objects);

			}
		} catch (SQLException sqlException) {
			sqlExceptions(sqlException);
		} finally {
			closeResultSet(rs);
		}

	}

	public void resultSetIteratorStudent(ResultSet rs, int arrayLenght) {
		try {
			while (rs.next()) {
				Object[] objects = new Object[arrayLenght];
				for (int i = 0; i < objects.length; i++) {
					objects[i] = rs.getObject(i + 1);
				}
				modelStudent.addRow(objects);

			}
		} catch (SQLException sqlException) {
			sqlExceptions(sqlException);

		}

		finally {
			closeResultSet(rs);
		}

	}

	public void resultSetIteratorRegister(ResultSet rs, int arrayLenght) {
		try {
			while (rs.next()) {
				Object[] objects = new Object[arrayLenght];
				for (int i = 0; i < objects.length; i++) {
					objects[i] = rs.getObject(i + 1);
				}
				modelRegister.addRow(objects);

			}
		} catch (SQLException sqlException) {
			sqlExceptions(sqlException);

		}

		finally {
			try {
				rs.close();
			} catch (SQLException sqlException) {
				sqlExceptions(sqlException);
			}
		}

	}

	public void resultSetIteratorRegistry(ResultSet rs, int arrayLength) {
		try {
			while (rs.next()) {
				Object[] objects = new Object[arrayLength];
				for (int i = 0; i < objects.length; i++) {
					objects[i] = rs.getObject(i + 1);
				}
				modelHasStudied.addRow(objects);

			}
		} catch (SQLException sqlException) {
			sqlExceptions(sqlException);
		} finally {
			closeResultSet(rs);
		}

	}

	public void fillTables() {
//FILL COURSE TABLE
		modelCourse.setRowCount(0);
		modelCourse.setColumnCount(0);
		Object[] columnNamesCourses = { "Code", "Name", "Credits" };
		modelCourse.setColumnIdentifiers(columnNamesCourses);
		view.getTableCourse().setModel(modelCourse);

		// Loads the data from the DAL

		try {
			resultSet = dal.findAllCourses();
			resultSetIteratorCourse(resultSet, columnNamesCourses.length); 
																			

		} catch (SQLException sqlException) {
			sqlExceptions(sqlException);
		} finally {
			closeResultSet(resultSet);
		}
//FILL STUDENT TABLE
		modelStudent.setRowCount(0);
		modelStudent.setColumnCount(0);
		Object[] columnNamesStudents = { "SSN", "Name", "PhoneNumber", "Address" };
		modelStudent.setColumnIdentifiers(columnNamesStudents);
		view.getTableStudent().setModel(modelStudent);

		try {
			resultSet = dal.findAllStudents();
			resultSetIteratorStudent(resultSet, columnNamesStudents.length);

		} catch (SQLException sqlException) {
			sqlExceptions(sqlException);
		} finally {
			closeResultSet(resultSet);
		}
// FILL REGISTER TABLE
		modelRegister.setRowCount(0);
		modelRegister.setColumnCount(0);
		Object[] columnNamesRegister = { "SSN", "Name", "CourseCode" };
		modelRegister.setColumnIdentifiers(columnNamesRegister);
		view.getTableRegister().setModel(modelRegister);

		try {
			resultSet = dal.findAllStudentAndCoursesFromStudies();
			resultSetIteratorRegister(resultSet, columnNamesRegister.length);

		} catch (SQLException sqlException) {
			sqlExceptions(sqlException);
		} finally {
			closeResultSet(resultSet);
		}
//FILL HASSTUDIED TABLE
		modelHasStudied.setRowCount(0);
		modelHasStudied.setColumnCount(0);
		Object[] columnNamesHasStudied = { "Ssn", "Name", "CourseCode", "Grade" };
		modelHasStudied.setColumnIdentifiers(columnNamesHasStudied);
		view.getTableRegistry().setModel(modelHasStudied);
		// Loads the data from the DAL
		try {
			resultSet = dal.findAllStudentAndCoursesFromHasStudied();
			resultSetIteratorRegistry(resultSet, columnNamesHasStudied.length);

		} catch (SQLException sqlException) {
			sqlExceptions(sqlException);
		} finally {
			closeResultSet(resultSet);
		}
	}

	public void filterStudentTable() {

		if (ssnSearch != null) {
			modelStudent.setRowCount(0);
			modelStudent.setColumnCount(0);
			Object[] columnNamesStudents = { "SSN", "Name", "PhoneNumber", "Address" }; 
			modelStudent.setColumnIdentifiers(columnNamesStudents);
			view.getTableStudent().setModel(modelStudent);

			try {
				resultSet = dal.findStudent(ssnSearch);
				resultSetIteratorStudent(resultSet, columnNamesStudents.length);

			} catch (SQLException sqlException) {
				sqlExceptions(sqlException);

			} finally {
				closeResultSet(resultSet);
			}
		}
	}

	public void filterCourseTable() {

		if (courseCodeSearch != null) {
			modelCourse.setRowCount(0);
			modelCourse.setColumnCount(0);
			Object[] columnNamesCourses = { "Code", "Name", "Credits" };
			modelCourse.setColumnIdentifiers(columnNamesCourses);
			view.getTableCourse().setModel(modelCourse);

			try {
				resultSet = dal.findCourse(courseCodeSearch);
				resultSetIteratorCourse(resultSet, columnNamesCourses.length);

			} catch (SQLException sqlException) {
				sqlExceptions(sqlException);
			} finally {
				closeResultSet(resultSet);
			}
		}
	}

	public void fillComboBoxes() {
		// ComboBox Grade
		view.getComboBoxGrade().removeAllItems();
		view.getComboBoxGrade().addItem("-");
		view.getComboBoxGrade().addItem("A");
		view.getComboBoxGrade().addItem("B");
		view.getComboBoxGrade().addItem("C");
		view.getComboBoxGrade().addItem("D");
		view.getComboBoxGrade().addItem("E");
		view.getComboBoxGrade().addItem("U");
		view.getComboBoxGrade().setSelectedIndex(0);
		// ComboBox Credits

		view.getComboBoxCourseCredit().removeAllItems();
		view.getComboBoxCourseCredit().addItem("0");
		view.getComboBoxCourseCredit().addItem("5");
		view.getComboBoxCourseCredit().addItem("10");
		view.getComboBoxCourseCredit().addItem("15");
		view.getComboBoxCourseCredit().addItem("20");
		view.getComboBoxCourseCredit().addItem("25");
		view.getComboBoxCourseCredit().addItem("30");
		view.getComboBoxCourseCredit().setSelectedIndex(0);

		try {
			// ComboBox Student
			view.getComboBoxRegisterStudent().removeAllItems();

			try {
				resultSet = dal.findAllStudents();
				view.getComboBoxRegisterStudent().addItem("Select student");
				while (resultSet.next()) {
					String students = resultSet.getString(1) + " " + resultSet.getString(2);
					view.getComboBoxRegisterStudent().addItem(students);

				}
				view.getComboBoxRegisterStudent().setSelectedIndex(0);
			} catch (SQLException sqlException) {
				sqlExceptions(sqlException);
			} finally {
				closeResultSet(resultSet);
			}

			// ComboBox Course
			view.getComboBoxRegisterCourse().removeAllItems();
			resultSet = dal.findAllCourses();
			view.getComboBoxRegisterCourse().addItem("Select course");

			while (resultSet.next()) {
				String courses = resultSet.getString(1) + " " + resultSet.getString(2);
				view.getComboBoxRegisterCourse().addItem(courses);

			}
			view.getComboBoxRegisterCourse().setSelectedIndex(0);

		} catch (SQLException sqlException) {
			sqlExceptions(sqlException);
		} finally {
			closeResultSet(resultSet);
		}

		// ComboBox Register
		view.getComboBoxRegistryCourse().removeAllItems();

		try {
			resultSet = dal.findAllCoursesHasStudied();
			view.getComboBoxRegistryCourse().addItem("Select course for filter");

			while (resultSet.next()) {
				String courses = resultSet.getString(1) + " " + resultSet.getString(2);
				view.getComboBoxRegistryCourse().addItem(courses);
			}

			view.getComboBoxRegistryCourse().setSelectedIndex(0);

		} catch (SQLException sqlException) {
			sqlExceptions(sqlException);
		} finally {
			closeResultSet(resultSet);
		}
		// ComboBox Registry

		view.getComboBoxRegistryStudent().removeAllItems();

		try {
			resultSet = dal.findAllStudentsHasStudied();
			view.getComboBoxRegistryStudent().addItem("Select student for filter");

			while (resultSet.next()) {
				String students = resultSet.getString(1) + " " + resultSet.getString(2);
				view.getComboBoxRegistryStudent().addItem(students);
			}
			view.getComboBoxRegistryStudent().setSelectedIndex(0);

		} catch (SQLException sqlException) {
			sqlExceptions(sqlException);
		} finally {
			try {
				resultSet.close();
			} catch (SQLException sqlException) {
				sqlExceptions(sqlException);
			}
		}
		// ComboBox Statistics
		view.getComboBoxStatisticCourse().removeAllItems();

		try {
			resultSet = dal.findAllCoursesHasStudied();
			view.getComboBoxStatisticCourse().addItem("Select course");

			while (resultSet.next()) {
				String statistics = resultSet.getString(1) + " " + resultSet.getString(2);
				view.getComboBoxStatisticCourse().addItem(statistics);
			}
			view.getComboBoxStatisticCourse().setSelectedIndex(0);

		} catch (SQLException sqlException) {
			sqlExceptions(sqlException);
		} finally {
			closeResultSet(resultSet);
		}
	}

	public void filterRegistryTableStudentAndCourse() {

		if (ssnFilter != null && courseCodeFilter != null) {
			modelHasStudied.setRowCount(0);
			modelHasStudied.setColumnCount(0);
			Object[] columnNamesHasStudied = { "Ssn", "Name", "CourseCode", "Grade" };
			modelHasStudied.setColumnIdentifiers(columnNamesHasStudied);
			view.getTableRegistry().setModel(modelHasStudied); 

			try {
				resultSet = dal.findCourseStudentHasStudied(courseCodeFilter, ssnFilter);
				resultSetIteratorRegistry(resultSet, columnNamesHasStudied.length);

			} catch (SQLException sqlException) {
				sqlExceptions(sqlException);
			} finally {
				closeResultSet(resultSet);
			}
		}
	}

	public void filterRegistryTableStudent() {

		if (ssnFilter != null) {
			modelHasStudied.setRowCount(0);
			modelHasStudied.setColumnCount(0);
			Object[] columnNamesHasStudied = { "Ssn", "Name", "CourseCode", "Grade" }; 
			modelHasStudied.setColumnIdentifiers(columnNamesHasStudied);
			view.getTableRegistry().setModel(modelHasStudied); 

			try {
				resultSet = dal.findCourseHasStudied(ssnFilter);
				resultSetIteratorRegistry(resultSet, columnNamesHasStudied.length);

			} catch (SQLException sqlException) {
				sqlExceptions(sqlException);
			} finally {
				closeResultSet(resultSet);
			}
		}
	}

	public void filterRegistryTableCourse() {

		if (courseCodeFilter != null) {
			modelHasStudied.setRowCount(0);
			modelHasStudied.setColumnCount(0);
			Object[] columnNamesHasStudied = { "Ssn", "Name", "CourseCode", "Grade" }; 
			modelHasStudied.setColumnIdentifiers(columnNamesHasStudied);
			view.getTableRegistry().setModel(modelHasStudied); 

			try {
				resultSet = dal.findStudentHasStudied(courseCodeFilter);
				resultSetIteratorRegistry(resultSet, columnNamesHasStudied.length);
			} catch (SQLException sqlException) {
				sqlExceptions(sqlException);
			} finally {
				try {
					resultSet.close();
				} catch (SQLException sqlException) {
					sqlExceptions(sqlException);
				}
			}
		}
	}

	public void actionListners() {
// ADD STUDENT
		view.getBtnAddStudent().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String ssn = view.getTextFieldStudentSSN().getText();
				String studentName = view.getTextFieldStudentName().getText();
				String studentPhoneNumber = view.getTextFieldStudentPhoneNumber().getText();
				String studentAddress = view.getTextFieldStudentAddress().getText();

				try {
					if (ssn.equals("") || studentName.equals("") || studentPhoneNumber.equals("")
							|| studentAddress.equals("")) {
						view.getLabelResponsStudent().setText("Please fill in all fields to register a student");

					} else if (ssn.length() != 10) {
						view.getLabelResponsStudent().setText("Please fill in a valid ssn. (YYDDMMXXXX)");

					} else {
						dal.insertStudent(ssn, studentName, studentPhoneNumber, studentAddress);
						fillTables();
						fillComboBoxes();
						view.getTextFieldStudentName().setText("");
						view.getTextFieldStudentSSN().setText("");
						view.getTextFieldStudentAddress().setText("");
						view.getTextFieldStudentPhoneNumber().setText("");
						view.getLabelResponsStudent().setText("Student added");
					}
				} catch (SQLException sqlException) {
					if (sqlException.getErrorCode() == 2627) {
						view.getLabelResponsStudent().setText("This ssn already exists, try another one");
					} else {
						sqlExceptions(sqlException);
					}
				} finally {
					closeResultSet(resultSet);
				}
			}
		});

		// SEARCH STUDENT

		view.getBtnSearchStudent().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				ssnSearch = view.getTextFieldSearchStudent().getText().toString();
				if (ssnSearch.isEmpty()) {
					view.getLabelResponsStudent().setText("You need to fill in a SSN, please try again");
				}

				else {
					filterStudentTable();
					ssnSearch = null;
					view.getLabelResponsStudent().setText("");

				}

			}
		});

		// Clear search student

		view.getBtnClearSearchStudent().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				view.getTextFieldSearchStudent().setText("");
				fillTables();

			}

		});
		// DELETE STUDENT

		view.getBtnDeleteStudent().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (selectedSSN != null) { // from table student

					if (view.getTableStudent().getModel().getRowCount() != 0) { 

						try {
							dal.deleteStudent(selectedSSN);
							fillTables();
							fillComboBoxes();
							view.getLabelResponsStudent().setText("Student deleted");
							selectedSSN = null;

						} catch (SQLException sqlException) {
							sqlExceptions(sqlException);

						} finally {
							closeResultSet(resultSet);
						}

					}
				}
			}
		});
//SELECTING STUDENT IN JTABLE 
		view.getTableStudent().addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				JTable targetPressed = (JTable) e.getSource();
				int selectedRow = targetPressed.getSelectedRow();
				selectedSSN = view.getTableStudent().getModel().getValueAt(selectedRow, 0).toString(); 
																										

			}
		});

		// SEARCH COURSE

		view.getBtnSearchCourse().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				courseCodeSearch = view.getTextFieldSearchCourse().getText().toString();

				if (courseCodeSearch.isEmpty()) {
					view.getLabelResponsCourse().setText("You need to fill in a course code, please try again");
				} else {
					filterCourseTable();
					courseCodeSearch = null;
					view.getLabelResponsCourse().setText("");
				}
			}
		});

		// CLEAR COURSE-SEARCH

		view.getBtnClearSearchCourse().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				view.getTextFieldSearchCourse().setText("");
				fillTables();
				courseCodeSearch = null;

			}

		});
		// CLICK IN THE COURSETABLE

		view.getTableCourse().addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				JTable targetPressed = (JTable) e.getSource();
				int selectedRow = targetPressed.getSelectedRow();
				selectedCourseCode = view.getTableCourse().getModel().getValueAt(selectedRow, 0).toString();

			}
		});

		// Pressing deleteCourse button

		view.getBtnDeleteCourse().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (selectedCourseCode != null) { // FROM TABLE COURSE

					if (view.getTableCourse().getModel().getRowCount() != 0) {

						try {
							dal.deleteCourse(selectedCourseCode);
							fillTables();
							fillComboBoxes();

							view.getLabelResponsCourse().setText("Course deleted");
							selectedCourseCode = null;
						} catch (SQLException sqlException) {
							sqlExceptions(sqlException);
						} finally {
							closeResultSet(resultSet);
						}

					}
				}
			}
		});
// ADD COURSE
		view.getBtnAddCourse().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String courseCode = view.getTextFieldCourseCode().getText().toUpperCase();
				String courseName = view.getTextFieldCourseName().getText();
				int courseCredit = Integer.valueOf(view.getComboBoxCourseCredit().getSelectedItem().toString());

				try {
					if (courseCode.equals("") || courseName.equals("")) {
						view.getLabelResponsCourse().setText("Please fill in all fields to register a course");
					} else if (courseCode.charAt(0) != 'C' || courseCode.length() != 4) {
						view.getLabelResponsCourse().setText("Please fill in a valid coursecode. (CXXX)");
					}

					else {

						dal.insertCourse(courseCode, courseName, courseCredit);

						fillTables();
						fillComboBoxes();
						view.getTextFieldCourseCode().setText("");
						view.getTextFieldCourseName().setText("");
						view.getComboBoxCourseCredit().setSelectedIndex(0);
						view.getLabelResponsCourse().setText("Course added");
					}

				}

				catch (SQLException sqlException) {
					if (sqlException.getErrorCode() == 2627) {
						view.getLabelResponsCourse().setText("This coursecode already exists, try another one");
					} else {
						sqlExceptions(sqlException);

					}
				} finally {
					closeResultSet(resultSet);
				}

			}
		});

		// LIST IN TABLE REGISTER

		view.getTableRegister().addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				JTable targetPressed = (JTable) e.getSource();
				int selectedRow = targetPressed.getSelectedRow();
				selectedSSNRegister = view.getTableRegister().getModel().getValueAt(selectedRow, 0).toString();
				selectedCourseCodeRegister = view.getTableRegister().getModel().getValueAt(selectedRow, 2).toString();

			}
		});

		// REGISTER A CERTAIN STUDENT ON A CERTAIN COURSE IN REGISTER
		view.getBtnRegister().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (view.getComboBoxRegisterStudent().getSelectedIndex() > 0
						&& view.getComboBoxRegisterCourse().getSelectedIndex() > 0) {
					try {
						selectedSSNRegister = view.getComboBoxRegisterStudent().getSelectedItem().toString();
						String[] parts = selectedSSNRegister.split(" ");
						selectedSSNRegister = parts[0];
						selectedCourseCodeRegister = view.getComboBoxRegisterCourse().getSelectedItem().toString();
						parts = selectedCourseCodeRegister.split(" ");
						selectedCourseCodeRegister = parts[0];

						int currentCredits = 0;
						int courseCredit = 0;
// fILL RESULTSET WITH DATA NEEDED
						try {
							ResultSet resultSetDuplicates = dal.findStudentAndCourseFromHasStudied(selectedSSNRegister,
									selectedCourseCodeRegister);

							resultSet = dal.getCurrentCredits(selectedSSNRegister);
							while (resultSet.next()) {
								currentCredits = resultSet.getInt(1);
							}

							resultSet = dal.findCourseCredit(selectedCourseCodeRegister);
							while (resultSet.next()) {
								courseCredit = resultSet.getInt(1);
							}
// PERFORMS CHECKS WETHER TO REGISTER OR NOT
							if (resultSetDuplicates.isBeforeFirst() == true) {
								view.getLabelResponsRegister().setText("The student has already taken this course");
							}
							// check not to exceed 45p/semester
							else if (currentCredits + courseCredit > MAXCREDITS) {
								view.getLabelResponsRegister()
										.setText("A student can not take more than 45 credits per semester");

							} else {
								dal.registerStudentforCourse(selectedSSNRegister, selectedCourseCodeRegister);
								fillTables();

								view.getComboBoxRegisterCourse().setSelectedIndex(0);
								view.getComboBoxRegisterStudent().setSelectedIndex(0);
								view.getLabelResponsRegister().setText("Student added to course");
							}
						} catch (SQLException sqlException) {
							if (sqlException.getErrorCode() == 2627) {
								view.getLabelResponsRegister()
										.setText("This student is already registered on this course");
							} else {
								sqlExceptions(sqlException);
							}
						} finally {
							closeResultSet(resultSet);

						}
					} catch (NullPointerException nullPointer) {
						view.getLabelResponsRegister().setText("Please select both student and course to add");
					}

				} else {
					view.getLabelResponsRegister().setText("Select both student and course to register");
				}
			}

		});
// COMPLETED COURSE
		view.getBtnCompletedCourse().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					String selectedGrade = view.getComboBoxGrade().getSelectedItem().toString();

					if (selectedSSNRegister != null && view.getComboBoxGrade().getSelectedIndex() > 0) { // FROM TABLE
																											// REGISTER

						if (view.getTableRegister().getModel().getRowCount() != 0) {

							try {
								dal.courseFinished(selectedSSNRegister, selectedCourseCodeRegister, selectedGrade);
								dal.deleteStudies(selectedSSNRegister, selectedCourseCodeRegister);
								view.getComboBoxGrade().setSelectedIndex(-1);
								fillTables();
								fillComboBoxes();
								selectedSSNRegister = null;
								view.getLabelResponsRegister().setText("");
							} catch (SQLException sqlException) {
								sqlExceptions(sqlException);
							} finally {
								closeResultSet(resultSet);
							}

						}
					} else {
						view.getLabelResponsRegister().setText("Select a grade and a student first");
					}
				} catch (NullPointerException nullpointer) {
					view.getLabelResponsRegister().setText("Select a grade and a student first");
				}

			}

		});
// UNREGISTER A STUDENT IN REGISTER
		view.getBtnUnregister().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (selectedSSNRegister != null) { // FROM TABLE REGISTER

					if (view.getTableRegister().getModel().getRowCount() != 0) {

						try {
							dal.deleteStudies(selectedSSNRegister, selectedCourseCodeRegister);

							fillTables();
							selectedSSNRegister = null;
							selectedCourseCodeRegister = null;
						} catch (SQLException sqlException) {
							sqlExceptions(sqlException);
						} finally {
							closeResultSet(resultSet);
						}
					}
				}
			}

		});

		// FILTER REGISTRY
		view.getBtnRegistryFilter().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ssnFilter = view.getComboBoxRegistryStudent().getSelectedItem().toString();
				String[] parts = ssnFilter.split(" ");
				ssnFilter = parts[0];
				courseCodeFilter = view.getComboBoxRegistryCourse().getSelectedItem().toString();
				parts = courseCodeFilter.split(" ");
				courseCodeFilter = parts[0];

				if (view.getComboBoxRegistryStudent().getSelectedIndex() != 0
						&& view.getComboBoxRegistryCourse().getSelectedIndex() != 0) {
					filterRegistryTableStudentAndCourse();
					ssnFilter = null;
					courseCodeFilter = null;
					view.getLabelResponsRegistry().setText("");
				} else if (view.getComboBoxRegistryStudent().getSelectedIndex() != 0) {
					filterRegistryTableStudent();
					ssnFilter = null;
					view.getLabelResponsRegistry().setText("");
				} else if (view.getComboBoxRegistryCourse().getSelectedIndex() != 0) {
					filterRegistryTableCourse();
					courseCodeFilter = null;
					view.getLabelResponsRegistry().setText("");
				}

				else {

					view.getLabelResponsRegistry().setText("Choose one or more filters before filtering");
					fillTables();
				}
			}
		});
		// STATISTICS SHOW RESULT
		view.getBtnStatisticShowResult().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				modelStatistics.setRowCount(0);
				modelStatistics.setColumnCount(0);
				Object[] columnNamesStatistics = { "CourseCode", "% of A students" };
				modelStatistics.setColumnIdentifiers(columnNamesStatistics);
				view.getTableStatisticA().setModel(modelStatistics);

				selectedCourseCodeStatistics = view.getComboBoxStatisticCourse().getSelectedItem().toString();
				String[] parts = selectedCourseCodeStatistics.split(" ");
				selectedCourseCodeStatistics = parts[0];
				try {
					resultSet = dal.findGradeAFromHasStudied(selectedCourseCodeStatistics);

					if (view.getComboBoxStatisticCourse().getSelectedIndex() != 0) {
						// Checks if ResultSet is empty
						if (resultSet.isBeforeFirst() == true) {

							while (resultSet.next()) {
								Object[] objects = new Object[columnNamesStatistics.length];
								for (int i = 0; i < objects.length; i++) {
									objects[i] = resultSet.getObject(i + 1);

								}
								modelStatistics.addRow(objects);
								view.getLabelResponsStatistic().setText("");
							}
						} else if (resultSet.isBeforeFirst() == false) {
							modelStatistics.addRow(new Object[] { selectedCourseCodeStatistics, "0" });
						}
						// manually fills the Jtable with data
					} else if (view.getComboBoxStatisticCourse().getSelectedIndex() == 0) {
						view.getLabelResponsStatistic().setText("Please choose a course");
					}
				} catch (SQLException sqlException) {
					sqlExceptions(sqlException);
				} finally {
					closeResultSet(resultSet);
				}
			}
		});
// THROGHPUT 
		view.getBtnThroughput().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				modelThroughputStatistics.setRowCount(0);
				modelThroughputStatistics.setColumnCount(0);
				Object[] throughputHeaders = { "CourseCode", "Throughput %" };
				modelThroughputStatistics.setColumnIdentifiers(throughputHeaders);
				view.getTableStatisticThroughput().setModel(modelThroughputStatistics);

				ArrayList<String> courseCodeArray = new ArrayList<String>();

				String courseCode = null;
				double max = 0;
				try {
					// Sets arrayList with all courses
					resultSet = dal.findAllCourses();

					while (resultSet.next()) {
						for (int i = 0; i < 1; i++) {
							courseCode = resultSet.getString(i + 1);
						}
						courseCodeArray.add(courseCode);
					}
					// Finds the highest throughput
					for (int i = 0; i < courseCodeArray.size(); i++) {
						resultSet = dal.findCourseThroughput(courseCodeArray.get(i));
						while (resultSet.next()) {
							double troughPut = resultSet.getDouble(2);
							if (troughPut > max) {
								max = troughPut;
							}
						}
					}
					// Prints the courses that matches throughput to the table
					for (int i = 0; i < courseCodeArray.size(); i++) {
						resultSet = dal.findCourseThroughput(courseCodeArray.get(i));
						while (resultSet.next()) {
							Object[] objects = new Object[throughputHeaders.length];
							for (int j = 0; j < objects.length; j++) {
								objects[j] = resultSet.getObject(j + 1);
							}
							if (resultSet.getDouble(2) == max) {
								modelThroughputStatistics.addRow(objects);
							}

						}

					}
				} catch (SQLException sqlException) {
					sqlExceptions(sqlException);
				} finally {
					closeResultSet(resultSet);

				}
			}
		});

	}

}
