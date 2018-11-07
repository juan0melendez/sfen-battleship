package server.validate;

import game.model.Validatable;

public class GameValidator
{
	/**
	 * What are the rules of the game we are playing?
	 *
	 */
	GameRules rules;

	GameValidator()
	{

	};

	/**
	 * 
	 * @param rules specifies the ruleset to be used for validation
	 */
	public void setRules(GameRules rules)
	{
		this.rules = rules;

	}

	/**
	 * 
	 * @param state
	 * @throws GameRulesException
	 */
	public void validate(Validatable state) throws GameRulesException
	{

	}
}
