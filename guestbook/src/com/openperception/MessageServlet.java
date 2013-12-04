// Decompiled by DJ v3.12.12.96 Copyright 2011 Atanas Neshkov  Date: 25-06-2013 PM 05:11:57
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   MessageServlet.java

package com.openperception;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Referenced classes of package com.openperception:
//            ConnectionFactory

public class MessageServlet extends HttpServlet {

	public MessageServlet() {
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out;
		Connection connection = null;
		out = response.getWriter();
		response.setContentType("text/html");
		try {
			connection = ConnectionFactory.getConnectionManager()
					.getConnection();
			Statement stmt = null;
			String query = null;
			String msgValue = null;
			int count = 0;
			msgValue = request.getParameter("messagevalue");
			String query1 = "select count(*) COUNT from MESSAGE";
			stmt = connection.createStatement();
			ResultSet rs1 = stmt.executeQuery(query1);
			if (rs1.next()) {
				count = rs1.getInt("COUNT");
			}
			stmt = connection.createStatement();
			query = (new StringBuilder(
					"insert into MESSAGE(MESSAGE_ID, MESSAGE_VALUE) values ("
							+ count + ",'")).append(msgValue).append("')")
					.toString();
			count = stmt.executeUpdate(query);

			if (count > 0)
				System.out.println("Message saved successfully.");
		} catch (SQLException e) {
			out.println("Error saving message.");
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		response.sendRedirect("Welcome.jsp");
	}


	protected void doPost(HttpServletRequest httpservletrequest,
			HttpServletResponse httpservletresponse) throws ServletException,
			IOException {
	}

	private static final long serialVersionUID = 1L;
}
