<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match='/'>
        <!--<!DOCTYPE html>-->
            <html lang="en">
                <head>
                    <meta charset="UTF-8"/>
                    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
                    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
                    <title>Ejercicio 1 Pag 216-217</title>
                </head>
                <body>
                    <h1>Grado Superior</h1>
                    <ul>
                   <xsl:for-each select="ciclos/ciclo">
                       <xsl:variable name="grado" select="ciclos/ciclo/grado"/>
                       <xsl:if test="grado='Superior'">
                        <li>
                            <p>
                        <strong>
                            <xsl:value-of select="@codigo"/>
                            <xsl:value-of select="nombre"/>
                        </strong>
                            </p>
                        </li>
                       </xsl:if>
                    </xsl:for-each>
                    </ul>
                </body>
            </html>
    </xsl:template>
</xsl:stylesheet>