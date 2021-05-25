package com.client;

// Author :- Onkar B. Madhekar //
import java.util.Scanner;

import com.objectprovider.ObjectProvider;
import com.service_interface.AccountServiceInterface;
import com.service_interface.UserServiceInterface;

public class WorkFlow {

	public static void main(String[] args) {

		// getting classes from provider
		AccountServiceInterface accService = ObjectProvider.getAccountObject();
		UserServiceInterface userService = ObjectProvider.getUserObject();

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int loopChoice = 1;
		do {
			try {
				// Basic Services
				System.out.print("Services:\n1] Sign-Up And Open Account\n2] Login\n3] Exit\nChoice:");
				int userServiceChoice = sc.nextInt();

				switch (userServiceChoice) {
				// Sign-Up And Open Account
				case 1:
					System.out.println(
							"Enter Following Details:\n1:Username\n2:Password\n3:Security Quetion\n4:Security Answer\n5:Address\n6:Pincode\n7:Account Type\n8:Balance");
					String userName = sc.next();
					String userPassword = sc.next();
					String secQuetion = sc.next();
					String secAnswer = sc.next();
					String userAddress = sc.next();
					int userPincode = sc.nextInt();
					String accType = sc.next();
					float accBalance = sc.nextFloat();

					if (userService.userSignUp(userName, userPassword, secQuetion, secAnswer, userAddress, userPincode,
							accType, accBalance)) {
						System.out.println("Registred And Account Created Successfully!!");
					} else {
						System.out.println("Problem Occured!");
					}
					break;

				// Login
				case 2:
					int loginLoop = 1;
					do {
						System.out.println("Enter Following Details:1:Username -");
						String loginName = sc.next();
						System.out.println("2:Password -");
						String loginPassword = sc.next();

						// login
						if (userService.userLogin(loginName, loginPassword)) {
							System.out.println("Welcome User!");
							int loginServiceLoop = 1;
							do {
								System.out.print(
										"\nServices:\n1] Update Password\n2] Open New Account\n3] Display Account Details\n4] Deposite\n5] Withdrawl\n6] Balance Inquiry\n7] Get IFSC Code\n8] Delete Account\n9]Exit\nChoice:");
								int loginServiceChoice = sc.nextInt();

								switch (loginServiceChoice) {
								// Update Password
								case 1:
									System.out.print("\nEnter Username,Password, Confirm Password:");
									String userNameUpPass = sc.next();
									String userPassUpPass = sc.next();
									String userConfPass = sc.next();
									if (userService.updatePassword(userNameUpPass, userPassUpPass, userConfPass)) {
										System.out.print("\nPassword Updated!");
									} else {
										System.out.print("Failed to update password!");
									}
									break;

								// Open Account
								case 2:
									System.out.print("\nEnter Name, Account Type, Base Amount:");
									String name = sc.next();
									String type = sc.next();
									float amount = sc.nextFloat();

									int accno = accService.openNewAccount(type, amount, name);
									System.out.print("\nYour Account Number Is:" + accno);
									break;

								// Account Details
								case 3:
									System.out.print("\nEnter Account Number:");
									int accNum = sc.nextInt();
									String details = accService.displayAccountDetails(accNum);
									System.out.print("\nDetails Are:" + details);
									break;

								// Deposit Money
								case 4:
									System.out.print("\nEnter Account Number,Amount:");
									int accNumDep = sc.nextInt();
									float amountDep = sc.nextFloat();
									float updatedBal = accService.deposite(accNumDep, amountDep);
									System.out.println("\nUpdated Balance Is:" + updatedBal);
									break;

								// Withdraw Money
								case 5:
									System.out.print("\nEnter Account Number,Amount:");
									int accNumWithd = sc.nextInt();
									float amountWithd = sc.nextFloat();
									float updBal = accService.withdraw(accNumWithd, amountWithd);
									System.out.print("\nUpdated Balance Is:" + updBal);
									break;

								// Balance Inquiry
								case 6:
									System.out.print("\nEnter Account Number:");
									int accNumBinq = sc.nextInt();
									float bal = accService.balanceInquiry(accNumBinq);
									System.out.print("\nYour Balance Is:" + bal);
									break;

								// IFSC code
								case 7:
									System.out.print("\nEnter Account Number:");
									int accIfsc = sc.nextInt();
									String ifsc = accService.getIfscCodeAccount(accIfsc);
									System.out.print("\nYour IFSC code is:" + ifsc);
									break;
								
								// Delete Account
								case 8: 
									System.out.print("\nEnter Account Number:");
									int accNumber = sc.nextInt();
									if(accService.deleteAccount(accNumber)) {
										System.out.println("Account Deleted!");
									}
									else {
										System.out.println("Problem In Deleting Account!!");
									}
									break;
									
								// Exit
								case 9:
									System.exit(0);
									break;

								default:
									System.out.println("Wrong Choice!");
								}

								System.out.println("Want To Continue?(1:Yes/2:No)");
								loginServiceLoop = sc.nextInt();
							} while (loginServiceLoop != 2);

						}
						// when login failed
						else {
							// forget password service
							System.out.println("\nInvalid User");
							System.out.println("\nForget Password?(1:yes/2:no)\nEnter Choice:");
							int forgetPassChoice = sc.nextInt();
							switch (forgetPassChoice) {
							case 1:
								System.out.println("\nEnter Username,Security Quetion and Security Answer");
								String userNameForgetPass = sc.next();
								String secQueForgPass = sc.next();
								String secAnsForgPass = sc.next();
								userService.forgetPassword(userNameForgetPass, secQueForgPass, secAnsForgPass);
								break;

							case 2:
								System.out.println("\nThank you!");
								break;

							default:
								System.out.println("\nInvalid Choice!");
								break;
							}

						}

						System.out.println("Want To Continue?(1:Yes/2:No)");
						loginLoop = sc.nextInt();
					} while (loginLoop != 2);
					break;

				// Exit
				case 3:
					System.exit(0);
					;
					break;

				default:
					System.out.println("Wrong Choice!!");
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println("Want To Continue?(1:Yes/2:NO)");
			loopChoice = sc.nextInt();
		} while (loopChoice != 2);

	}
	// Author :- Onkar B. Madhekar //
}
