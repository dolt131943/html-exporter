package uk.co.certait.htmlexporter.writer.excel;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import uk.co.certait.htmlexporter.ss.CellRange;
import uk.co.certait.htmlexporter.ss.CellRangeResolver;
import uk.co.certait.htmlexporter.ss.TableCellReference;
import uk.co.certait.htmlexporter.ss.TestUtils;
import uk.co.certait.htmlexporter.writer.excel.ExcelCellRangeResolver;

public class ExcelCellRangeResolverTest
{
	private CellRange range;
	private CellRangeResolver resolver;
	
	@Before
	public void onSetUp()
	{
		range = new CellRange();
		resolver = new ExcelCellRangeResolver();	
	}
	
	@Test
	public void testGetFormulaString()
	{
		range.addCell(createCell(0,0));
		range.addCell(createCell(0,1));
		
		Assert.assertEquals("A1:B1", resolver.getRangeString(range));
		
		range.addCell(createCell(0,2));
		
		Assert.assertEquals("A1:C1", resolver.getRangeString(range));
		
		range.addCell(createCell(1,0));
		range.addCell(createCell(1,1));
		range.addCell(createCell(1,2));
		
		Assert.assertEquals("A1:C2", resolver.getRangeString(range));
		
		range = new CellRange();
		range.addCell(createCell(3,4));
		range.addCell(createCell(3,5));
		range.addCell(createCell(3,6));
		range.addCell(createCell(4,4));
		range.addCell(createCell(4,5));
		range.addCell(createCell(4,6));
		range.addCell(createCell(5,4));
		range.addCell(createCell(5,5));
		range.addCell(createCell(5,6));
		
		Assert.assertEquals("E4:G6", resolver.getRangeString(range));
	}
	
	public TableCellReference createCell(int rowIndex, int columnIndex)
	{
		return TestUtils.createCell(rowIndex, columnIndex);
	}
}