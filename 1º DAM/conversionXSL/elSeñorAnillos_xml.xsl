<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" indent="yes"/>

    <xsl:template match="/">
        <señordelosanillos>
            <xsl:for-each select="señordelosanillos/personaje">
                <xsl:if test="atributos/edad >= 100">
                    <personaje>
                        <nombre><xsl:value-of select="nombre"/></nombre>
                        <raza><xsl:value-of select="raza"/></raza>
                        <descripcion><xsl:value-of select="descripcion"/></descripcion>
                        <atributos>
                            <edad><xsl:value-of select="atributos/edad"/></edad>
                            <altura><xsl:value-of select="atributos/altura"/></altura>
                            <arma><xsl:value-of select="atributos/arma"/></arma>
                        </atributos>
                        <afiliacion><xsl:value-of select="afiliacion"/></afiliacion>
                    </personaje>
                </xsl:if>
            </xsl:for-each>
        </señordelosanillos>
    </xsl:template>
</xsl:stylesheet>
