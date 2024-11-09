<#if Session?? && Session.SPRING_SECURITY_CONTEXT??>
    <#assign auth = Session.SPRING_SECURITY_CONTEXT.authentication>
    <#if auth?? && auth.isAuthenticated()>
        <#assign user = auth.principal>
        <#assign name = user.getName()! "unknown">
        <#assign isAdmin = user.isAdmin()! false>
    <#else>
        <#assign name = "unknown">
        <#assign isAdmin = false>
    </#if>
<#else>
    <#assign name = "unknown">
    <#assign isAdmin = false>
</#if>
