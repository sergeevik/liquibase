package liquibase.extension.testing.command

CommandTests.define {
    command = ["rollbackToDate"]
    signature = """
Short Description: Rollback changes made to the database based on the specific date
Long Description: NOT SET
Required Args:
  date (LocalDateTime) Date to rollback changes to
  url (String) The JDBC database connection URL
Optional Args:
  changelogFile (String) File to write changelog to
    Default: null
  contexts (String) Changeset contexts to match
    Default: null
  labels (String) Changeset labels to match
    Default: null
  password (String) Password to use to connect to the database
    Default: null
  rollbackScript (String) Rollback script to execute
    Default: null
  username (String) Username to use to connect to the database
    Default: null
"""

    run {
        arguments = [
                date         : "2021-03-25T09:00:00",
                changelogFile: "changelogs/hsqldb/complete/rollback.changelog.xml",
        ]

        setup {
            runChangelog "changelogs/hsqldb/complete/rollback.changelog.xml"
        }

        expectedResults = [
                statusMessage: "Successfully executed rollbackToDate",
                statusCode   : 0
        ]
    }
}