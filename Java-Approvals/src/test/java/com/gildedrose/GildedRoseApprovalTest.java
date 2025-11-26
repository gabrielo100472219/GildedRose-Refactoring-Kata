package com.gildedrose;

import org.approvaltests.Approvals;
import org.approvaltests.reporters.DiffReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@UseReporter(DiffReporter.class)
public class GildedRoseApprovalTest {

	@Test
	public void thirtyDays() {

		final ByteArrayOutputStream fakeoutput = new ByteArrayOutputStream();
		System.setOut(new PrintStream(fakeoutput));
		System.setIn(new ByteArrayInputStream("a\n".getBytes()));

		Program.main();
		final String output = fakeoutput.toString();

		Approvals.verify(output);
	}
}
