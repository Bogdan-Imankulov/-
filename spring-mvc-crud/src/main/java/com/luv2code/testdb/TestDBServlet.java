package com.luv2code.testdb;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;



@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger;

	static {
		try {
			logger = logbackConfigure();
		} catch (JoranException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = "springstudent";
		String pass = "springstudent";
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";

		try {
			logger.info("Connecting to database: " + jdbcUrl);
			PrintWriter out = resp.getWriter();
			Class.forName(driver);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			logger.info("Connection Success");
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new ServletException();
		}

	}

	public static Logger logbackConfigure() throws JoranException {
		LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
		context.reset();
		JoranConfigurator configurator = new JoranConfigurator();
		configurator.setContext(context);
		configurator.doConfigure("src/main/resources/logback.xml");

		Logger root = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
		root.setLevel(Level.INFO);
		return root;
	}


}
