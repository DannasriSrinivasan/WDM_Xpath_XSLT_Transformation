<xsl:stylesheet version="2.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <html xmlns="http://www.w3.org/1999/xhtml">
      <body>
	<h2><xsl:value-of select="//collection/description"/></h2>
	<xsl:for-each select="//recipe">
		<h3>Recipe ID: <xsl:value-of select="@id"/>:  <xsl:value-of select="title"/> </h3>
		<h4>Date: <xsl:value-of select="date"/></h4>
		<p><h4>Ingredients: </h4>
			<xsl:for-each select="ingredient">
  				<xsl:if test="position() &gt; 1"> </xsl:if>
  				<xsl:choose>
	  				<xsl:when test="not(@amount!='')">
	  					<h4><xsl:value-of select="@name"/>:<br/></h4>
			        	<xsl:for-each select="ingredient">
			        		<xsl:if test="position() &gt; 1"> </xsl:if>
			        			<xsl:choose>
					  				<xsl:when test="not(@amount!='')">
					  					<h4><xsl:value-of select="@name"/>:<br/></h4>
							        	<xsl:for-each select="ingredient">
							        		<xsl:if test="position() &gt; 1"> </xsl:if>
							        		<xsl:choose>
								  				<xsl:when test="not(@amount!='')">
								  					<h4><xsl:value-of select="@name"/>:<br/></h4>
										        	<xsl:for-each select="ingredient">
										        		<xsl:if test="position() &gt; 1"> </xsl:if>
										        		<li><xsl:value-of select="@name"/>: <xsl:value-of select="@amount"/> <xsl:value-of select="@unit"/><br/></li>
										        	</xsl:for-each>
										        	<h4>Preparation: </h4><p><xsl:for-each select="preparation/step">
								<xsl:if test="position() &gt; 1"> </xsl:if>
								<li><xsl:value-of select="."/><br/></li>
								</xsl:for-each></p>
										    	</xsl:when>
										    	<xsl:otherwise>
										        	<li><xsl:value-of select="@name"/>: <xsl:value-of select="@amount"/> <xsl:value-of select="@unit"/><br/></li>
										    	</xsl:otherwise>
							  				</xsl:choose>
							        	</xsl:for-each>
							        	<h4>Preparation: </h4><p><xsl:for-each select="preparation/step">
								<xsl:if test="position() &gt; 1"> </xsl:if>
								<li><xsl:value-of select="."/><br/></li>
								</xsl:for-each></p>
							    	</xsl:when>
							    	<xsl:otherwise>
							        	<li><xsl:value-of select="@name"/>: <xsl:value-of select="@amount"/> <xsl:value-of select="@unit"/><br/></li>
							    	</xsl:otherwise>
				  				</xsl:choose>
			        	</xsl:for-each>
			        	<h4>Preparation: </h4><p><xsl:for-each select="preparation/step">
								<xsl:if test="position() &gt; 1"> </xsl:if>
								<li><xsl:value-of select="."/><br/></li>
								</xsl:for-each></p>
			    	</xsl:when>
			    	
			    	<xsl:otherwise>
			        	<li><xsl:value-of select="@name"/>: <xsl:value-of select="@amount"/> <xsl:value-of select="@unit"/><br/></li>
			    	</xsl:otherwise>
  				</xsl:choose>
				</xsl:for-each>
			</p>
			<h4>Preparation: </h4><p><xsl:for-each select="preparation/step">
								<xsl:if test="position() &gt; 1"> </xsl:if>
								<li><xsl:value-of select="."/><br/></li>
								</xsl:for-each></p>
			<p>
			<xsl:if test="comment"> 
				<h4>Comments: </h4><xsl:value-of select="comment"/>
			</xsl:if>
			</p>
			<p><h4>Nutrition: </h4><xsl:value-of select="nutrition"/> Calories: <xsl:value-of select="nutrition/@calories"/> Fat: <xsl:value-of select="nutrition/@fat"/> Carbohydrates: <xsl:value-of select="nutrition/@carbohydrates"/> Protein: <xsl:value-of select="nutrition/@protein"/><xsl:if test="nutrition/@alcohol"> 
				Alcohol: <xsl:value-of select="nutrition/@alcohol"/>
			</xsl:if></p>
		
	</xsl:for-each>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
