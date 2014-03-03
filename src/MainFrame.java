import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;

public class MainFrame extends JFrame
{

	private JPanel contentPane;
	private JTextField textFieldResistors;
	private JTextField textFieldTargetValue;
	private JButton btnSolve;
	private JTextField textFieldExecutionSeconds;
	private JTextField textFieldResult;

	/**
	 * Create the frame.
	 */
	public MainFrame()
	{
		setTitle("Combine my Resistors");
		setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblResitors = new JLabel("Resitors :");
		lblResitors.setHorizontalAlignment(SwingConstants.LEFT);
		lblResitors.setFont(new Font("Trebuchet MS", Font.BOLD, 15));

		textFieldResistors = new JTextField();
		textFieldResistors.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		textFieldResistors.setColumns(10);

		JLabel lblResult = new JLabel("Result");
		lblResult.setHorizontalAlignment(SwingConstants.LEFT);
		lblResult.setFont(new Font("Trebuchet MS", Font.BOLD, 15));

		JLabel lblTargetValue = new JLabel("Target Value :");
		lblTargetValue.setHorizontalAlignment(SwingConstants.LEFT);
		lblTargetValue.setFont(new Font("Trebuchet MS", Font.BOLD, 15));

		textFieldTargetValue = new JTextField();
		textFieldTargetValue.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		textFieldTargetValue.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTargetValue.setColumns(10);

		btnSolve = new JButton("Find the best Combination");

		JLabel lblExecutionSeconds = new JLabel("Execution seconds :");
		lblExecutionSeconds.setHorizontalAlignment(SwingConstants.LEFT);
		lblExecutionSeconds.setFont(new Font("Trebuchet MS", Font.BOLD, 15));

		textFieldExecutionSeconds = new JTextField();
		textFieldExecutionSeconds.setFont(new Font("Trebuchet MS", Font.PLAIN,
				14));
		textFieldExecutionSeconds.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldExecutionSeconds.setColumns(10);

		textFieldResult = new JTextField();
		textFieldResult.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		textFieldResult.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSolve, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblResitors, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblTargetValue, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblResult, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
											.addGap(10)))
									.addGap(18)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(textFieldTargetValue, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
											.addGap(84)
											.addComponent(lblExecutionSeconds, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(textFieldExecutionSeconds, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
										.addComponent(textFieldResult, GroupLayout.PREFERRED_SIZE, 422, GroupLayout.PREFERRED_SIZE)))
								.addComponent(textFieldResistors, GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(65)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblTargetValue, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
							.addComponent(textFieldTargetValue, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
						.addComponent(textFieldExecutionSeconds, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
						.addComponent(lblExecutionSeconds, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldResistors, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblResitors, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addComponent(btnSolve, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblResult, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
						.addComponent(textFieldResult, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);

		// Add the listener to the solve button
		btnSolve.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				solveSetOfResistors();
			}
		});
	}

	/**
	 * The action listener for the button
	 */
	protected void solveSetOfResistors()
	{
		// Parse the values in the fields
		Double targetValue = 0.0;
		Double executionSeconds = 0.0;
		LinkedList<ResistorCombination> givenResistors = new LinkedList<>();

		try
		{
			targetValue = Double.parseDouble(textFieldTargetValue.getText());
		} catch (NumberFormatException e1)
		{
			JOptionPane
					.showMessageDialog(this,
							"You should enter a single number in the Target value field");
		}

		try
		{
			executionSeconds = Double.parseDouble(textFieldExecutionSeconds
					.getText());
		} catch (NumberFormatException e1)
		{
			JOptionPane
					.showMessageDialog(this,
							"You should enter a single number in the Execution seconds  field");
		}

		try
		{
			String[] resistorValues = (textFieldResistors.getText()).split(" ");
			for (String string : resistorValues)
				givenResistors.push(new ResistorCombination(Double
						.parseDouble(string)));
		} catch (Exception e)
		{
			JOptionPane
					.showMessageDialog(this,
							"You should enter numbers seperated by spaces in the Resitors field");
		}

		// Make the solver and find the solution
		try
		{
			ResistorSetSolver solver = new ResistorSetSolver(targetValue,
					(long) (executionSeconds * 1000), givenResistors);
			textFieldResult.setText(solver.getBestCombination().toString());
		} catch (Exception e)
		{
			JOptionPane.showMessageDialog(this, "It's too hard for me :(");
		}

	}
}
