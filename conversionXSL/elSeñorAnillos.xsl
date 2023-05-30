<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match='/'>
        <html lang="en">
            <head>
                <meta charset="UTF-8"/>
                <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
                <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
                <title>Document</title>
            </head>
        <style>
            table {
            border-collapse: collapse;
            width: 100%;
            }
            th, td {
            border: 1px solid black;
            padding: 8px;
            }
            th {
            background-color: #f2f2f2;
            }
            td.age {
            color: green;
            }
            td.age.minor {
            color: red;
            }
        </style>
    <body>
        <h1>Personajes Hobbits</h1>
        <table>
            <tr>
                <th>Nombre</th>
                <th>Descripción</th>
                <th>Edad</th>
            </tr>
            <xsl:for-each select="señordelosanillos/personaje[raza = 'Hobbit']">
                <xsl:sort select="nombre"></xsl:sort>
                <tr>
                    <td>
                        <strong>
                            <xsl:value-of select="nombre"/>
                        </strong>
                    </td>
                    <td class="description">
                        <xsl:value-of select="substring(descripcion, 1, 50)"/>
                    </td>
                    <td class="age">
                        <xsl:choose>
                        <xsl:when test="atributos/edad &lt; 100">
                            <span style="color:red">
                                <xsl:value-of select="atributos/edad"/>
                            </span>
                        </xsl:when>
                        <xsl:otherwise>
                            <span style="color:green">
                                <xsl:value-of select="atributos/edad"/>
                            </span>
                        </xsl:otherwise>
                    </xsl:choose>
                    </td>
                </tr>
            </xsl:for-each>
        </table>
    </body>
</html>
    </xsl:template>
</xsl:stylesheet>

