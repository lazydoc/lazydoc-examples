<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" version="1.0">

	<!-- imports the original docbook stylesheets -->
	<xsl:import href="urn:docbkx:stylesheet" />
	<xsl:import href="urn:docbkx:stylesheet/highlight.xsl" />

	<!-- configure XSL parameters -->
	<xsl:param name="chapter.autolabel" select="1"></xsl:param>
	<xsl:param name="section.autolabel" select="1"></xsl:param>
	<xsl:param name="section.label.includes.component.label" select="1"></xsl:param>
	
	<xsl:param name="highlight.source" select="1" />
	<xsl:param name="fop1.extensions" select="1" />
	<xsl:param name="img.src.path">resources/images/</xsl:param>
	<xsl:param name="keep.relative.image.uris" select="1" />
	<xsl:param name="ulink.hyphenate">&#x200B;</xsl:param>

	<xsl:param name="telekom.logo">header-logo.png</xsl:param>
	<xsl:param name="telekom.logo.left">$telekom.logo.left</xsl:param>
	<xsl:param name="telekom.logo.right">$telekom.logo.right</xsl:param>
	<xsl:param name="telekom.title.logo">$telekom.title.logo</xsl:param>

	<xsl:attribute-set name="root.properties">
		<xsl:attribute name="color">#444</xsl:attribute>
	</xsl:attribute-set>

	<xsl:param name="paper.type" select="A4" />
	<xsl:param name="body.font.master" select="11" />
	<xsl:param name="body.font.family">
		Helvetica
	</xsl:param>
	<xsl:param name="body.start.indent">
		0pc
	</xsl:param>
	<xsl:param name="hyphenate">
		true
	</xsl:param>
	
	<xsl:param name="generate.toc">
book      toc,title
	</xsl:param>

	<xsl:attribute-set name="component.title.properties">
		<xsl:attribute name="font-size">
		    <xsl:value-of select="$body.font.master * 1.2" />
    		<xsl:text>pt</xsl:text>
  		</xsl:attribute>
		<xsl:attribute name="space-before.minimum">3em</xsl:attribute>
		<xsl:attribute name="space-before.optimum">3.5em</xsl:attribute>
		<xsl:attribute name="space-before.maximum">5em</xsl:attribute>
	</xsl:attribute-set>
	<xsl:attribute-set name="section.title.level1.properties">
		<xsl:attribute name="font-size">
		    <xsl:value-of select="$body.font.master * 1.15" />
    		<xsl:text>pt</xsl:text>
  		</xsl:attribute>
		<xsl:attribute name="space-before.minimum">2em</xsl:attribute>
		<xsl:attribute name="space-before.optimum">2.5em</xsl:attribute>
		<xsl:attribute name="space-before.maximum">3em</xsl:attribute>
	</xsl:attribute-set>
	<xsl:attribute-set name="section.title.level2.properties">
		<xsl:attribute name="font-size">
		    <xsl:value-of select="$body.font.master * 1.1" />
    		<xsl:text>pt</xsl:text>
  		</xsl:attribute>
		<xsl:attribute name="space-before.minimum">2em</xsl:attribute>
		<xsl:attribute name="space-before.optimum">2.5em</xsl:attribute>
		<xsl:attribute name="space-before.maximum">3em</xsl:attribute>
	</xsl:attribute-set>
	<xsl:attribute-set name="section.title.level3.properties">
		<xsl:attribute name="font-size">
		    <xsl:value-of select="$body.font.master * 1.0" />
    		<xsl:text>pt</xsl:text>
  		</xsl:attribute>
		<xsl:attribute name="space-before.minimum">1em</xsl:attribute>
		<xsl:attribute name="space-before.optimum">1.5em</xsl:attribute>
		<xsl:attribute name="space-before.maximum">2em</xsl:attribute>
	</xsl:attribute-set>
	<!-- Important links: - http://www.sagehill.net/docbookxsl/ - http://docbkx-tools.sourceforge.net/ -->

	<xsl:param name="formal.title.placement">
		figure after
		table after
		example before
		equation before
		procedure before
	</xsl:param>

	<!-- 
	<xsl:attribute-set name="section.title.properties">
		<xsl:attribute name="space-before.minimum">3em</xsl:attribute>
		<xsl:attribute name="space-before.optimum">3.5em</xsl:attribute>
		<xsl:attribute name="space-before.maximum">5em</xsl:attribute>
	</xsl:attribute-set>
	-->

	<!-- formal and informal block elements (table, etc)-->
	<xsl:attribute-set name="formal.title.properties">
		<xsl:attribute name="font-size">10pt</xsl:attribute>
	</xsl:attribute-set>
	<xsl:attribute-set name="formal.object.properties">
		<xsl:attribute name="font-size">9pt</xsl:attribute>
		<xsl:attribute name="space-before.minimum">2em</xsl:attribute>
		<xsl:attribute name="space-before.optimum">2.5em</xsl:attribute>
		<xsl:attribute name="space-before.maximum">3em</xsl:attribute>
	  	<xsl:attribute name="padding">0.5em</xsl:attribute>
	</xsl:attribute-set>

	<xsl:attribute-set name="informal.title.properties">
		<xsl:attribute name="font-size">10pt</xsl:attribute>
	</xsl:attribute-set>
	<xsl:attribute-set name="informal.object.properties">
		<xsl:attribute name="font-size">9pt</xsl:attribute>
		<xsl:attribute name="space-before.minimum">2em</xsl:attribute>
		<xsl:attribute name="space-before.optimum">2.5em</xsl:attribute>
		<xsl:attribute name="space-before.maximum">3em</xsl:attribute>
	  	<xsl:attribute name="padding">0.5em</xsl:attribute>
	</xsl:attribute-set>
	
	<!-- verbatim elements like programlisting -->
	<xsl:attribute-set name="monospace.verbatim.properties">
		<xsl:attribute name="font-size">9pt</xsl:attribute>
		<xsl:attribute name="border">0.5pt solid #C7C7C7</xsl:attribute>
		<xsl:attribute name="background-color">#EfEfEf</xsl:attribute>
		<xsl:attribute name="padding">1em</xsl:attribute>
		<xsl:attribute name="margin-{$direction.align.start}">0pt</xsl:attribute>
		<xsl:attribute name="margin-{$direction.align.end}">0pt</xsl:attribute>
	    <xsl:attribute name="wrap-option">wrap</xsl:attribute>
	    <xsl:attribute name="hyphenation-character">\</xsl:attribute>
	</xsl:attribute-set>

	<!--  admonitions like note, tip, etc -->
	<xsl:attribute-set name="admonition.title.properties">
	  <xsl:attribute name="font-size">10pt</xsl:attribute>
	</xsl:attribute-set>
	<xsl:attribute-set name="nongraphical.admonition.properties">
	  <xsl:attribute name="font-size">9pt</xsl:attribute>
	  <xsl:attribute name="border">0.5pt solid #C7C7C7</xsl:attribute>
	  <xsl:attribute name="background-color">#EfEfEf</xsl:attribute>
	  <xsl:attribute name="padding">0.5em</xsl:attribute>
	  <xsl:attribute name="margin-{$direction.align.start}">0pt</xsl:attribute>
	  <xsl:attribute name="margin-{$direction.align.end}">0pt</xsl:attribute>
	</xsl:attribute-set>
	
	<!-- table styles -->
	<xsl:param name="default.table.width">100%</xsl:param>
	<xsl:param name="default.table.frame" select="none" />
	<xsl:param name="table.frame.border.color">#C7C7C7</xsl:param>
	<xsl:param name="table.cell.border.color">#C7C7C7</xsl:param>
	<xsl:param name="table.frame.border.thickness">0pt</xsl:param>
	<xsl:param name="table.cell.border.thickness">0.5pt</xsl:param>
	<xsl:template name="table.cell.properties">
		<xsl:call-template name="border">
	    	<xsl:with-param name="side" select="'bottom'"/>
	    </xsl:call-template>
	</xsl:template>
	<xsl:attribute-set name="table.cell.padding">
		<xsl:attribute name="padding-left">0.2em</xsl:attribute>
		<xsl:attribute name="padding-right">0.2em</xsl:attribute>
		<xsl:attribute name="padding-top">1em</xsl:attribute>
		<xsl:attribute name="padding-bottom">1em</xsl:attribute>
	</xsl:attribute-set>
	
	<!-- header image -->
	<xsl:param name="region.before.extent">40pt</xsl:param>
	<xsl:template name="header.content">  
	  <xsl:param name="pageclass" select="''"/>
	  <xsl:param name="sequence" select="''"/>
	  <xsl:param name="position" select="''"/>
	  <xsl:param name="gentext-key" select="''"/>
	
	  <fo:block>  
	    <!-- sequence can be odd, even, first, blank -->
	    <!-- position can be left, center, right -->
	    <xsl:choose>
			
			<xsl:when test="$position = 'left'">
			  <fo:external-graphic content-height="0.80cm">
			    <xsl:attribute name="src">
			      <xsl:call-template name="fo-external-image">
			        <xsl:with-param name="filename" select="$telekom.logo.left"/>
			      </xsl:call-template>
			    </xsl:attribute>
			  </fo:external-graphic>
			</xsl:when>
			
			<xsl:when test="$position = 'right'">
			  <fo:external-graphic content-height="0.80cm">
			    <xsl:attribute name="src">
			      <xsl:call-template name="fo-external-image">
			        <xsl:with-param name="filename" select="$telekom.logo.right"/>
			      </xsl:call-template>
			    </xsl:attribute>
			  </fo:external-graphic>
			</xsl:when>
	
	    </xsl:choose>
	  </fo:block>
	</xsl:template>
	
	<xsl:template name="book.titlepage.before.recto">
	<fo:block>
			<fo:external-graphic width="100%" content-width="scale-to-fit">
				<xsl:attribute name="src">
			      	<xsl:call-template name="fo-external-image">
			        	<xsl:with-param name="filename" select="$telekom.title.logo" />
			      	</xsl:call-template>
			    </xsl:attribute>
			</fo:external-graphic>
		</fo:block>
  	</xsl:template>
  	
  	
</xsl:stylesheet>