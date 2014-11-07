<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

	<!-- imports the original docbook stylesheets -->
	<xsl:import href="urn:docbkx:stylesheet" />
	<xsl:import href="urn:docbkx:stylesheet/highlight.xsl" />

	<!-- configure XSL parameters -->
	<xsl:param name="chapter.autolabel" select="1"></xsl:param>
	<xsl:param name="section.autolabel" select="1"></xsl:param>
	<xsl:param name="section.label.includes.component.label" select="1"></xsl:param>
	
	<xsl:param name="highlight.source" select="1" />
	<xsl:param name="img.src.path">images/</xsl:param>
	<xsl:param name="ignore.image.scaling" select="1" />

	<!-- configure chunking 
	<xsl:param name="chunk.quietly" select="1" />
	<xsl:param name="use.id.as.filename" select="1" />
	<xsl:param name="chunker.output.encoding" select="UTF-8" />
	-->
	
	<!-- Important links: - http://www.sagehill.net/docbookxsl/ - http://docbkx-tools.sourceforge.net/ -->

	<!-- customized toc generation -->
	<xsl:param name="generate.toc">
set toc
book      toc,title
	</xsl:param>

	<xsl:param name="formal.title.placement">
		figure after
		table after
		example before
		equation before
		procedure before
	</xsl:param>
	
	<xsl:template match="processing-instruction('linebreak')">
	  <br/>
	</xsl:template>
	
</xsl:stylesheet>