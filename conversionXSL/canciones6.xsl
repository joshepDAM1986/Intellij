<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match='/'>
        <html lang="en">
            <head>
                <meta charset="UTF-8"/>
                <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
                <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
                <title>Ejercicio 1 Pag 216-217</title>
                <style>
                    .fondo_verde {
                    background-color: green;
                    }
                    .fondo_amarillo {
                    background-color: yellow;
                    }
                </style>
            </head>
            <body>
                <h1>CATALOGO DE DISCOS</h1>
                <table border="1">
                    <tr>
                        <th>TITULO</th>
                        <th>ARTISTA</th>
                        <th>PAIS</th>
                        <th>COMPANIA</th>
                        <th>PRECIO</th>
                        <th>ANIO</th>
                    </tr>
                    <xsl:for-each select="CATALOGO/DISCO">
                        <xsl:variable name="precio" select="PRECIO" />
                        <xsl:variable name="filaPintada">
                            <xsl:choose>
                                <xsl:when test="$precio > 10">fondo_verde</xsl:when>
                                <xsl:otherwise>fondo_amarillo</xsl:otherwise>
                            </xsl:choose>
                        </xsl:variable>
                        <tr class="{$filaPintada}">
                            <td>
                                <xsl:value-of select="TITULO"/>
                            </td>
                            <td>
                                <xsl:value-of select="ARTISTA"/>
                            </td>
                            <td>
                                <xsl:value-of select="PAIS"/>
                            </td>
                            <td>
                                <xsl:value-of select="COMPANIA"/>
                            </td>
                            <td>
                                <xsl:value-of select="PRECIO"/>
                            </td>
                            <td>
                                <xsl:value-of select="ANIO"/>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>