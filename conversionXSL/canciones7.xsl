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
                    p {
                    color: red;
                    }
                    li {
                    list-style: numeric;
                    }
                </style>
            </head>
            <body>
                <h1>CATALOGO DE DISCOS</h1>
                    <ol>
                        <xsl:for-each select="CATALOGO/DISCO">
                                <li><xsl:value-of select="TITULO"/></li>
                                <p><xsl:value-of select="PRECIO"/></p>
                        </xsl:for-each>
                    </ol>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>