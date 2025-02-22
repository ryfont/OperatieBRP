create table JBPM_ACTION (ID_  serial8 not null, class char(255) not null, NAME_ varchar(255), ISPROPAGATIONALLOWED_ smallint, ACTIONEXPRESSION_ varchar(255), ISASYNC_ smallint, REFERENCEDACTION_ int8, ACTIONDELEGATION_ int8, EVENT_ int8, PROCESSDEFINITION_ int8, EXPRESSION_ lvarchar(4000), TIMERNAME_ varchar(255), DUEDATE_ varchar(255), REPEAT_ varchar(255), TRANSITIONNAME_ varchar(255), TIMERACTION_ int8, EVENTINDEX_ integer, EXCEPTIONHANDLER_ int8, EXCEPTIONHANDLERINDEX_ integer, primary key (ID_));
create table JBPM_BYTEARRAY (ID_  serial8 not null, NAME_ varchar(255), FILEDEFINITION_ int8, primary key (ID_));
create table JBPM_BYTEBLOCK (PROCESSFILE_ int8 not null, BYTES_ byte, INDEX_ integer not null, primary key (PROCESSFILE_, INDEX_));
create table JBPM_COMMENT (ID_  serial8 not null, VERSION_ integer not null, ACTORID_ varchar(255), TIME_ datetime year to fraction(5), MESSAGE_ lvarchar(4000), TOKEN_ int8, TASKINSTANCE_ int8, TOKENINDEX_ integer, TASKINSTANCEINDEX_ integer, primary key (ID_));
create table JBPM_DECISIONCONDITIONS (DECISION_ int8 not null, TRANSITIONNAME_ varchar(255), EXPRESSION_ varchar(255), INDEX_ integer not null, primary key (DECISION_, INDEX_));
create table JBPM_DELEGATION (ID_  serial8 not null, CLASSNAME_ lvarchar(4000), CONFIGURATION_ lvarchar(4000), CONFIGTYPE_ varchar(255), PROCESSDEFINITION_ int8, primary key (ID_));
create table JBPM_EVENT (ID_  serial8 not null, EVENTTYPE_ varchar(255), TYPE_ char(255), GRAPHELEMENT_ int8, PROCESSDEFINITION_ int8, NODE_ int8, TRANSITION_ int8, TASK_ int8, primary key (ID_));
create table JBPM_EXCEPTIONHANDLER (ID_  serial8 not null, EXCEPTIONCLASSNAME_ lvarchar(4000), TYPE_ char(255), GRAPHELEMENT_ int8, PROCESSDEFINITION_ int8, GRAPHELEMENTINDEX_ integer, NODE_ int8, TRANSITION_ int8, TASK_ int8, primary key (ID_));
create table JBPM_ID_GROUP (ID_  serial8 not null, CLASS_ char(255) not null, NAME_ varchar(255), TYPE_ varchar(255), PARENT_ int8, primary key (ID_));
create table JBPM_ID_MEMBERSHIP (ID_  serial8 not null, CLASS_ char(255) not null, NAME_ varchar(255), ROLE_ varchar(255), USER_ int8, GROUP_ int8, primary key (ID_));
create table JBPM_ID_PERMISSIONS (ENTITY_ int8 not null, CLASS_ varchar(255), NAME_ varchar(255), ACTION_ varchar(255));
create table JBPM_ID_USER (ID_  serial8 not null, CLASS_ char(255) not null, NAME_ varchar(255), EMAIL_ varchar(255), PASSWORD_ varchar(255), primary key (ID_));
create table JBPM_JOB (ID_  serial8 not null, CLASS_ char(255) not null, VERSION_ integer not null, DUEDATE_ datetime year to fraction(5), PROCESSINSTANCE_ int8, TOKEN_ int8, TASKINSTANCE_ int8, ISSUSPENDED_ smallint, ISEXCLUSIVE_ smallint, LOCKOWNER_ varchar(255), LOCKTIME_ datetime year to fraction(5), EXCEPTION_ lvarchar(4000), RETRIES_ integer, NAME_ varchar(255), REPEAT_ varchar(255), TRANSITIONNAME_ varchar(255), ACTION_ int8, GRAPHELEMENTTYPE_ varchar(255), GRAPHELEMENT_ int8, NODE_ int8, primary key (ID_));
create table JBPM_LOG (ID_  serial8 not null, CLASS_ char(255) not null, INDEX_ integer, DATE_ datetime year to fraction(5), TOKEN_ int8, PARENT_ int8, MESSAGE_ lvarchar(4000), EXCEPTION_ lvarchar(4000), ACTION_ int8, NODE_ int8, ENTER_ datetime year to fraction(5), LEAVE_ datetime year to fraction(5), DURATION_ int8, NEWLONGVALUE_ int8, TRANSITION_ int8, CHILD_ int8, SOURCENODE_ int8, DESTINATIONNODE_ int8, VARIABLEINSTANCE_ int8, OLDBYTEARRAY_ int8, NEWBYTEARRAY_ int8, OLDDATEVALUE_ datetime year to fraction(5), NEWDATEVALUE_ datetime year to fraction(5), OLDDOUBLEVALUE_ float, NEWDOUBLEVALUE_ float, OLDLONGIDCLASS_ varchar(255), OLDLONGIDVALUE_ int8, NEWLONGIDCLASS_ varchar(255), NEWLONGIDVALUE_ int8, OLDSTRINGIDCLASS_ varchar(255), OLDSTRINGIDVALUE_ varchar(255), NEWSTRINGIDCLASS_ varchar(255), NEWSTRINGIDVALUE_ varchar(255), OLDLONGVALUE_ int8, OLDSTRINGVALUE_ lvarchar(4000), NEWSTRINGVALUE_ lvarchar(4000), TASKINSTANCE_ int8, TASKACTORID_ varchar(255), TASKOLDACTORID_ varchar(255), SWIMLANEINSTANCE_ int8, primary key (ID_));
create table JBPM_MODULEDEFINITION (ID_  serial8 not null, CLASS_ char(255) not null, NAME_ lvarchar(4000), PROCESSDEFINITION_ int8, STARTTASK_ int8, primary key (ID_));
create table JBPM_MODULEINSTANCE (ID_  serial8 not null, CLASS_ char(255) not null, VERSION_ integer not null, PROCESSINSTANCE_ int8, TASKMGMTDEFINITION_ int8, NAME_ varchar(255), primary key (ID_));
create table JBPM_NODE (ID_  serial8 not null, CLASS_ char(255) not null, NAME_ varchar(255), DESCRIPTION_ lvarchar(4000), PROCESSDEFINITION_ int8, ISASYNC_ smallint, ISASYNCEXCL_ smallint, ACTION_ int8, SUPERSTATE_ int8, SUBPROCNAME_ varchar(255), SUBPROCESSDEFINITION_ int8, DECISIONEXPRESSION_ varchar(255), DECISIONDELEGATION int8, SCRIPT_ int8, SIGNAL_ integer, CREATETASKS_ smallint, ENDTASKS_ smallint, NODECOLLECTIONINDEX_ integer, primary key (ID_));
create table JBPM_POOLEDACTOR (ID_  serial8 not null, VERSION_ integer not null, ACTORID_ varchar(255), SWIMLANEINSTANCE_ int8, primary key (ID_));
create table JBPM_PROCESSDEFINITION (ID_  serial8 not null, CLASS_ char(255) not null, NAME_ varchar(255), DESCRIPTION_ lvarchar(4000), VERSION_ integer, ISTERMINATIONIMPLICIT_ smallint, STARTSTATE_ int8, primary key (ID_));
create table JBPM_PROCESSINSTANCE (ID_  serial8 not null, VERSION_ integer not null, KEY_ varchar(255), START_ datetime year to fraction(5), END_ datetime year to fraction(5), ISSUSPENDED_ smallint, PROCESSDEFINITION_ int8, ROOTTOKEN_ int8, SUPERPROCESSTOKEN_ int8, primary key (ID_));
create table JBPM_RUNTIMEACTION (ID_  serial8 not null, VERSION_ integer not null, EVENTTYPE_ varchar(255), TYPE_ char(255), GRAPHELEMENT_ int8, PROCESSINSTANCE_ int8, ACTION_ int8, PROCESSINSTANCEINDEX_ integer, primary key (ID_));
create table JBPM_SWIMLANE (ID_  serial8 not null, NAME_ varchar(255), ACTORIDEXPRESSION_ varchar(255), POOLEDACTORSEXPRESSION_ varchar(255), ASSIGNMENTDELEGATION_ int8, TASKMGMTDEFINITION_ int8, primary key (ID_));
create table JBPM_SWIMLANEINSTANCE (ID_  serial8 not null, VERSION_ integer not null, NAME_ varchar(255), ACTORID_ varchar(255), SWIMLANE_ int8, TASKMGMTINSTANCE_ int8, primary key (ID_));
create table JBPM_TASK (ID_  serial8 not null, NAME_ varchar(255), DESCRIPTION_ lvarchar(4000), PROCESSDEFINITION_ int8, ISBLOCKING_ smallint, ISSIGNALLING_ smallint, CONDITION_ varchar(255), DUEDATE_ varchar(255), PRIORITY_ integer, ACTORIDEXPRESSION_ varchar(255), POOLEDACTORSEXPRESSION_ varchar(255), TASKMGMTDEFINITION_ int8, TASKNODE_ int8, STARTSTATE_ int8, ASSIGNMENTDELEGATION_ int8, SWIMLANE_ int8, TASKCONTROLLER_ int8, primary key (ID_));
create table JBPM_TASKACTORPOOL (TASKINSTANCE_ int8 not null, POOLEDACTOR_ int8 not null, primary key (TASKINSTANCE_, POOLEDACTOR_));
create table JBPM_TASKCONTROLLER (ID_  serial8 not null, TASKCONTROLLERDELEGATION_ int8, primary key (ID_));
create table JBPM_TASKINSTANCE (ID_  serial8 not null, CLASS_ char(255) not null, VERSION_ integer not null, NAME_ varchar(255), DESCRIPTION_ lvarchar(4000), ACTORID_ varchar(255), CREATE_ datetime year to fraction(5), START_ datetime year to fraction(5), END_ datetime year to fraction(5), DUEDATE_ datetime year to fraction(5), PRIORITY_ integer, ISCANCELLED_ smallint, ISSUSPENDED_ smallint, ISOPEN_ smallint, ISSIGNALLING_ smallint, ISBLOCKING_ smallint, TASK_ int8, TOKEN_ int8, PROCINST_ int8, SWIMLANINSTANCE_ int8, TASKMGMTINSTANCE_ int8, primary key (ID_));
create table JBPM_TOKEN (ID_  serial8 not null, VERSION_ integer not null, NAME_ varchar(255), START_ datetime year to fraction(5), END_ datetime year to fraction(5), NODEENTER_ datetime year to fraction(5), NEXTLOGINDEX_ integer, ISABLETOREACTIVATEPARENT_ smallint, ISTERMINATIONIMPLICIT_ smallint, ISSUSPENDED_ smallint, LOCK_ varchar(255), NODE_ int8, PROCESSINSTANCE_ int8, PARENT_ int8, SUBPROCESSINSTANCE_ int8, primary key (ID_));
create table JBPM_TOKENVARIABLEMAP (ID_  serial8 not null, VERSION_ integer not null, TOKEN_ int8, CONTEXTINSTANCE_ int8, primary key (ID_));
create table JBPM_TRANSITION (ID_  serial8 not null, NAME_ varchar(255), DESCRIPTION_ lvarchar(4000), PROCESSDEFINITION_ int8, FROM_ int8, TO_ int8, CONDITION_ varchar(255), FROMINDEX_ integer, primary key (ID_));
create table JBPM_VARIABLEACCESS (ID_  serial8 not null, VARIABLENAME_ varchar(255), ACCESS_ varchar(255), MAPPEDNAME_ varchar(255), SCRIPT_ int8, PROCESSSTATE_ int8, TASKCONTROLLER_ int8, INDEX_ integer, primary key (ID_));
create table JBPM_VARIABLEINSTANCE (ID_  serial8 not null, CLASS_ char(255) not null, VERSION_ integer not null, NAME_ varchar(255), CONVERTER_ char(255), TOKEN_ int8, TOKENVARIABLEMAP_ int8, PROCESSINSTANCE_ int8, BYTEARRAYVALUE_ int8, DATEVALUE_ datetime year to fraction(5), DOUBLEVALUE_ float, LONGIDCLASS_ varchar(255), LONGVALUE_ int8, STRINGIDCLASS_ varchar(255), STRINGVALUE_ lvarchar(4000), TASKINSTANCE_ int8, primary key (ID_));
create index IDX_ACTION_EVENT on JBPM_ACTION (EVENT_);
create index IDX_ACTION_ACTNDL on JBPM_ACTION (ACTIONDELEGATION_);
create index IDX_ACTION_PROCDF on JBPM_ACTION (PROCESSDEFINITION_);
alter table JBPM_ACTION add constraint  foreign key (EVENT_) references JBPM_EVENT constraint FK_ACTION_EVENT;
alter table JBPM_ACTION add constraint  foreign key (EXCEPTIONHANDLER_) references JBPM_EXCEPTIONHANDLER constraint FK_ACTION_EXPTHDL;
alter table JBPM_ACTION add constraint  foreign key (PROCESSDEFINITION_) references JBPM_PROCESSDEFINITION constraint FK_ACTION_PROCDEF;
alter table JBPM_ACTION add constraint  foreign key (TIMERACTION_) references JBPM_ACTION constraint FK_CRTETIMERACT_TA;
alter table JBPM_ACTION add constraint  foreign key (ACTIONDELEGATION_) references JBPM_DELEGATION constraint FK_ACTION_ACTNDEL;
alter table JBPM_ACTION add constraint  foreign key (REFERENCEDACTION_) references JBPM_ACTION constraint FK_ACTION_REFACT;
alter table JBPM_BYTEARRAY add constraint  foreign key (FILEDEFINITION_) references JBPM_MODULEDEFINITION constraint FK_BYTEARR_FILDEF;
alter table JBPM_BYTEBLOCK add constraint  foreign key (PROCESSFILE_) references JBPM_BYTEARRAY constraint FK_BYTEBLOCK_FILE;
create index IDX_COMMENT_TOKEN on JBPM_COMMENT (TOKEN_);
create index IDX_COMMENT_TSK on JBPM_COMMENT (TASKINSTANCE_);
alter table JBPM_COMMENT add constraint  foreign key (TOKEN_) references JBPM_TOKEN constraint FK_COMMENT_TOKEN;
alter table JBPM_COMMENT add constraint  foreign key (TASKINSTANCE_) references JBPM_TASKINSTANCE constraint FK_COMMENT_TSK;
alter table JBPM_DECISIONCONDITIONS add constraint  foreign key (DECISION_) references JBPM_NODE constraint FK_DECCOND_DEC;
create index IDX_DELEG_PRCD on JBPM_DELEGATION (PROCESSDEFINITION_);
alter table JBPM_DELEGATION add constraint  foreign key (PROCESSDEFINITION_) references JBPM_PROCESSDEFINITION constraint FK_DELEGATION_PRCD;
alter table JBPM_EVENT add constraint  foreign key (PROCESSDEFINITION_) references JBPM_PROCESSDEFINITION constraint FK_EVENT_PROCDEF;
alter table JBPM_EVENT add constraint  foreign key (NODE_) references JBPM_NODE constraint FK_EVENT_NODE;
alter table JBPM_EVENT add constraint  foreign key (TRANSITION_) references JBPM_TRANSITION constraint FK_EVENT_TRANS;
alter table JBPM_EVENT add constraint  foreign key (TASK_) references JBPM_TASK constraint FK_EVENT_TASK;
alter table JBPM_ID_GROUP add constraint  foreign key (PARENT_) references JBPM_ID_GROUP constraint FK_ID_GRP_PARENT;
alter table JBPM_ID_MEMBERSHIP add constraint  foreign key (GROUP_) references JBPM_ID_GROUP constraint FK_ID_MEMSHIP_GRP;
alter table JBPM_ID_MEMBERSHIP add constraint  foreign key (USER_) references JBPM_ID_USER constraint FK_ID_MEMSHIP_USR;
create index IDX_JOB_TSKINST on JBPM_JOB (TASKINSTANCE_);
create index IDX_JOB_PRINST on JBPM_JOB (PROCESSINSTANCE_);
create index IDX_JOB_TOKEN on JBPM_JOB (TOKEN_);
alter table JBPM_JOB add constraint  foreign key (TOKEN_) references JBPM_TOKEN constraint FK_JOB_TOKEN;
alter table JBPM_JOB add constraint  foreign key (NODE_) references JBPM_NODE constraint FK_JOB_NODE;
alter table JBPM_JOB add constraint  foreign key (PROCESSINSTANCE_) references JBPM_PROCESSINSTANCE constraint FK_JOB_PRINST;
alter table JBPM_JOB add constraint  foreign key (ACTION_) references JBPM_ACTION constraint FK_JOB_ACTION;
alter table JBPM_JOB add constraint  foreign key (TASKINSTANCE_) references JBPM_TASKINSTANCE constraint FK_JOB_TSKINST;
alter table JBPM_LOG add constraint  foreign key (SOURCENODE_) references JBPM_NODE constraint FK_LOG_SOURCENODE;
alter table JBPM_LOG add constraint  foreign key (TOKEN_) references JBPM_TOKEN constraint FK_LOG_TOKEN;
alter table JBPM_LOG add constraint  foreign key (OLDBYTEARRAY_) references JBPM_BYTEARRAY constraint FK_LOG_OLDBYTES;
alter table JBPM_LOG add constraint  foreign key (NEWBYTEARRAY_) references JBPM_BYTEARRAY constraint FK_LOG_NEWBYTES;
alter table JBPM_LOG add constraint  foreign key (CHILD_) references JBPM_TOKEN constraint FK_LOG_CHILDTOKEN;
alter table JBPM_LOG add constraint  foreign key (DESTINATIONNODE_) references JBPM_NODE constraint FK_LOG_DESTNODE;
alter table JBPM_LOG add constraint  foreign key (TASKINSTANCE_) references JBPM_TASKINSTANCE constraint FK_LOG_TASKINST;
alter table JBPM_LOG add constraint  foreign key (SWIMLANEINSTANCE_) references JBPM_SWIMLANEINSTANCE constraint FK_LOG_SWIMINST;
alter table JBPM_LOG add constraint  foreign key (PARENT_) references JBPM_LOG constraint FK_LOG_PARENT;
alter table JBPM_LOG add constraint  foreign key (NODE_) references JBPM_NODE constraint FK_LOG_NODE;
alter table JBPM_LOG add constraint  foreign key (ACTION_) references JBPM_ACTION constraint FK_LOG_ACTION;
alter table JBPM_LOG add constraint  foreign key (VARIABLEINSTANCE_) references JBPM_VARIABLEINSTANCE constraint FK_LOG_VARINST;
alter table JBPM_LOG add constraint  foreign key (TRANSITION_) references JBPM_TRANSITION constraint FK_LOG_TRANSITION;
create index IDX_MODDEF_PROCDF on JBPM_MODULEDEFINITION (PROCESSDEFINITION_);
alter table JBPM_MODULEDEFINITION add constraint  foreign key (STARTTASK_) references JBPM_TASK constraint FK_TSKDEF_START;
alter table JBPM_MODULEDEFINITION add constraint  foreign key (PROCESSDEFINITION_) references JBPM_PROCESSDEFINITION constraint FK_MODDEF_PROCDEF;
create index IDX_MODINST_PRINST on JBPM_MODULEINSTANCE (PROCESSINSTANCE_);
alter table JBPM_MODULEINSTANCE add constraint  foreign key (TASKMGMTDEFINITION_) references JBPM_MODULEDEFINITION constraint FK_TASKMGTINST_TMD;
alter table JBPM_MODULEINSTANCE add constraint  foreign key (PROCESSINSTANCE_) references JBPM_PROCESSINSTANCE constraint FK_MODINST_PRCINST;
create index IDX_PSTATE_SBPRCDEF on JBPM_NODE (SUBPROCESSDEFINITION_);
create index IDX_NODE_SUPRSTATE on JBPM_NODE (SUPERSTATE_);
create index IDX_NODE_PROCDEF on JBPM_NODE (PROCESSDEFINITION_);
create index IDX_NODE_ACTION on JBPM_NODE (ACTION_);
alter table JBPM_NODE add constraint  foreign key (SUBPROCESSDEFINITION_) references JBPM_PROCESSDEFINITION constraint FK_PROCST_SBPRCDEF;
alter table JBPM_NODE add constraint  foreign key (PROCESSDEFINITION_) references JBPM_PROCESSDEFINITION constraint FK_NODE_PROCDEF;
alter table JBPM_NODE add constraint  foreign key (SCRIPT_) references JBPM_ACTION constraint FK_NODE_SCRIPT;
alter table JBPM_NODE add constraint  foreign key (ACTION_) references JBPM_ACTION constraint FK_NODE_ACTION;
alter table JBPM_NODE add constraint  foreign key (DECISIONDELEGATION) references JBPM_DELEGATION constraint FK_DECISION_DELEG;
alter table JBPM_NODE add constraint  foreign key (SUPERSTATE_) references JBPM_NODE constraint FK_NODE_SUPERSTATE;
create index IDX_PLDACTR_ACTID on JBPM_POOLEDACTOR (ACTORID_);
create index IDX_TSKINST_SWLANE on JBPM_POOLEDACTOR (SWIMLANEINSTANCE_);
alter table JBPM_POOLEDACTOR add constraint  foreign key (SWIMLANEINSTANCE_) references JBPM_SWIMLANEINSTANCE constraint FK_POOLEDACTOR_SLI;
create index IDX_PROCDEF_STRTST on JBPM_PROCESSDEFINITION (STARTSTATE_);
alter table JBPM_PROCESSDEFINITION add constraint  foreign key (STARTSTATE_) references JBPM_NODE constraint FK_PROCDEF_STRTSTA;
create index IDX_PROCIN_ROOTTK on JBPM_PROCESSINSTANCE (ROOTTOKEN_);
create index IDX_PROCIN_SPROCTK on JBPM_PROCESSINSTANCE (SUPERPROCESSTOKEN_);
create index IDX_PROCIN_KEY on JBPM_PROCESSINSTANCE (KEY_);
create index IDX_PROCIN_PROCDEF on JBPM_PROCESSINSTANCE (PROCESSDEFINITION_);
alter table JBPM_PROCESSINSTANCE add constraint  foreign key (PROCESSDEFINITION_) references JBPM_PROCESSDEFINITION constraint FK_PROCIN_PROCDEF;
alter table JBPM_PROCESSINSTANCE add constraint  foreign key (ROOTTOKEN_) references JBPM_TOKEN constraint FK_PROCIN_ROOTTKN;
alter table JBPM_PROCESSINSTANCE add constraint  foreign key (SUPERPROCESSTOKEN_) references JBPM_TOKEN constraint FK_PROCIN_SPROCTKN;
create index IDX_RTACTN_PRCINST on JBPM_RUNTIMEACTION (PROCESSINSTANCE_);
create index IDX_RTACTN_ACTION on JBPM_RUNTIMEACTION (ACTION_);
alter table JBPM_RUNTIMEACTION add constraint  foreign key (PROCESSINSTANCE_) references JBPM_PROCESSINSTANCE constraint FK_RTACTN_PROCINST;
alter table JBPM_RUNTIMEACTION add constraint  foreign key (ACTION_) references JBPM_ACTION constraint FK_RTACTN_ACTION;
alter table JBPM_SWIMLANE add constraint  foreign key (ASSIGNMENTDELEGATION_) references JBPM_DELEGATION constraint FK_SWL_ASSDEL;
alter table JBPM_SWIMLANE add constraint  foreign key (TASKMGMTDEFINITION_) references JBPM_MODULEDEFINITION constraint FK_SWL_TSKMGMTDEF;
create index IDX_SWIMLINST_SL on JBPM_SWIMLANEINSTANCE (SWIMLANE_);
alter table JBPM_SWIMLANEINSTANCE add constraint  foreign key (TASKMGMTINSTANCE_) references JBPM_MODULEINSTANCE constraint FK_SWIMLANEINST_TM;
alter table JBPM_SWIMLANEINSTANCE add constraint  foreign key (SWIMLANE_) references JBPM_SWIMLANE constraint FK_SWIMLANEINST_SL;
create index IDX_TASK_TSKNODE on JBPM_TASK (TASKNODE_);
create index IDX_TASK_PROCDEF on JBPM_TASK (PROCESSDEFINITION_);
create index IDX_TASK_TASKMGTDF on JBPM_TASK (TASKMGMTDEFINITION_);
alter table JBPM_TASK add constraint  foreign key (TASKCONTROLLER_) references JBPM_TASKCONTROLLER constraint FK_TSK_TSKCTRL;
alter table JBPM_TASK add constraint  foreign key (ASSIGNMENTDELEGATION_) references JBPM_DELEGATION constraint FK_TASK_ASSDEL;
alter table JBPM_TASK add constraint  foreign key (TASKNODE_) references JBPM_NODE constraint FK_TASK_TASKNODE;
alter table JBPM_TASK add constraint  foreign key (PROCESSDEFINITION_) references JBPM_PROCESSDEFINITION constraint FK_TASK_PROCDEF;
alter table JBPM_TASK add constraint  foreign key (STARTSTATE_) references JBPM_NODE constraint FK_TASK_STARTST;
alter table JBPM_TASK add constraint  foreign key (TASKMGMTDEFINITION_) references JBPM_MODULEDEFINITION constraint FK_TASK_TASKMGTDEF;
alter table JBPM_TASK add constraint  foreign key (SWIMLANE_) references JBPM_SWIMLANE constraint FK_TASK_SWIMLANE;
alter table JBPM_TASKACTORPOOL add constraint  foreign key (POOLEDACTOR_) references JBPM_POOLEDACTOR constraint FK_TSKACTPOL_PLACT;
alter table JBPM_TASKACTORPOOL add constraint  foreign key (TASKINSTANCE_) references JBPM_TASKINSTANCE constraint FK_TASKACTPL_TSKI;
alter table JBPM_TASKCONTROLLER add constraint  foreign key (TASKCONTROLLERDELEGATION_) references JBPM_DELEGATION constraint FK_TSKCTRL_DELEG;
create index IDX_TASKINST_TOKN on JBPM_TASKINSTANCE (TOKEN_);
create index IDX_TASKINST_TSK on JBPM_TASKINSTANCE (TASK_, PROCINST_);
create index IDX_TSKINST_TMINST on JBPM_TASKINSTANCE (TASKMGMTINSTANCE_);
create index IDX_TSKINST_SLINST on JBPM_TASKINSTANCE (SWIMLANINSTANCE_);
create index IDX_TASK_ACTORID on JBPM_TASKINSTANCE (ACTORID_);
alter table JBPM_TASKINSTANCE add constraint  foreign key (PROCINST_) references JBPM_PROCESSINSTANCE constraint FK_TSKINS_PRCINS;
alter table JBPM_TASKINSTANCE add constraint  foreign key (TASKMGMTINSTANCE_) references JBPM_MODULEINSTANCE constraint FK_TASKINST_TMINST;
alter table JBPM_TASKINSTANCE add constraint  foreign key (TOKEN_) references JBPM_TOKEN constraint FK_TASKINST_TOKEN;
alter table JBPM_TASKINSTANCE add constraint  foreign key (SWIMLANINSTANCE_) references JBPM_SWIMLANEINSTANCE constraint FK_TASKINST_SLINST;
alter table JBPM_TASKINSTANCE add constraint  foreign key (TASK_) references JBPM_TASK constraint FK_TASKINST_TASK;
create index IDX_TOKEN_PROCIN on JBPM_TOKEN (PROCESSINSTANCE_);
create index IDX_TOKEN_SUBPI on JBPM_TOKEN (SUBPROCESSINSTANCE_);
create index IDX_TOKEN_NODE on JBPM_TOKEN (NODE_);
create index IDX_TOKEN_PARENT on JBPM_TOKEN (PARENT_);
alter table JBPM_TOKEN add constraint  foreign key (PARENT_) references JBPM_TOKEN constraint FK_TOKEN_PARENT;
alter table JBPM_TOKEN add constraint  foreign key (NODE_) references JBPM_NODE constraint FK_TOKEN_NODE;
alter table JBPM_TOKEN add constraint  foreign key (PROCESSINSTANCE_) references JBPM_PROCESSINSTANCE constraint FK_TOKEN_PROCINST;
alter table JBPM_TOKEN add constraint  foreign key (SUBPROCESSINSTANCE_) references JBPM_PROCESSINSTANCE constraint FK_TOKEN_SUBPI;
create index IDX_TKVARMAP_CTXT on JBPM_TOKENVARIABLEMAP (CONTEXTINSTANCE_);
create index IDX_TKVVARMP_TOKEN on JBPM_TOKENVARIABLEMAP (TOKEN_);
alter table JBPM_TOKENVARIABLEMAP add constraint  foreign key (CONTEXTINSTANCE_) references JBPM_MODULEINSTANCE constraint FK_TKVARMAP_CTXT;
alter table JBPM_TOKENVARIABLEMAP add constraint  foreign key (TOKEN_) references JBPM_TOKEN constraint FK_TKVARMAP_TOKEN;
create index IDX_TRANSIT_TO on JBPM_TRANSITION (TO_);
create index IDX_TRANSIT_FROM on JBPM_TRANSITION (FROM_);
create index IDX_TRANS_PROCDEF on JBPM_TRANSITION (PROCESSDEFINITION_);
alter table JBPM_TRANSITION add constraint  foreign key (TO_) references JBPM_NODE constraint FK_TRANSITION_TO;
alter table JBPM_TRANSITION add constraint  foreign key (PROCESSDEFINITION_) references JBPM_PROCESSDEFINITION constraint FK_TRANS_PROCDEF;
alter table JBPM_TRANSITION add constraint  foreign key (FROM_) references JBPM_NODE constraint FK_TRANSITION_FROM;
alter table JBPM_VARIABLEACCESS add constraint  foreign key (TASKCONTROLLER_) references JBPM_TASKCONTROLLER constraint FK_VARACC_TSKCTRL;
alter table JBPM_VARIABLEACCESS add constraint  foreign key (SCRIPT_) references JBPM_ACTION constraint FK_VARACC_SCRIPT;
alter table JBPM_VARIABLEACCESS add constraint  foreign key (PROCESSSTATE_) references JBPM_NODE constraint FK_VARACC_PROCST;
create index IDX_VARINST_TKVARMP on JBPM_VARIABLEINSTANCE (TOKENVARIABLEMAP_);
create index IDX_VARINST_PRCINS on JBPM_VARIABLEINSTANCE (PROCESSINSTANCE_);
create index IDX_VARINST_TK on JBPM_VARIABLEINSTANCE (TOKEN_);
alter table JBPM_VARIABLEINSTANCE add constraint  foreign key (TOKEN_) references JBPM_TOKEN constraint FK_VARINST_TK;
alter table JBPM_VARIABLEINSTANCE add constraint  foreign key (TOKENVARIABLEMAP_) references JBPM_TOKENVARIABLEMAP constraint FK_VARINST_TKVARMP;
alter table JBPM_VARIABLEINSTANCE add constraint  foreign key (PROCESSINSTANCE_) references JBPM_PROCESSINSTANCE constraint FK_VARINST_PRCINST;
alter table JBPM_VARIABLEINSTANCE add constraint  foreign key (TASKINSTANCE_) references JBPM_TASKINSTANCE constraint FK_VAR_TSKINST;
alter table JBPM_VARIABLEINSTANCE add constraint  foreign key (BYTEARRAYVALUE_) references JBPM_BYTEARRAY constraint FK_BYTEINST_ARRAY;
