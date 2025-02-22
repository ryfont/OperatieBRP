<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page session="false" %>
<!doctype html>
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="nl"> <![endif]-->
<!--[if IE 7]>    <html class="no-js lt-ie9 lt-ie8" lang="nl"> <![endif]-->
<!--[if IE 8]>    <html class="no-js lt-ie9" lang="nl"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang="nl"> <!--<![endif]-->
<head>
    <meta charset="utf-8" />
    <title>Bevraging</title>
    <meta name="description" content="">
    
    <!-- Use the .htaccess and remove these lines to avoid edge case issues. More info: h5bp.com/i/378 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">


    <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.20/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
    <link type="text/css" href="http://${pageContext.request.serverName}:${pageContext.request.localPort}${pageContext.request.contextPath}/resources/css/redmond/jquery-ui-1.8.20.custom.css" rel="stylesheet" />
    <link type="text/css" href="http://${pageContext.request.serverName}:${pageContext.request.localPort}${pageContext.request.contextPath}/resources/css/htm5reset.css" rel="stylesheet" />
<link type="text/css" href="http://${pageContext.request.serverName}:${pageContext.request.localPort}${pageContext.request.contextPath}/resources/css/bevraging.css" rel="stylesheet" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="http://${pageContext.request.serverName}:${pageContext.request.localPort}${pageContext.request.contextPath}/dashboard/resources/js/libs/jquery-1.7.2.min.js"><\/script>')</script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.20/jquery-ui.min.js"></script>
    <script>document.documentElement.className = "js";</script>
  
    <!-- All JavaScript at the bottom, except this Modernizr build.
       Modernizr enables HTML5 elements & feature detects for optimal performance.
       Create your own custom Modernizr build: www.modernizr.com/download/ -->
    <script src="http://${pageContext.request.serverName}:${pageContext.request.localPort}${pageContext.request.contextPath}/resources/js/libs/modernizr-2.5.3.min.js"></script>
</head>
<body>
    <header>
    <hgroup><h1>BRP Sneak Preview </h1></hgroup>
    </header>
    
    <div role="main">
        <section id="search">
            <form method="GET" id="searchbsn">
            <label for="bsn">BSN</label>
                <input  type="text" name="bsn" placeholder="Type hier het BSN dat u zoekt" size="30" maxlength="12">
                <input type="submit" value="Zoek"></form>
        </section>
        
        <c:if test="${persoon!=null}">
        <section id="person">
            <section class="collapsable">
               <h3>Identificatienummers</h3>
				  <div>
				    <table>
				    <tr>
				    <td class="label">Burgerservicenummer</td><td class="data"><c:out value="${persoon.bsn}"/></td>
				    <td class="label">A-nummer</td><td class="data"><c:out value="${persoon.anr}"/></td>
			         </tr>
				    </table>	
				  </div>
				  </section>
				  <section class="collapsable">
				  <h3>Geslachtsaanduiding en naam</h3>
				  <div>
				  <table>                   
                    <tr>
                    <td class="label">Geslacht</td><td class="data">
                    <c:out value="${persoon.geslachtsaand.naam}"/>
				    </td>
                    <td class="label">Geslachtsnaam</td><td class="data"><c:out value="${persoon.geslnaam}"/></td>
                    </tr>
                    <tr>
                    <td class="label">Voornamen</td><td class="data"><c:out value="${persoon.voornamen}"/></td>
                    <td class="label">Adelijke titel</td><td class="data"><c:out value="${persoon.adellijketitel}"/></td>
                    </tr>
                    <tr>
                    <td class="label">Voorvoegsel</td><td class="data"><c:out value="${persoon.voorvoegsel}"/></td>
                    <td class="label">Predikaat</td><td class="data"><c:out value="${persoon.predikaat}"/></td>
                    </tr>
                    <tr>
                    <td class="label">Scheidingsteken</td><td class="data"><c:out value="${persoon.scheidingsteken}"/></td>
                    <td class="label">&nbsp;</td><td class="data">&nbsp;</td>
                    </tr>
                 
                    </table>
				  </div>
				   </section>
                  <section class="collapsable">
				  <h3>Aanschrijving</h3>
				  <div>
				    <table>                   
                    <tr>
                    <td class="label">??</td><td class="data">
                    <c:out value="${persoon.geslachtsaand.naam}"/>
                    </td>
                    <td class="label">??</td><td class="data"><c:out value="${persoon.geslnaam}"/></td>
                    </tr>
                    </table>
				  </div>
				   </section>
                  <section class="collapsable">
				  <h3>Geboorte</h3>
				  <div>
				   <table>                   
                    <tr>
                    <td class="label">Datum geboorte</td><td class="data">
                    <c:out value="${persoon.datgeboorte}"/>
                    </td>
                    <td class="label">Plaats geboorte</td><td class="data"><c:out value="${persoon.wplgeboorte.naam}"/></td>
                    </tr> 
                    <tr>
                    <td class="label">Gemeente geboorte</td><td class="data">
                    <c:out value="${persoon.gemgeboorte.naam}"/>
                    </td>
                    <td class="label">Land geboorte</td><td class="data"><c:out value="${persoon.landgeboorte.naam}"/></td>
                    </tr>
                    </table>
				  </div>
            </section>
            <c:if test="${persoon.datoverlijden}!=null">
            <section class="collapsable">
                <h3>Overlijden</h3>
                <div><table>                   
                    <tr>
                    <td class="label">Datum overlijden</td><td class="data">
                    <c:out value="${persoon.datoverlijden}"/>
                    </td>
                    <td class="label">Plaats overlijden</td><td class="data"><c:out value="${persoon.wploverlijden.naam}"/></td>
                    </tr> 
                    <tr>
                    <td class="label">Gemeente overlijden</td><td class="data">
                    <c:out value="${persoon.gemoverlijden.naam}"/>
                    </td>
                    <td class="label">Land overlijden</td><td class="data"><c:out value="${persoon.landoverlijden.naam}"/></td>
                    </tr>
                    </table>
                </div> 
            </section>
            </c:if>
            <section class="collapsable">
                <h3>Nationaliteit</h3>
                <div><table>                   
                    <tr>
                    <td class="label">Nationaliteit</td>
                    <td class="data">
                        <c:out value="${nationaliteiten[0].nation.naam}"/>
                    </td>
                    <td class="label">Reden verkrijging</td>
                    <td class="data"><c:out value="${nationaliteiten[0].rdnverk.naam}"/></td>
                    </tr> 
                    </table>
                </div> 
            </section>   
                        <section class="collapsable">
                <h3>Adres</h3>
                <div><p>Nog niet geimplementeerd</p>
                </div> 
            </section>    
                        <section class="collapsable">
                <h3>Partner</h3>
                <div><p>Nog niet geimplementeerd</p>
                </div> 
            </section>    
                        <section class="collapsable">
                <h3>Ouders</h3>
                <div><p>Nog niet geimplementeerd</p>
                </div> 
            </section>
                        <section class="collapsable">
                <h3>Kinderen</h3>
                <div><p>Nog niet geimplementeerd</p>
                </div> 
            </section>
                        <section class="collapsable">
                <h3>Inschrijving en bijhoudingsverantwoordelijke</h3>
                <div><p>Nog niet geimplementeerd</p>
                </div> 
            </section>
                        <section class="collapsable">
                <h3>Bijhoudingsgemeente</h3>
                <div><p>Nog niet geimplementeerd</p>
                </div> 
            </section>
                        <section class="collapsable">
                <h3>Indicaties</h3>
                <div><p>Nog niet geimplementeerd</p>
                </div> 
            </section>
        </section>
        <aside id="actions">
        <c:if test="${berichten!=null}">
			<c:forEach var="bericht" items="${berichten}">
				<article>
	            <h3>${bericht.soortBijhouding.naam}</h3>
		            <p>Op: <fmt:formatDate pattern="dd-MM-yyyy HH:mm:ss" value="${bericht.verzondenOp.time}" /></p>
		            <p>${bericht.bericht}</p>
		            <p>${bericht.berichtDetails}</p>
	            </article>
			</c:forEach>
		</c:if>
		<c:if test="${berichten==null}">
		  <p>Geen berichten vandaag voor deze persoon</p>
		</c:if>
		
        </aside>
        </c:if>
    </div>
    
    <footer>
        <div clearfix><p><img src="resources/images/Logo-Min-BZK.jpg" height="50px"/>&copy;2012</p></div>
    </footer>
    
    <script>
/*     $("#person").addClass("ui-accordion ui-accordion-icons ui-widget ui-helper-reset")
    .find("h3")
    .addClass("ui-accordion-header ui-helper-reset ui-state-default ui-corner-top ui-corner-bottom")
    .hover(function() { $(this).toggleClass("ui-state-hover"); })
    .prepend('<span class="ui-icon ui-icon-triangle-1-e"></span>')
    .click(function() {
      $(this)
        .toggleClass("ui-accordion-header-active ui-state-active ui-state-default ui-corner-bottom")
        .find("> .ui-icon").toggleClass("ui-icon-triangle-1-e ui-icon-triangle-1-s").end()
        .next().toggleClass("ui-accordion-content-active").slideToggle();
      return false;
    })
    .next()
      .addClass("ui-accordion-content  ui-helper-reset ui-widget-content ui-corner-bottom")
      .hide(); */

    </script>
    
    <script src="http://${pageContext.request.serverName}:${pageContext.request.localPort}${pageContext.request.contextPath}/resources/js/libs/jquery.cookie.js"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.localPort}${pageContext.request.contextPath}/resources/js/libs/jquery.collapse.js"></script>
    <script>
        $(".collapsable").collapse({show: function(){
                this.animate({
                    opacity: 'toggle', 
                    height: 'toggle'
                }, 300);
            },
            hide : function() {
                this.animate({
                    opacity: 'toggle', 
                    height: 'toggle'
                }, 300);
            }
        });
    
    </script>
</body>
</html> 