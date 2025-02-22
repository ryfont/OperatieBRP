create table JBPM_ACTION (ID_ numeric(19,0) identity not null, class char(1) not null, NAME_ varchar(255) null, ISPROPAGATIONALLOWED_ tinyint null, ACTIONEXPRESSION_ varchar(255) null, ISASYNC_ tinyint null, REFERENCEDACTION_ numeric(19,0) null, ACTIONDELEGATION_ numeric(19,0) null, EVENT_ numeric(19,0) null, PROCESSDEFINITION_ numeric(19,0) null, EXPRESSION_ varchar(4000) null, TIMERNAME_ varchar(255) null, DUEDATE_ varchar(255) null, REPEAT_ varchar(255) null, TRANSITIONNAME_ varchar(255) null, TIMERACTION_ numeric(19,0) null, EVENTINDEX_ int null, EXCEPTIONHANDLER_ numeric(19,0) null, EXCEPTIONHANDLERINDEX_ int null, primary key (ID_)) lock datarows
create table JBPM_BYTEARRAY (ID_ numeric(19,0) identity not null, NAME_ varchar(255) null, FILEDEFINITION_ numeric(19,0) null, primary key (ID_)) lock datarows
create table JBPM_BYTEBLOCK (PROCESSFILE_ numeric(19,0) not null, BYTES_ varbinary(1024) null, INDEX_ int not null, primary key (PROCESSFILE_, INDEX_)) lock datarows
create table JBPM_COMMENT (ID_ numeric(19,0) identity not null, VERSION_ int not null, ACTORID_ varchar(255) null, TIME_ datetime null, MESSAGE_ varchar(4000) null, TOKEN_ numeric(19,0) null, TASKINSTANCE_ numeric(19,0) null, TOKENINDEX_ int null, TASKINSTANCEINDEX_ int null, primary key (ID_)) lock datarows
create table JBPM_DECISIONCONDITIONS (DECISION_ numeric(19,0) not null, TRANSITIONNAME_ varchar(255) null, EXPRESSION_ varchar(255) null, INDEX_ int not null, primary key (DECISION_, INDEX_)) lock datarows
create table JBPM_DELEGATION (ID_ numeric(19,0) identity not null, CLASSNAME_ varchar(4000) null, CONFIGURATION_ varchar(4000) null, CONFIGTYPE_ varchar(255) null, PROCESSDEFINITION_ numeric(19,0) null, primary key (ID_)) lock datarows
create table JBPM_EVENT (ID_ numeric(19,0) identity not null, EVENTTYPE_ varchar(255) null, TYPE_ char(1) null, GRAPHELEMENT_ numeric(19,0) null, PROCESSDEFINITION_ numeric(19,0) null, NODE_ numeric(19,0) null, TRANSITION_ numeric(19,0) null, TASK_ numeric(19,0) null, primary key (ID_)) lock datarows
create table JBPM_EXCEPTIONHANDLER (ID_ numeric(19,0) identity not null, EXCEPTIONCLASSNAME_ varchar(4000) null, TYPE_ char(1) null, GRAPHELEMENT_ numeric(19,0) null, PROCESSDEFINITION_ numeric(19,0) null, GRAPHELEMENTINDEX_ int null, NODE_ numeric(19,0) null, TRANSITION_ numeric(19,0) null, TASK_ numeric(19,0) null, primary key (ID_)) lock datarows
create table JBPM_ID_GROUP (ID_ numeric(19,0) identity not null, CLASS_ char(1) not null, NAME_ varchar(255) null, TYPE_ varchar(255) null, PARENT_ numeric(19,0) null, primary key (ID_)) lock datarows
create table JBPM_ID_MEMBERSHIP (ID_ numeric(19,0) identity not null, CLASS_ char(1) not null, NAME_ varchar(255) null, ROLE_ varchar(255) null, USER_ numeric(19,0) null, GROUP_ numeric(19,0) null, primary key (ID_)) lock datarows
create table JBPM_ID_PERMISSIONS (ENTITY_ numeric(19,0) not null, CLASS_ varchar(255) null, NAME_ varchar(255) null, ACTION_ varchar(255) null) lock datarows
create table JBPM_ID_USER (ID_ numeric(19,0) identity not null, CLASS_ char(1) not null, NAME_ varchar(255) null, EMAIL_ varchar(255) null, PASSWORD_ varchar(255) null, primary key (ID_)) lock datarows
create table JBPM_JOB (ID_ numeric(19,0) identity not null, CLASS_ char(1) not null, VERSION_ int not null, DUEDATE_ datetime null, PROCESSINSTANCE_ numeric(19,0) null, TOKEN_ numeric(19,0) null, TASKINSTANCE_ numeric(19,0) null, ISSUSPENDED_ tinyint null, ISEXCLUSIVE_ tinyint null, LOCKOWNER_ varchar(255) null, LOCKTIME_ datetime null, EXCEPTION_ text null, RETRIES_ int null, NAME_ varchar(255) null, REPEAT_ varchar(255) null, TRANSITIONNAME_ varchar(255) null, ACTION_ numeric(19,0) null, GRAPHELEMENTTYPE_ varchar(255) null, GRAPHELEMENT_ numeric(19,0) null, NODE_ numeric(19,0) null, primary key (ID_)) lock datarows
create table JBPM_LOG (ID_ numeric(19,0) identity not null, CLASS_ char(1) not null, INDEX_ int null, DATE_ datetime null, TOKEN_ numeric(19,0) null, PARENT_ numeric(19,0) null, MESSAGE_ varchar(4000) null, EXCEPTION_ text null, ACTION_ numeric(19,0) null, NODE_ numeric(19,0) null, ENTER_ datetime null, LEAVE_ datetime null, DURATION_ numeric(19,0) null, NEWLONGVALUE_ numeric(19,0) null, TRANSITION_ numeric(19,0) null, CHILD_ numeric(19,0) null, SOURCENODE_ numeric(19,0) null, DESTINATIONNODE_ numeric(19,0) null, VARIABLEINSTANCE_ numeric(19,0) null, OLDBYTEARRAY_ numeric(19,0) null, NEWBYTEARRAY_ numeric(19,0) null, OLDDATEVALUE_ datetime null, NEWDATEVALUE_ datetime null, OLDDOUBLEVALUE_ double precision null, NEWDOUBLEVALUE_ double precision null, OLDLONGIDCLASS_ varchar(255) null, OLDLONGIDVALUE_ numeric(19,0) null, NEWLONGIDCLASS_ varchar(255) null, NEWLONGIDVALUE_ numeric(19,0) null, OLDSTRINGIDCLASS_ varchar(255) null, OLDSTRINGIDVALUE_ varchar(255) null, NEWSTRINGIDCLASS_ varchar(255) null, NEWSTRINGIDVALUE_ varchar(255) null, OLDLONGVALUE_ numeric(19,0) null, OLDSTRINGVALUE_ varchar(4000) null, NEWSTRINGVALUE_ varchar(4000) null, TASKINSTANCE_ numeric(19,0) null, TASKACTORID_ varchar(255) null, TASKOLDACTORID_ varchar(255) null, SWIMLANEINSTANCE_ numeric(19,0) null, primary key (ID_)) lock datarows
create table JBPM_MODULEDEFINITION (ID_ numeric(19,0) identity not null, CLASS_ char(1) not null, NAME_ varchar(4000) null, PROCESSDEFINITION_ numeric(19,0) null, STARTTASK_ numeric(19,0) null, primary key (ID_)) lock datarows
create table JBPM_MODULEINSTANCE (ID_ numeric(19,0) identity not null, CLASS_ char(1) not null, VERSION_ int not null, PROCESSINSTANCE_ numeric(19,0) null, TASKMGMTDEFINITION_ numeric(19,0) null, NAME_ varchar(255) null, primary key (ID_)) lock datarows
create table JBPM_NODE (ID_ numeric(19,0) identity not null, CLASS_ char(1) not null, NAME_ varchar(255) null, DESCRIPTION_ varchar(4000) null, PROCESSDEFINITION_ numeric(19,0) null, ISASYNC_ tinyint null, ISASYNCEXCL_ tinyint null, ACTION_ numeric(19,0) null, SUPERSTATE_ numeric(19,0) null, SUBPROCNAME_ varchar(255) null, SUBPROCESSDEFINITION_ numeric(19,0) null, DECISIONEXPRESSION_ varchar(255) null, DECISIONDELEGATION numeric(19,0) null, SCRIPT_ numeric(19,0) null, SIGNAL_ int null, CREATETASKS_ tinyint null, ENDTASKS_ tinyint null, NODECOLLECTIONINDEX_ int null, primary key (ID_)) lock datarows
create table JBPM_POOLEDACTOR (ID_ numeric(19,0) identity not null, VERSION_ int not null, ACTORID_ varchar(255) null, SWIMLANEINSTANCE_ numeric(19,0) null, primary key (ID_)) lock datarows
create table JBPM_PROCESSDEFINITION (ID_ numeric(19,0) identity not null, CLASS_ char(1) not null, NAME_ varchar(255) null, DESCRIPTION_ varchar(4000) null, VERSION_ int null, ISTERMINATIONIMPLICIT_ tinyint null, STARTSTATE_ numeric(19,0) null, primary key (ID_)) lock datarows
create table JBPM_PROCESSINSTANCE (ID_ numeric(19,0) identity not null, VERSION_ int not null, KEY_ varchar(255) null, START_ datetime null, END_ datetime null, ISSUSPENDED_ tinyint null, PROCESSDEFINITION_ numeric(19,0) null, ROOTTOKEN_ numeric(19,0) null, SUPERPROCESSTOKEN_ numeric(19,0) null, primary key (ID_)) lock datarows
create table JBPM_RUNTIMEACTION (ID_ numeric(19,0) identity not null, VERSION_ int not null, EVENTTYPE_ varchar(255) null, TYPE_ char(1) null, GRAPHELEMENT_ numeric(19,0) null, PROCESSINSTANCE_ numeric(19,0) null, ACTION_ numeric(19,0) null, PROCESSINSTANCEINDEX_ int null, primary key (ID_)) lock datarows
create table JBPM_SWIMLANE (ID_ numeric(19,0) identity not null, NAME_ varchar(255) null, ACTORIDEXPRESSION_ varchar(255) null, POOLEDACTORSEXPRESSION_ varchar(255) null, ASSIGNMENTDELEGATION_ numeric(19,0) null, TASKMGMTDEFINITION_ numeric(19,0) null, primary key (ID_)) lock datarows
create table JBPM_SWIMLANEINSTANCE (ID_ numeric(19,0) identity not null, VERSION_ int not null, NAME_ varchar(255) null, ACTORID_ varchar(255) null, SWIMLANE_ numeric(19,0) null, TASKMGMTINSTANCE_ numeric(19,0) null, primary key (ID_)) lock datarows
create table JBPM_TASK (ID_ numeric(19,0) identity not null, NAME_ varchar(255) null, DESCRIPTION_ varchar(4000) null, PROCESSDEFINITION_ numeric(19,0) null, ISBLOCKING_ tinyint null, ISSIGNALLING_ tinyint null, CONDITION_ varchar(255) null, DUEDATE_ varchar(255) null, PRIORITY_ int null, ACTORIDEXPRESSION_ varchar(255) null, POOLEDACTORSEXPRESSION_ varchar(255) null, TASKMGMTDEFINITION_ numeric(19,0) null, TASKNODE_ numeric(19,0) null, STARTSTATE_ numeric(19,0) null, ASSIGNMENTDELEGATION_ numeric(19,0) null, SWIMLANE_ numeric(19,0) null, TASKCONTROLLER_ numeric(19,0) null, primary key (ID_)) lock datarows
create table JBPM_TASKACTORPOOL (TASKINSTANCE_ numeric(19,0) not null, POOLEDACTOR_ numeric(19,0) not null, primary key (TASKINSTANCE_, POOLEDACTOR_)) lock datarows
create table JBPM_TASKCONTROLLER (ID_ numeric(19,0) identity not null, TASKCONTROLLERDELEGATION_ numeric(19,0) null, primary key (ID_)) lock datarows
create table JBPM_TASKINSTANCE (ID_ numeric(19,0) identity not null, CLASS_ char(1) not null, VERSION_ int not null, NAME_ varchar(255) null, DESCRIPTION_ varchar(4000) null, ACTORID_ varchar(255) null, CREATE_ datetime null, START_ datetime null, END_ datetime null, DUEDATE_ datetime null, PRIORITY_ int null, ISCANCELLED_ tinyint null, ISSUSPENDED_ tinyint null, ISOPEN_ tinyint null, ISSIGNALLING_ tinyint null, ISBLOCKING_ tinyint null, TASK_ numeric(19,0) null, TOKEN_ numeric(19,0) null, PROCINST_ numeric(19,0) null, SWIMLANINSTANCE_ numeric(19,0) null, TASKMGMTINSTANCE_ numeric(19,0) null, primary key (ID_)) lock datarows
create table JBPM_TOKEN (ID_ numeric(19,0) identity not null, VERSION_ int not null, NAME_ varchar(255) null, START_ datetime null, END_ datetime null, NODEENTER_ datetime null, NEXTLOGINDEX_ int null, ISABLETOREACTIVATEPARENT_ tinyint null, ISTERMINATIONIMPLICIT_ tinyint null, ISSUSPENDED_ tinyint null, LOCK_ varchar(255) null, NODE_ numeric(19,0) null, PROCESSINSTANCE_ numeric(19,0) null, PARENT_ numeric(19,0) null, SUBPROCESSINSTANCE_ numeric(19,0) null, primary key (ID_)) lock datarows
create table JBPM_TOKENVARIABLEMAP (ID_ numeric(19,0) identity not null, VERSION_ int not null, TOKEN_ numeric(19,0) null, CONTEXTINSTANCE_ numeric(19,0) null, primary key (ID_)) lock datarows
create table JBPM_TRANSITION (ID_ numeric(19,0) identity not null, NAME_ varchar(255) null, DESCRIPTION_ varchar(4000) null, PROCESSDEFINITION_ numeric(19,0) null, FROM_ numeric(19,0) null, TO_ numeric(19,0) null, CONDITION_ varchar(255) null, FROMINDEX_ int null, primary key (ID_)) lock datarows
create table JBPM_VARIABLEACCESS (ID_ numeric(19,0) identity not null, VARIABLENAME_ varchar(255) null, ACCESS_ varchar(255) null, MAPPEDNAME_ varchar(255) null, SCRIPT_ numeric(19,0) null, PROCESSSTATE_ numeric(19,0) null, TASKCONTROLLER_ numeric(19,0) null, INDEX_ int null, primary key (ID_)) lock datarows
create table JBPM_VARIABLEINSTANCE (ID_ numeric(19,0) identity not null, CLASS_ char(1) not null, VERSION_ int not null, NAME_ varchar(255) null, CONVERTER_ char(1) null, TOKEN_ numeric(19,0) null, TOKENVARIABLEMAP_ numeric(19,0) null, PROCESSINSTANCE_ numeric(19,0) null, BYTEARRAYVALUE_ numeric(19,0) null, DATEVALUE_ datetime null, DOUBLEVALUE_ double precision null, LONGIDCLASS_ varchar(255) null, LONGVALUE_ numeric(19,0) null, STRINGIDCLASS_ varchar(255) null, STRINGVALUE_ varchar(4000) null, TASKINSTANCE_ numeric(19,0) null, primary key (ID_)) lock datarows
create index IDX_ACTION_REFACT on JBPM_ACTION (REFERENCEDACTION_)
create index IDX_ACTION_EVENT on JBPM_ACTION (EVENT_)
create index IDX_ACTION_ACTNDL on JBPM_ACTION (ACTIONDELEGATION_)
create index IDX_ACTION_PROCDF on JBPM_ACTION (PROCESSDEFINITION_)
create index IDX_CRTETIMERACT_TA on JBPM_ACTION (TIMERACTION_)
alter table JBPM_ACTION add constraint FK_ACTION_EVENT foreign key (EVENT_) references JBPM_EVENT
alter table JBPM_ACTION add constraint FK_ACTION_EXPTHDL foreign key (EXCEPTIONHANDLER_) references JBPM_EXCEPTIONHANDLER
alter table JBPM_ACTION add constraint FK_ACTION_PROCDEF foreign key (PROCESSDEFINITION_) references JBPM_PROCESSDEFINITION
alter table JBPM_ACTION add constraint FK_CRTETIMERACT_TA foreign key (TIMERACTION_) references JBPM_ACTION
alter table JBPM_ACTION add constraint FK_ACTION_ACTNDEL foreign key (ACTIONDELEGATION_) references JBPM_DELEGATION
alter table JBPM_ACTION add constraint FK_ACTION_REFACT foreign key (REFERENCEDACTION_) references JBPM_ACTION
alter table JBPM_BYTEARRAY add constraint FK_BYTEARR_FILDEF foreign key (FILEDEFINITION_) references JBPM_MODULEDEFINITION
alter table JBPM_BYTEBLOCK add constraint FK_BYTEBLOCK_FILE foreign key (PROCESSFILE_) references JBPM_BYTEARRAY
create index IDX_COMMENT_TOKEN on JBPM_COMMENT (TOKEN_)
create index IDX_COMMENT_TSK on JBPM_COMMENT (TASKINSTANCE_)
alter table JBPM_COMMENT add constraint FK_COMMENT_TOKEN foreign key (TOKEN_) references JBPM_TOKEN
alter table JBPM_COMMENT add constraint FK_COMMENT_TSK foreign key (TASKINSTANCE_) references JBPM_TASKINSTANCE
alter table JBPM_DECISIONCONDITIONS add constraint FK_DECCOND_DEC foreign key (DECISION_) references JBPM_NODE
create index IDX_DELEG_PRCD on JBPM_DELEGATION (PROCESSDEFINITION_)
alter table JBPM_DELEGATION add constraint FK_DELEGATION_PRCD foreign key (PROCESSDEFINITION_) references JBPM_PROCESSDEFINITION
alter table JBPM_EVENT add constraint FK_EVENT_PROCDEF foreign key (PROCESSDEFINITION_) references JBPM_PROCESSDEFINITION
alter table JBPM_EVENT add constraint FK_EVENT_NODE foreign key (NODE_) references JBPM_NODE
alter table JBPM_EVENT add constraint FK_EVENT_TRANS foreign key (TRANSITION_) references JBPM_TRANSITION
alter table JBPM_EVENT add constraint FK_EVENT_TASK foreign key (TASK_) references JBPM_TASK
alter table JBPM_ID_GROUP add constraint FK_ID_GRP_PARENT foreign key (PARENT_) references JBPM_ID_GROUP
alter table JBPM_ID_MEMBERSHIP add constraint FK_ID_MEMSHIP_GRP foreign key (GROUP_) references JBPM_ID_GROUP
alter table JBPM_ID_MEMBERSHIP add constraint FK_ID_MEMSHIP_USR foreign key (USER_) references JBPM_ID_USER
create index IDX_JOB_NODE on JBPM_JOB (NODE_)
create index IDX_JOB_ACTION on JBPM_JOB (ACTION_)
create index IDX_JOB_TSKINST on JBPM_JOB (TASKINSTANCE_)
create index IDX_JOB_PRINST on JBPM_JOB (PROCESSINSTANCE_)
create index IDX_JOB_TOKEN on JBPM_JOB (TOKEN_)
alter table JBPM_JOB add constraint FK_JOB_TOKEN foreign key (TOKEN_) references JBPM_TOKEN
alter table JBPM_JOB add constraint FK_JOB_NODE foreign key (NODE_) references JBPM_NODE
alter table JBPM_JOB add constraint FK_JOB_PRINST foreign key (PROCESSINSTANCE_) references JBPM_PROCESSINSTANCE
alter table JBPM_JOB add constraint FK_JOB_ACTION foreign key (ACTION_) references JBPM_ACTION
alter table JBPM_JOB add constraint FK_JOB_TSKINST foreign key (TASKINSTANCE_) references JBPM_TASKINSTANCE
create index IDX_LOG_NEWBYTES on JBPM_LOG (NEWBYTEARRAY_)
create index IDX_LOG_NODE on JBPM_LOG (NODE_)
create index IDX_LOG_TASKINST on JBPM_LOG (TASKINSTANCE_)
create index IDX_LOG_TRANSITION on JBPM_LOG (TRANSITION_)
create index IDX_LOG_DESTNODE on JBPM_LOG (DESTINATIONNODE_)
create index IDX_LOG_CHILDTOKEN on JBPM_LOG (CHILD_)
create index IDX_LOG_TOKEN on JBPM_LOG (TOKEN_)
create index IDX_LOG_SWIMINST on JBPM_LOG (SWIMLANEINSTANCE_)
create index IDX_LOG_PARENT on JBPM_LOG (PARENT_)
create index IDX_LOG_VARINST on JBPM_LOG (VARIABLEINSTANCE_)
create index IDX_LOG_ACTION on JBPM_LOG (ACTION_)
create index IDX_LOG_SOURCENODE on JBPM_LOG (SOURCENODE_)
create index IDX_LOG_OLDBYTES on JBPM_LOG (OLDBYTEARRAY_)
alter table JBPM_LOG add constraint FK_LOG_SOURCENODE foreign key (SOURCENODE_) references JBPM_NODE
alter table JBPM_LOG add constraint FK_LOG_TOKEN foreign key (TOKEN_) references JBPM_TOKEN
alter table JBPM_LOG add constraint FK_LOG_OLDBYTES foreign key (OLDBYTEARRAY_) references JBPM_BYTEARRAY
alter table JBPM_LOG add constraint FK_LOG_NEWBYTES foreign key (NEWBYTEARRAY_) references JBPM_BYTEARRAY
alter table JBPM_LOG add constraint FK_LOG_CHILDTOKEN foreign key (CHILD_) references JBPM_TOKEN
alter table JBPM_LOG add constraint FK_LOG_DESTNODE foreign key (DESTINATIONNODE_) references JBPM_NODE
alter table JBPM_LOG add constraint FK_LOG_TASKINST foreign key (TASKINSTANCE_) references JBPM_TASKINSTANCE
alter table JBPM_LOG add constraint FK_LOG_SWIMINST foreign key (SWIMLANEINSTANCE_) references JBPM_SWIMLANEINSTANCE
alter table JBPM_LOG add constraint FK_LOG_PARENT foreign key (PARENT_) references JBPM_LOG
alter table JBPM_LOG add constraint FK_LOG_NODE foreign key (NODE_) references JBPM_NODE
alter table JBPM_LOG add constraint FK_LOG_ACTION foreign key (ACTION_) references JBPM_ACTION
alter table JBPM_LOG add constraint FK_LOG_VARINST foreign key (VARIABLEINSTANCE_) references JBPM_VARIABLEINSTANCE
alter table JBPM_LOG add constraint FK_LOG_TRANSITION foreign key (TRANSITION_) references JBPM_TRANSITION
create index IDX_TSKDEF_START on JBPM_MODULEDEFINITION (STARTTASK_)
create index IDX_MODDEF_PROCDF on JBPM_MODULEDEFINITION (PROCESSDEFINITION_)
alter table JBPM_MODULEDEFINITION add constraint FK_TSKDEF_START foreign key (STARTTASK_) references JBPM_TASK
alter table JBPM_MODULEDEFINITION add constraint FK_MODDEF_PROCDEF foreign key (PROCESSDEFINITION_) references JBPM_PROCESSDEFINITION
create index IDX_TASKMGTINST_TMD on JBPM_MODULEINSTANCE (TASKMGMTDEFINITION_)
create index IDX_MODINST_PRINST on JBPM_MODULEINSTANCE (PROCESSINSTANCE_)
alter table JBPM_MODULEINSTANCE add constraint FK_TASKMGTINST_TMD foreign key (TASKMGMTDEFINITION_) references JBPM_MODULEDEFINITION
alter table JBPM_MODULEINSTANCE add constraint FK_MODINST_PRCINST foreign key (PROCESSINSTANCE_) references JBPM_PROCESSINSTANCE
create index IDX_PSTATE_SBPRCDEF on JBPM_NODE (SUBPROCESSDEFINITION_)
create index IDX_NODE_SCRIPT on JBPM_NODE (SCRIPT_)
create index IDX_NODE_SUPRSTATE on JBPM_NODE (SUPERSTATE_)
create index IDX_NODE_PROCDEF on JBPM_NODE (PROCESSDEFINITION_)
create index IDX_DECISION_DELEG on JBPM_NODE (DECISIONDELEGATION)
create index IDX_NODE_ACTION on JBPM_NODE (ACTION_)
alter table JBPM_NODE add constraint FK_PROCST_SBPRCDEF foreign key (SUBPROCESSDEFINITION_) references JBPM_PROCESSDEFINITION
alter table JBPM_NODE add constraint FK_NODE_PROCDEF foreign key (PROCESSDEFINITION_) references JBPM_PROCESSDEFINITION
alter table JBPM_NODE add constraint FK_NODE_SCRIPT foreign key (SCRIPT_) references JBPM_ACTION
alter table JBPM_NODE add constraint FK_NODE_ACTION foreign key (ACTION_) references JBPM_ACTION
alter table JBPM_NODE add constraint FK_DECISION_DELEG foreign key (DECISIONDELEGATION) references JBPM_DELEGATION
alter table JBPM_NODE add constraint FK_NODE_SUPERSTATE foreign key (SUPERSTATE_) references JBPM_NODE
create index IDX_PLDACTR_ACTID on JBPM_POOLEDACTOR (ACTORID_)
create index IDX_TSKINST_SWLANE on JBPM_POOLEDACTOR (SWIMLANEINSTANCE_)
alter table JBPM_POOLEDACTOR add constraint FK_POOLEDACTOR_SLI foreign key (SWIMLANEINSTANCE_) references JBPM_SWIMLANEINSTANCE
create index IDX_PROCDEF_STRTST on JBPM_PROCESSDEFINITION (STARTSTATE_)
alter table JBPM_PROCESSDEFINITION add constraint FK_PROCDEF_STRTSTA foreign key (STARTSTATE_) references JBPM_NODE
create index IDX_PROCIN_ROOTTK on JBPM_PROCESSINSTANCE (ROOTTOKEN_)
create index IDX_PROCIN_SPROCTK on JBPM_PROCESSINSTANCE (SUPERPROCESSTOKEN_)
create index IDX_PROCIN_KEY on JBPM_PROCESSINSTANCE (KEY_)
create index IDX_PROCIN_PROCDEF on JBPM_PROCESSINSTANCE (PROCESSDEFINITION_)
alter table JBPM_PROCESSINSTANCE add constraint FK_PROCIN_PROCDEF foreign key (PROCESSDEFINITION_) references JBPM_PROCESSDEFINITION
alter table JBPM_PROCESSINSTANCE add constraint FK_PROCIN_ROOTTKN foreign key (ROOTTOKEN_) references JBPM_TOKEN
alter table JBPM_PROCESSINSTANCE add constraint FK_PROCIN_SPROCTKN foreign key (SUPERPROCESSTOKEN_) references JBPM_TOKEN
create index IDX_RTACTN_PRCINST on JBPM_RUNTIMEACTION (PROCESSINSTANCE_)
create index IDX_RTACTN_ACTION on JBPM_RUNTIMEACTION (ACTION_)
alter table JBPM_RUNTIMEACTION add constraint FK_RTACTN_PROCINST foreign key (PROCESSINSTANCE_) references JBPM_PROCESSINSTANCE
alter table JBPM_RUNTIMEACTION add constraint FK_RTACTN_ACTION foreign key (ACTION_) references JBPM_ACTION
create index IDX_SWL_TSKMGMTDEF on JBPM_SWIMLANE (TASKMGMTDEFINITION_)
create index IDX_SWL_ASSDEL on JBPM_SWIMLANE (ASSIGNMENTDELEGATION_)
alter table JBPM_SWIMLANE add constraint FK_SWL_ASSDEL foreign key (ASSIGNMENTDELEGATION_) references JBPM_DELEGATION
alter table JBPM_SWIMLANE add constraint FK_SWL_TSKMGMTDEF foreign key (TASKMGMTDEFINITION_) references JBPM_MODULEDEFINITION
create index IDX_SWIMLINST_SL on JBPM_SWIMLANEINSTANCE (SWIMLANE_)
create index IDX_SWIMLANEINST_TM on JBPM_SWIMLANEINSTANCE (TASKMGMTINSTANCE_)
alter table JBPM_SWIMLANEINSTANCE add constraint FK_SWIMLANEINST_TM foreign key (TASKMGMTINSTANCE_) references JBPM_MODULEINSTANCE
alter table JBPM_SWIMLANEINSTANCE add constraint FK_SWIMLANEINST_SL foreign key (SWIMLANE_) references JBPM_SWIMLANE
create index IDX_TASK_STARTST on JBPM_TASK (STARTSTATE_)
create index IDX_TASK_SWIMLANE on JBPM_TASK (SWIMLANE_)
create index IDX_TSK_TSKCTRL on JBPM_TASK (TASKCONTROLLER_)
create index IDX_TASK_ASSDEL on JBPM_TASK (ASSIGNMENTDELEGATION_)
create index IDX_TASK_TSKNODE on JBPM_TASK (TASKNODE_)
create index IDX_TASK_PROCDEF on JBPM_TASK (PROCESSDEFINITION_)
create index IDX_TASK_TASKMGTDF on JBPM_TASK (TASKMGMTDEFINITION_)
alter table JBPM_TASK add constraint FK_TSK_TSKCTRL foreign key (TASKCONTROLLER_) references JBPM_TASKCONTROLLER
alter table JBPM_TASK add constraint FK_TASK_ASSDEL foreign key (ASSIGNMENTDELEGATION_) references JBPM_DELEGATION
alter table JBPM_TASK add constraint FK_TASK_TASKNODE foreign key (TASKNODE_) references JBPM_NODE
alter table JBPM_TASK add constraint FK_TASK_PROCDEF foreign key (PROCESSDEFINITION_) references JBPM_PROCESSDEFINITION
alter table JBPM_TASK add constraint FK_TASK_STARTST foreign key (STARTSTATE_) references JBPM_NODE
alter table JBPM_TASK add constraint FK_TASK_TASKMGTDEF foreign key (TASKMGMTDEFINITION_) references JBPM_MODULEDEFINITION
alter table JBPM_TASK add constraint FK_TASK_SWIMLANE foreign key (SWIMLANE_) references JBPM_SWIMLANE
alter table JBPM_TASKACTORPOOL add constraint FK_TSKACTPOL_PLACT foreign key (POOLEDACTOR_) references JBPM_POOLEDACTOR
alter table JBPM_TASKACTORPOOL add constraint FK_TASKACTPL_TSKI foreign key (TASKINSTANCE_) references JBPM_TASKINSTANCE
create index IDX_TSKCTRL_DELEG on JBPM_TASKCONTROLLER (TASKCONTROLLERDELEGATION_)
alter table JBPM_TASKCONTROLLER add constraint FK_TSKCTRL_DELEG foreign key (TASKCONTROLLERDELEGATION_) references JBPM_DELEGATION
create index IDX_TASKINST_TOKN on JBPM_TASKINSTANCE (TOKEN_)
create index IDX_TASKINST_TSK on JBPM_TASKINSTANCE (TASK_, PROCINST_)
create index IDX_TSKINST_TMINST on JBPM_TASKINSTANCE (TASKMGMTINSTANCE_)
create index IDX_TSKINST_SLINST on JBPM_TASKINSTANCE (SWIMLANINSTANCE_)
create index IDX_TASK_ACTORID on JBPM_TASKINSTANCE (ACTORID_)
alter table JBPM_TASKINSTANCE add constraint FK_TSKINS_PRCINS foreign key (PROCINST_) references JBPM_PROCESSINSTANCE
alter table JBPM_TASKINSTANCE add constraint FK_TASKINST_TMINST foreign key (TASKMGMTINSTANCE_) references JBPM_MODULEINSTANCE
alter table JBPM_TASKINSTANCE add constraint FK_TASKINST_TOKEN foreign key (TOKEN_) references JBPM_TOKEN
alter table JBPM_TASKINSTANCE add constraint FK_TASKINST_SLINST foreign key (SWIMLANINSTANCE_) references JBPM_SWIMLANEINSTANCE
alter table JBPM_TASKINSTANCE add constraint FK_TASKINST_TASK foreign key (TASK_) references JBPM_TASK
create index IDX_TOKEN_PROCIN on JBPM_TOKEN (PROCESSINSTANCE_)
create index IDX_TOKEN_SUBPI on JBPM_TOKEN (SUBPROCESSINSTANCE_)
create index IDX_TOKEN_NODE on JBPM_TOKEN (NODE_)
create index IDX_TOKEN_PARENT on JBPM_TOKEN (PARENT_)
alter table JBPM_TOKEN add constraint FK_TOKEN_PARENT foreign key (PARENT_) references JBPM_TOKEN
alter table JBPM_TOKEN add constraint FK_TOKEN_NODE foreign key (NODE_) references JBPM_NODE
alter table JBPM_TOKEN add constraint FK_TOKEN_PROCINST foreign key (PROCESSINSTANCE_) references JBPM_PROCESSINSTANCE
alter table JBPM_TOKEN add constraint FK_TOKEN_SUBPI foreign key (SUBPROCESSINSTANCE_) references JBPM_PROCESSINSTANCE
create index IDX_TKVARMAP_CTXT on JBPM_TOKENVARIABLEMAP (CONTEXTINSTANCE_)
create index IDX_TKVVARMP_TOKEN on JBPM_TOKENVARIABLEMAP (TOKEN_)
alter table JBPM_TOKENVARIABLEMAP add constraint FK_TKVARMAP_CTXT foreign key (CONTEXTINSTANCE_) references JBPM_MODULEINSTANCE
alter table JBPM_TOKENVARIABLEMAP add constraint FK_TKVARMAP_TOKEN foreign key (TOKEN_) references JBPM_TOKEN
create index IDX_TRANSIT_TO on JBPM_TRANSITION (TO_)
create index IDX_TRANSIT_FROM on JBPM_TRANSITION (FROM_)
create index IDX_TRANS_PROCDEF on JBPM_TRANSITION (PROCESSDEFINITION_)
alter table JBPM_TRANSITION add constraint FK_TRANSITION_TO foreign key (TO_) references JBPM_NODE
alter table JBPM_TRANSITION add constraint FK_TRANS_PROCDEF foreign key (PROCESSDEFINITION_) references JBPM_PROCESSDEFINITION
alter table JBPM_TRANSITION add constraint FK_TRANSITION_FROM foreign key (FROM_) references JBPM_NODE
alter table JBPM_VARIABLEACCESS add constraint FK_VARACC_TSKCTRL foreign key (TASKCONTROLLER_) references JBPM_TASKCONTROLLER
alter table JBPM_VARIABLEACCESS add constraint FK_VARACC_SCRIPT foreign key (SCRIPT_) references JBPM_ACTION
alter table JBPM_VARIABLEACCESS add constraint FK_VARACC_PROCST foreign key (PROCESSSTATE_) references JBPM_NODE
create index IDX_VARINST_TKVARMP on JBPM_VARIABLEINSTANCE (TOKENVARIABLEMAP_)
create index IDX_VARINST_PRCINS on JBPM_VARIABLEINSTANCE (PROCESSINSTANCE_)
create index IDX_BYTEINST_ARRAY on JBPM_VARIABLEINSTANCE (BYTEARRAYVALUE_)
create index IDX_VARINST_TK on JBPM_VARIABLEINSTANCE (TOKEN_)
alter table JBPM_VARIABLEINSTANCE add constraint FK_VARINST_TK foreign key (TOKEN_) references JBPM_TOKEN
alter table JBPM_VARIABLEINSTANCE add constraint FK_VARINST_TKVARMP foreign key (TOKENVARIABLEMAP_) references JBPM_TOKENVARIABLEMAP
alter table JBPM_VARIABLEINSTANCE add constraint FK_VARINST_PRCINST foreign key (PROCESSINSTANCE_) references JBPM_PROCESSINSTANCE
alter table JBPM_VARIABLEINSTANCE add constraint FK_VAR_TSKINST foreign key (TASKINSTANCE_) references JBPM_TASKINSTANCE
alter table JBPM_VARIABLEINSTANCE add constraint FK_BYTEINST_ARRAY foreign key (BYTEARRAYVALUE_) references JBPM_BYTEARRAY
