package oopstudents;

/**
 * @invar The bidirectional association between a student and their teammate is consistent. 
 *      | getTeammate() == null || getTeammate().getTeammate() == this
 * @invar A student is not a teammate of themselves.
 *      | getTeammate() != this
 */
public class OOPStudent {
	
	/**
	 * @invar | teammate == null || teammate.teammate == this
	 * @invar | teammate != this
	 * @peerObject
	 */
	private OOPStudent teammate;
	
	/**
	 * @peerObject
	 */
	public OOPStudent getTeammate() { return teammate; }
	
	/**
	 * @post | getTeammate() == null
	 */
	public OOPStudent() {}

	/**
	 * @pre | other != null
	 * @pre | other != this
	 * @pre | getTeammate() == null
	 * @pre | other.getTeammate() == null
	 * @mutates | this, other
	 * @post | getTeammate() == other
	 * @post | other.getTeammate() == this
	 */
	public void startCollaboratingWith(OOPStudent other) {
		teammate = other;
		other.teammate = this;
	}
	
	/**
	 * @pre | getTeammate() != null
	 * @mutates | this
	 * @post | getTeammate() == null
	 * @post | old(getTeammate()).getTeammate() == null
	 */
	public void stopCollaboration() {
		teammate.teammate = null;
		teammate = null;
	}
	
}
