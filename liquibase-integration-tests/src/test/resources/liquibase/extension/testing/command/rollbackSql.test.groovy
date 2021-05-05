package liquibase.extension.testing.command

CommandTests.define {
    command = ["rollbackSql"]
    signature = """
Short Description: Generate the SQL to rollback changes made to the database based on the specific tag
Long Description: NOT SET
Required Args:
  tag (String) Tag to rollback to
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
                tag          : "version_2.0",
                changelogFile: "changelogs/hsqldb/complete/rollback.tag.changelog.xml",
        ]

        setup {
            runChangelog "changelogs/hsqldb/complete/rollback.tag.changelog.xml"
        }

        expectedResults = [
                statusMessage: "Successfully executed rollbackSql",
                statusCode   : 0
        ]
    }
}